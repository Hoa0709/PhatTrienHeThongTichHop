package BT5_Lab3_RMI.RMI.rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {

    public String textstring(String name) throws RemoteException;

}