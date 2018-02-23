package net.anviprojects.SpringMVCProject.mvc.email;

import org.apache.commons.collections.CollectionUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;


/*
	JavaMailSender - интерфейс для реализации возможности отправки почты по протоколу SMTP
	MimeMessagePreparator - интерфейс для подготовки JavaMail MIME сообщений
	MimeMessageHelper - хелпер для заполнения MIME сообщения
 */

public class EmailService {

	public static final String FROM = "from";
	public static final String TO = "to";
	public static final String SUBJECT = "subject";
	public static final String BCC_LIST = "bccList";
	public static final String CCC_LIST = "cccList";

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private VelocityEngine velocityEngine;
	// создаем письмо на основании модели, и отправляем его
	public boolean sendEmail(final String templateName, final Map<String, Object> model){
		boolean res = false;
		try {
			MimeMessagePreparator preparator = mimeMessage -> {
				String from = (String) model.get(FROM);
				String to = (String) model.get(TO);
				String subject = (String) model.get(SUBJECT);

				List<String> bccList = (List<String>) model.get(BCC_LIST);
				// передавать кодировку обязательно, т.к. в противном случае будет затруднительно работать с русскими символами
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage,"UTF-8");
				message.setFrom(from);
				message.setTo(to);
				message.setSubject(subject);
				message.setSentDate(new Date());
				if (CollectionUtils.isNotEmpty(bccList)){
					for (String bcc : bccList){
						message.addBcc(bcc);
					}
				}
				model.put("noArgs", new Object());
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateName, "UTF-8",model);
				message.setText(text, true);
			};
			mailSender.send(preparator);
			res = true;
		} catch (Exception e){
			e.printStackTrace();
		}
		return res;
	}

}
