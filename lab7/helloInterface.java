package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

interface HelloInterface extends Remote {
    String sayHello() throws RemoteException;
    String sayGoodbye() throws RemoteException;
}