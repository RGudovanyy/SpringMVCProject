package net.anviprojects.SpringMVCProject.mvc.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class FileUploadController {

	/*
		@RequestMapping предназначена для того, чтобы задать методам контроллера адреса, по которым они будут доступны на клиенте. Можно повесить как на
		контроллер целиком (тогда указывается "каталог", в котором располагаются все методы контроллера) или на отдельный метод
		@ResponseBody - если указать эту аннтоацию перед методом, то результат работы метода будет возвращен в тело HTTP response
		@RequestParam позволяет получить значение параметра из HTTP request по его имени
	    ---------------------------------------------------------------------------------
	    MultipartFile - представление загруженного файла, может располагаться как в памяти, так и во временном хранилище на диске. По окончании процесса
	    request-а временное хранилище очищается

	 */

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String handleFileUpload(@RequestParam("file")MultipartFile file){
		if (!file.isEmpty()){
			try{
				byte[] bytes = file.getBytes();
				String rootPath = System.getProperty("catalina.home");
				System.out.println("Server rootPath: " + rootPath);
				System.out.println("File original name: "  + file.getOriginalFilename());
				System.out.println("File content type: " + file.getContentType());

				String fileName = rootPath + File.separator + file.getOriginalFilename();
				File newFile = new File(fileName);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile));
				stream.write(bytes);
				stream.close();

				System.out.println("File is saved under: " + fileName);
				return "File is saved under: " + fileName;

			} catch (IOException e) {
				e.printStackTrace();
				return "File upload is failed: " + e.getMessage();
			}
		}
		return "File upload is failed: file is empty";
	}
}
