package Server;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private List<ServerSocketHandler> connections;

    public ConnectionPool() {
        connections = new ArrayList<>();
    }

    public void addHandler(ServerSocketHandler handler) {
        connections.add(handler);
    }
    public void removeHandler(ServerSocketHandler handler) {
        connections.remove(handler);
    }


    public void broadcastMessage(String msg) {
        System.out.println("Broadcasting '" + msg + "' to " + connections.size() + " clients");;
        for (ServerSocketHandler handler : connections) {
            handler.sendMessage(msg);
        }


    }
}
