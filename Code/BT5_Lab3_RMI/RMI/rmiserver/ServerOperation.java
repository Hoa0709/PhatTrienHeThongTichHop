package BT5_Lab3_RMI.RMI.rmiserver;

import java.rmi.Naming;

public class ServerOperation{
    public static void main(String[] args){

        try {

            Naming.rebind("//localhost/MyServer", new InterfaceImpl());
            System.err.println("Server ready");

        } catch (Exception e) {

            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }

    }

}