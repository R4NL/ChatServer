package collegeboys.server.Controller;

import collegeboys.server.Repository.MessageRepository;
import collegeboys.server.Repository.UsersRepository;
import collegeboys.server.entity.Message;
import collegeboys.server.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;



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
    public String enter(Model model, @ModelAttribute("Login") String login,
                        @ModelAttribute("Password") String password) {
        List<Person> list = usersRepository.findAll();
        for (Person i : list) {
            if ((i.getUserName().equals(login)) && (i.getPassword().equals(password))) {
                model.addAttribute("login", login);
                return "chat/mainChatFile";
            }
        }
        return "connect/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        return "connect/registre";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerTwo(@ModelAttribute("Login") String login, @ModelAttribute("Password") String password,
                              @ModelAttribute("PasswordRepite") String passwordRepite) {
        if (password.equals(passwordRepite)) {
            Person user = new Person(login, password);
//            if (usersRepository.findAll().contains(user)) {
//                return "connect/registre";
//            } else {
                usersRepository.save(user);
                return "connect/login";
            //}
        } else {
            return "connect/registre";
        }
    }


    public  List<Message> getMessageList(){
        return messageRepository.findAll();
    }
}
