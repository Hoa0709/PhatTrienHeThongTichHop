package com.in4.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.rmi.IFlight;

public class Server {
    public static void main(String args[]) {

        try {
            LocateRegistry.createRegistry(2007);
            
            // Sign in rmiregistry
            IFlight x = new FlightImpl();
            Naming.bind("rmi://localhost:2007/in4RMI", x );
            System.out.println(">>>>>INFO: RMI Server started!!!!!!!!");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
