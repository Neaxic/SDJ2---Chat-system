package Server1.src.Networking;

import communicationobjects.Request;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable {

    private Socket socket;
    private int id;

    public ServerSocketHandler(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            //ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            System.out.println("Client connected from " + socket.getInetAddress().getHostAddress() + " " + socket.getPort() + "ID: " + id);
            out.writeObject(new Request("Your id:" +id));
            /*
            out.writeObject(new Request("Hello from server. Write your name"));
            String nameFromClient = ((Request) in.readObject()).getText();
            out.writeObject(new Request("Hello " + nameFromClient));
            */
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
