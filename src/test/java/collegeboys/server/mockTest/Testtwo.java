package collegeboys.server.mockTest;

import collegeboys.server.entity.Message;
import collegeboys.server.entity.Person;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class Testtwo {
    @Test
    public void TestOne(){  //sory i just do not know how to use mock in spring
        Person person =mock(Person.class);
        Message message =new Message("Hello world!",new Date(),person);
        assertTrue(message.toString().contains(person.toString()));
    }
}
