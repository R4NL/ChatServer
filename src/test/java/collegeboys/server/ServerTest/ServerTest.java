package collegeboys.server.ServerTest;
import collegeboys.server.Server.ChatServer;
import collegeboys.server.entity.Message;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class ServerTest {
    @Test
    public void constructorTest(){
        MessageProvider provider=mock(MessageProvider.class);
        List<SingleConnection> connections=new ArrayList<>();
        List<Message> messages=new ArrayList<>();
        SingleConnection singleConnection=new SingleConnection(provider,connections,messages,885553535);
        assertTrue(singleConnection.getMessageProvider()!=null);
        assertTrue(singleConnection.toString()!=null);
    }
}
  @Test
    public void chatServerTest(){
        ChatServer chatServer=new ChatServer();
       assertTrue(chatServer.init());
    }
}
