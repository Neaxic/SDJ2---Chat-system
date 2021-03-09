package Client;

import External.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocketHandler implements Runnable {

    private Client client;
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private String Nickname;

    public ClientSocketHandler(Client client, Socket socket) throws IOException {
        this.client = client;
        this.socket = socket;
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());

    }

    @Override
    public void run() {
        System.out.println("Use: !nick to set nickname, !chatters to se chatters, !exit to exit");
        try {
            while (true) {
                Message message = (Message) in.readObject();
                client.messageReceived(message.getText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void sendMessage(String message) {
        if(message.contains("!nick ")){
            Nickname = "";
            for(int i = 6; i < message.length(); i++){
                Nickname = Nickname + message.charAt(i);
            }
            System.out.println("Nickname sat to: " +Nickname);
            return;
        }
        try {
            out.writeObject(new Message(Nickname, message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
