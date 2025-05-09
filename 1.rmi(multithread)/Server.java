import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {
            // Start RMI registry on port 2000
            LocateRegistry.createRegistry(2000);

            // Create server implementation object
            ServerImpl serverImpl = new ServerImpl();

            // Bind the server to the registry with the correct port
            String url = "rmi://localhost:2000/Server";
            Naming.rebind(url, serverImpl);

            System.out.println("Multi-threaded RMI Server started on port 2000!");
        } catch (Exception e) {
            System.out.println("Exception at Server: " + e);
        }
    }
}
