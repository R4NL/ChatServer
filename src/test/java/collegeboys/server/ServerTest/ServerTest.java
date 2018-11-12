package collegeboys.server.ServerTest;

import collegeboys.server.Server.ChatServer;
import collegeboys.server.Server.Connection.SingleConnection;
import collegeboys.server.Server.MessageHandler.MessageProvider;
import collegeboys.server.Server.MessageHandler.MessageRender;
import collegeboys.server.entity.Message;
import collegeboys.server.entity.Person;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class ServerTest {
    @Test
    public void constructorTest() {
        MessageProvider provider = mock(MessageProvider.class);
        List<SingleConnection> connections = new ArrayList<>();
        List<Message> messages = new ArrayList<>();
        SingleConnection singleConnection = new SingleConnection(provider, connections, messages, 885553535);
        assertTrue(singleConnection.getMessageProvider() != null);
        assertTrue(singleConnection.toString() != null);
    }

    @Test
    public void chatServerTest() {
        ChatServer chatServer = new ChatServer();
        assertTrue(chatServer.init());
    }
    
    @Test
    public void overrideTest() {
        MessageProvider provider = mock(MessageProvider.class);
        List<SingleConnection> connections = new ArrayList<>();
        List<Message> messages = new ArrayList<>();
        SingleConnection singleConnection = new SingleConnection(provider, connections, messages, 885553535);
        assertFalse(singleConnection.equals(null));
        assertFalse(singleConnection.hashCode() > 0);
    }
    
     @Test
    public void messageProviderTest(){
        Message message=new Message("Test",new Date(),new Person("Solarich","Solarich"));
        MessageRender render=new MessageRender();
        assertTrue(render.renderMessage(message).contains("Test"));
        assertTrue(render.renderMessage(message).contains("Solarich"));
    }
}
