package RMI;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class HelloImpl extends UnicastRemoteObject implements HelloInterface {

    protected HelloImpl() throws RemoteException {
        super(); // Call parent constructor
    }

    public String sayHello() throws RemoteException {
        return "Hello from RMI Server!";
    }

    public String sayGoodbye() throws RemoteException {
        return "Goodbye from RMI Server!";
    }
}

