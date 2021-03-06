package net.anviprojects.SpringMVCProject.mvc.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EmailController {

	@Autowired
	EmailService emailService;

	@RequestMapping(value = "/email/send", method = RequestMethod.POST)
	public ModelAndView email(@ModelAttribute("emailModel") EmailModel emailModel){
		System.out.println("EmailController email is called");
		Map<String, Object> model = new HashMap<>();
		model.put(EmailService.FROM, "anviprojects@mvc.app");
		model.put(EmailService.SUBJECT, "Hello from " + emailModel.getName() + "!");
		model.put(EmailService.TO, emailModel.getEmail());
		model.put(EmailService.CCC_LIST, new ArrayList<>());
		model.put(EmailService.BCC_LIST, new ArrayList<>());
		model.put("userName","Anvi");
		model.put("url", "anviprojects.net");
		model.put("message", emailModel.getMessage());
		boolean result = emailService.sendEmail("registered.vm",model);
		return new ModelAndView("redirect:/email.html", "resultSending", result);
	}
}
