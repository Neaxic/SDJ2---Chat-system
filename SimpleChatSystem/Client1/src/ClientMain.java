package Client1.src;

import Client1.src.Networking.Client;
import Networking.Client;

import java.io.IOException;

public class ClientMain {

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.start();
    }
}
