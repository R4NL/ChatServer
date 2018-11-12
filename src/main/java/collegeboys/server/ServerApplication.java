package collegeboys.server;



import collegeboys.server.Server.ChatServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;


@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
        ChatServer chatServer =new ChatServer();
        chatServer.serverStart();
    }
}
