package net.anviprojects.SpringMVCProject.mvc.jdbc;

import net.anviprojects.SpringMVCProject.mvc.bean.DBLog;
import net.anviprojects.SpringMVCProject.mvc.bean.User;
import org.springframework.aop.interceptor.ExposeBeanNameAdvisors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JDBCController {

	@Autowired
	JDBCExample jdbcExample;

	@RequestMapping(value = "/jdbcQueryAllUsers", method = RequestMethod.GET)
	public ModelAndView jdbcSelectAllUsers(){
		System.out.println("JDBCController: jdbcSelectAllUsers() is called");
        List<User> users = jdbcExample.queryAllUsers();
        return new ModelAndView("jdbc/jdbc", "resultObject", users);
	}

	@RequestMapping(value = "/jdbcInsert/logstring/{logstring}", method = RequestMethod.GET)
	public ModelAndView jdbcInsert(@PathVariable(value = "logstring") String logstring){
        System.out.println("JDBCController: jdbcInsert() is called");
        DBLog dbLog = new DBLog();
        dbLog.setLOGSTRING(logstring);
        boolean result = jdbcExample.insertLog(dbLog);
        return new ModelAndView("jdbc/jdbc", "resultObject", result);
    }

    @RequestMapping(value = "/jdbcSelectLogs", method = RequestMethod.GET)
    public ModelAndView jdbcSelect(){
        System.out.println("JDBCController: jdbcSelect() is called");
        List<DBLog> logs = jdbcExample.queryAllLogs();
        return new ModelAndView("jdbc/jdbc", "resultObject", logs);
    }

    @RequestMapping(value = "/jdbcDelete/user/{iduser}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable(value = "iduser") int userId){
        System.out.println("JDBCController: deleteUser() is called");
        boolean result = jdbcExample.deleteUser(userId);
        return new ModelAndView("jdbc/jdbc", "resultObject", result);
    }

    @RequestMapping(value = "/jdbcUpdate/user/username/{username}/enabled/{enabled}", method = RequestMethod.GET)
    public ModelAndView jdbcUpdate(@PathVariable(value = "username") String username, @PathVariable(value = "enabled") boolean enabled){
        System.out.println("JDBCController: jdbcUpdate() is called");
        User user = new User();
        user.setUsername(username);
        boolean result = jdbcExample.updateUserEnable(user, enabled);
        return new ModelAndView("jdbc/jdbc", "resultObject", result);
    }





}
