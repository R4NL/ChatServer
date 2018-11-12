package collegeboys.server.Server;

import collegeboys.server.Controller.StartController;
import collegeboys.server.Server.Connection.SingleConnection;
import collegeboys.server.Server.MessageHandler.MessageProvider;
import collegeboys.server.entity.Message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {
    private ServerSocket serverSocket;
    private ArrayList<SingleConnection> connectionList = new ArrayList<>();
    private List<Message> messageList = Collections.synchronizedList(new ArrayList<>());

    public ChatServer() {
        super();
    }

    private boolean init() {
        try {
            this.serverSocket = new ServerSocket(20000);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            return false;
        }
        return true;
    }

    public void serverStart() {
        boolean startInit = this.init();
        if (startInit == false) {
            System.out.println("Server initialization failed ....");
            return;
        }
        System.out.println("Server start");
        int i = 0;

        for (; ; ) {
            try {
                Socket socket = this.serverSocket.accept();
                MessageProvider mpi = new MessageProvider();
                mpi.setSocet(socket);
                SingleConnection singleConnection = new SingleConnection(mpi, connectionList, messageList, i++);
                Thread threadSingleConnection = new Thread(singleConnection);
                threadSingleConnection.setDaemon(true);
                threadSingleConnection.start();

            } catch (IOException e) {
                System.out.println("Server stop");
                return;
            }

        }
    }

}
