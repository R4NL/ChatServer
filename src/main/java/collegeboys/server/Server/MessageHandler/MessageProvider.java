package collegeboys.server.Server.MessageHandler;

import collegeboys.server.entity.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MessageProvider {
    private Socket socet;
    private ObjectInputStream ois = null;
    private ObjectOutputStream oos = null;

    public MessageProvider(Socket socet) {
        super();
        this.socet = socet;
    }

    public MessageProvider() {
        super();
    }

    public Socket getSocet() {
        return socet;
    }

    public void setSocet(Socket socet) throws IOException {
        this.socet = socet;
        oos = new ObjectOutputStream(socet.getOutputStream());
        ois = new ObjectInputStream(socet.getInputStream());
    }


    public void sendMessage(Message message) throws IOException {
        try {
            oos.writeObject(message);
        } catch (IOException e) {
            closeStream();
            throw e;
        }
    }


    public Message readMessage() throws IOException {
        try {
            return (Message) ois.readObject();
        } catch (ClassNotFoundException e) {
            return null;
        } catch (IOException e) {
            closeStream();
            throw e;
        }
    }

    private final void closeStream() {
        try {
            oos.close();
            ois.close();
            socet.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

