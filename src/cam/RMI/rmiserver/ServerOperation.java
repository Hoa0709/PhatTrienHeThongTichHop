package cam.RMI.rmiserver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import cam.RMI.rmiinterface.RMIInterface;
public class ServerOperation extends UnicastRemoteObject implements RMIInterface{

    private static final long serialVersionUID = 1L;

    protected ServerOperation() throws RemoteException {

        super();

    }
    public static String reverse(String input){
        char[] in = input.toCharArray();
        int begin=0;
        int end=in.length-1;
        char temp;
        while(end>begin){
            temp = in[begin];
            in[begin]=in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }
    @Override
    public String textstring(String name) throws RemoteException{
    	
        System.err.println(name + " is trying to contact!");
        return "The string reverse is : " + reverse(name);

    }
    public static void main(String[] args){

        try {

            Naming.rebind("//localhost/MyServer", new ServerOperation());
            System.err.println("Server ready");

        } catch (Exception e) {

            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }

    }

}