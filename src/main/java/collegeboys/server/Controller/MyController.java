package collegeboys.server.Controller;

import collegeboys.server.Repository.MessageRepository;
import collegeboys.server.Repository.UsersRepository;
import collegeboys.server.entity.Message;
import collegeboys.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MyController {
    private UsersRepository usersRepository;
    private MessageRepository messageRepository;

    public MyController() {
    }

    @Autowired
    public MyController(UsersRepository usersRepository, MessageRepository messageRepository) {
        this.usersRepository = usersRepository;
        this.messageRepository = messageRepository;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String start(){
        return "start";
    }

    @RequestMapping(value = "/enter",method = RequestMethod.GET)
    public String enter(Model model){

        return "connect/login";
    }

}
