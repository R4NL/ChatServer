package collegeboys.server.Controller;

import collegeboys.server.Repository.MessageRepository;
import collegeboys.server.Repository.UsersRepository;
import collegeboys.server.entity.Message;
import collegeboys.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/enter")
    public String hello(){
        return "test";
    }

    public List<User>getUsers(){
        return usersRepository.findAll();
    }

    public List<Message> getMessage(){
        return  messageRepository.findAll();
    }

    public boolean addUser(User user){
        return usersRepository.save(user)!=null;
    }

    public boolean addMessage(Message message){
        return messageRepository.save(message)!=null;
    }
}
