package Client1.src.Networking;

import communicationobjects.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {
    public void start() throws IOException {
        try (
                Socket socket = new Socket("127.0.0.1", 1234);
        ) {
            while (true) {
                //ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                System.out.println(request.getText());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
