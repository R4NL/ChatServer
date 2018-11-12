package collegeboys.server.Server.MessageHandler;


import collegeboys.server.entity.Message;

import java.text.SimpleDateFormat;

public class MessageRender {
    public String renderMessage(Message message) {
        if (message == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy - hh:mm");
        return message.getPerson().getUserName() + " " + sdf.format(message.getDate()) + " > " + message.getText()+
                System.lineSeparator();

    }

}

