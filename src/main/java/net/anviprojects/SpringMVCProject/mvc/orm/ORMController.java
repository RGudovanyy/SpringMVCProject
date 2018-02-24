package net.anviprojects.SpringMVCProject.mvc.orm;

import net.anviprojects.SpringMVCProject.mvc.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ORMController {

    @Autowired
    private ORMService ormService;

    @RequestMapping(value = "/ormFindAllUsers", method = RequestMethod.GET)
    public ModelAndView ormFindAllUsers(){
        List<User> users = ormService.queryFindAllUsersJPA();
        return new ModelAndView("/orm/orm", "resultObject", users);
    }

    @RequestMapping(value = "queryFindByIdUser/{userid}", method = RequestMethod.GET)
    public ModelAndView queryFindByIdUser(@PathVariable("userid")int id){
        User user = ormService.queryFindUserById(id);
        return new ModelAndView("/orm/orm", "resultObject", user);
    }

    @RequestMapping(value = "ormUpdateUser/iduser/{iduser}/enabled/{enabled}", method = RequestMethod.GET)
    public ModelAndView ormUpdateUser(@PathVariable("iduser") int id, @PathVariable("enabled") boolean enabled){
        return new ModelAndView("/orm/orm", "resultObject", ormService.updateUser(id, enabled));
    }

    @RequestMapping(value = "ormDeleteUser/iduser/{iduser}", method = RequestMethod.GET)
    public ModelAndView ormDeleteUser(@PathVariable("iduser") int id){
        return new ModelAndView("/orm/orm", "resultObject", ormService.deleteUser(id));
    }

    @RequestMapping(value = "ormInsertUser/username/{username}/password/{password}/enabled/{enabled}", method = RequestMethod.GET)
    public ModelAndView ormInsertUser(@PathVariable("username") String username,
                                      @PathVariable("password") String password,
                                      @PathVariable("enabled") boolean enabled){
        return new ModelAndView("/orm/orm", "resultObject", ormService.insertUser(username, password, enabled));
    }
}
