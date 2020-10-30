package com.sept.client.impl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.rmi.IAccount;

/**
 * 
 * @author framgiavn
 *
 */
public class RMIClient {
    public static void main(String args[]) {
        try {
            //Xác định RMI máy chủ.
            IAccount iAccount = (IAccount) Naming.lookup("rmi://localhost:2003/SeptemberRMI");
            System.out.println("Name: " + iAccount.getUser().getUname());
            System.out.println("ID: " + iAccount.getUser().getId());
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
