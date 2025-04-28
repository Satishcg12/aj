package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
  public static void main(String[] args) {
    try {
      // Connect to RMI registry
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);

      // Lookup the remote object
      HelloInterface stub = (HelloInterface) registry.lookup("Hello");

      // Call remote method
      String helloResponse = stub.sayHello();
      String goodbyeResponse = stub.sayGoodbye();
      System.out.println("Response from server: " + helloResponse);
      System.out.println("Response from server: " + goodbyeResponse);
    } catch (Exception e) {
      System.out.println("Client exception: " + e);
    }
  }
}
