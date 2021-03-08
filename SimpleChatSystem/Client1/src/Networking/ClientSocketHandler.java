package Client1.src.Networking;

import communicationobjects.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientSocketHandler implements Runnable {

    private Socket socket;

    public ClientSocketHandler(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        try{
            //ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Request request = (Request) in.readObject();
            System.out.println(request.getText());

            /*
            String name = new Scanner(System.in).nextLine();
            out.writeObject(new Request(name));
            request = (Request) in.readObject();
            System.out.println(request.getText());

            // caps
            request = (Request) in.readObject();
            System.out.println(request.getText());

            String capsType = new Scanner(System.in).nextLine();
*/

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
