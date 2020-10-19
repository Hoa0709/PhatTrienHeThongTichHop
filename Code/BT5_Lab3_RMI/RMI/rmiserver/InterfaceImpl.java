package BT5_Lab3_RMI.RMI.rmiserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import cam.RMI.rmiinterface.RMIInterface;

public class InterfaceImpl extends UnicastRemoteObject implements RMIInterface{

	    private static final long serialVersionUID = 1L;
	    
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
	    public InterfaceImpl() throws RemoteException{
	    	
	    }
	    public String textstring(String name) throws RemoteException{
	    	
	        System.err.println(name + " is trying to contact!");
	        return "The string reverse is : " + reverse(name);

	    }

}
