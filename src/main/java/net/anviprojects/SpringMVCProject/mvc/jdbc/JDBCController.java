package net.anviprojects.SpringMVCProject.mvc.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JDBCController {

	@Autowired
	JDBCExample jdbcExample;

	public ModelAndView jdbcSelectAllUsers(){

	}


}
