package Server1.src.Networking;

import java.io.IOException;

public class ServerMain {

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
    }
}