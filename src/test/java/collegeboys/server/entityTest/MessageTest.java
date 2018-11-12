package collegeboys.server.entityTest;

import collegeboys.server.entity.Message;
import collegeboys.server.entity.Person;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class MessageTest {
    @Test
    public void messageTestOne() {
        Message message = new Message();
        assertTrue(message.getText() == null);
        assertTrue(message.getDate() == null);
        assertTrue(message.getPerson() == null);
    }

    @Test
    public void messageTestTwo() {
        Message message = new Message("Hello world", new Date(),
                new Person("TheAleshka", "1234"));
        assertTrue(message.getText() != null);
        assertTrue(message.getDate() != null);
        assertTrue(message.getPerson() != null);
    }
    @Test
    public void messageTestThree() {
        Message message = new Message("Hello world", new Date(),
                new Person("TheAleshka", "1234"));
        assertTrue(message.getText() == "Hello world");
    }

}
