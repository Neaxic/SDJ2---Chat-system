package Client;

import External.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private ClientSocketHandler handler;

    public Client() {
    }

    public void start() throws IOException {
        try (
                Socket socket = new Socket("127.0.0.1", 2222);
        ) {
            this.handler = new ClientSocketHandler(this, socket);
            Thread handlerThread = new Thread(handler);
            handlerThread.setDaemon(true);
            handlerThread.start();
            //Message message = (Message) in.readObject();
            //System.out.println(message.getText());
            while (true) {
                String messageFromClient = new Scanner(System.in).nextLine();
                handler.sendMessage(messageFromClient);
                if (messageFromClient.equals("exit")){
                    break;
                }
            }
        }
    }

    public void messageReceived(String message) {
        System.out.println(message);
    }
}
