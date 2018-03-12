package net.anviprojects.SpringMVCProject.mvc.jstl;

import net.anviprojects.SpringMVCProject.mvc.orm.ORMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JSTLController {
    @Autowired
    private ORMService ormService;


    @RequestMapping(value = "/jstlReturnUsers", method = RequestMethod.GET)
    public ModelAndView listUsers(){
        return new ModelAndView("jstl/jstl", "resultObject", ormService.queryFindAllUsersJPA());
    }

    @RequestMapping(value = "/jstlUser", method = RequestMethod.GET)
    public ModelAndView getUser(){
        return new ModelAndView("jstl/jstl", "resultObject", ormService.queryFindUserById(1));
    }

    @RequestMapping(value = "/jstlHTML", method = RequestMethod.GET)
    public ModelAndView returnHTML(){
        return new ModelAndView("jstl/jstl", "resultObject", "<font color='red'><b>Test Color Red</b></font>");
    }

}
