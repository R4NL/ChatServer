package collegeboys.server.Controller;

import collegeboys.server.Repository.MessageRepository;
import collegeboys.server.Repository.UsersRepository;
import collegeboys.server.entity.Message;
import collegeboys.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class StartController {
    private UsersRepository usersRepository;
    private MessageRepository messageRepository;

    public StartController() {
    }

    @Autowired
    public StartController(UsersRepository usersRepository, MessageRepository messageRepository) {
        this.usersRepository = usersRepository;
        this.messageRepository = messageRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start() {
        return "start";
    }

    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public String enter(Model model,@ModelAttribute("Login") String login,
                        @ModelAttribute("Password") String password) {
        List<User> list=usersRepository.findAll();
        for (User i:list) {
            if ((i.getUserName().equals(login))&&(i.getPassword().equals(password))){
                model.addAttribute("login",login);
                return "chat/mainChatFile";
            }
        }
        return "connect/login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "connect/registre";
    }

}
