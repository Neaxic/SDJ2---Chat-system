package Server1.src.Networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int id;

    public void start() throws IOException {
        try (
                ServerSocket serverSocket = new ServerSocket(1234);
        ) {
            while (true) {
                    Socket socket = serverSocket.accept();
                    id++;
                    StringModel stringModel = new StringModel();
                    Thread t = new Thread(new ServerSocketHandler(socket, id));
                    t.start();
            }
        }

    }

    public int getId() {
        return id;
    }
}
