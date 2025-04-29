package lab7;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
  public static void main(String[] args) {
    try {
      // Create remote object
      HelloImpl obj = new HelloImpl();

      // Create RMI registry at port 1099
      Registry registry = LocateRegistry.createRegistry(1099);

      // Bind the remote object with name "Hello"
      registry.rebind("Hello", obj);

      System.out.println("Server started on port 1099 and waiting for client requests...");
    } catch (Exception e) {
      System.out.println("Server exception: " + e);
    }
  }
}
