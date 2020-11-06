package com.in4.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import com.acount.account;
import com.flight.Flight;
import com.history.History;
import com.rmi.IFlight;

public class FlightImpl extends UnicastRemoteObject implements IFlight{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FlightImpl() throws RemoteException {	}
	//--------------HistoryOrder-----------
	@SuppressWarnings("resource")
	public History[] HistoryOrder(){
		File f = new File("D:\\Eclipse\\Airline\\src\\com\\history\\Order.txt");
		Scanner c = null;
		try {
			c = new Scanner(f,"UTF-8");
			History data[] = new History[10000];
			int i = 0;
			while(c.hasNextLine()) {
				String line = c.nextLine();
				String[] parts = line.split("\t");
				data[i] = new History();				
				data[i].setIdUser(Integer.parseInt(parts[0]));
				data[i].setIdFlight(parts[1]);
				data[i].setTickets(Integer.parseInt(parts[2]));
				i++;
			}
			History Data[] = new History[i];
			for (int j = 0; j < Data.length; j++) {
				Data[j] = data[j];
			}
			return Data;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	//--------------HistoryPay-----------
	@SuppressWarnings("resource")
	public History[] HistoryPay(){
		File f = new File("D:\\Eclipse\\Airline\\src\\com\\history\\Pay.txt");
		Scanner c = null;
		try {
			c = new Scanner(f,"UTF-8");
			History data[] = new History[10000];
			int i = 0;
			while(c.hasNextLine()) {
				String line = c.nextLine();
				String[] parts = line.split("\t");
				data[i] = new History();				
				data[i].setIdUser(Integer.parseInt(parts[0]));
				data[i].setIdFlight(parts[1]);
				data[i].setTickets(Integer.parseInt(parts[2]));
				i++;
			}
			History Data[] = new History[i];
			for (int j = 0; j < Data.length; j++) {
				Data[j] = data[j];
			}
			return Data;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}		
	}
	//--------------DataUser----------
	@SuppressWarnings("resource")
	public account[] DataAcc() {
		File f = new File("D:\\Eclipse\\Airline\\src\\com\\acount\\acc.txt");
		Scanner c = null;
		try {
			c = new Scanner(f,"UTF-8");
			account data[] = new account[100];
			int i = 0;
			while(c.hasNextLine()) {
				String line = c.nextLine();
				String[] parts = line.split("\t");
				data[i] = new account();				
				data[i].setId(Integer.parseInt(parts[0]));
				data[i].setUsername(parts[1]);
				data[i].setPassword(parts[2]);
				i++;
			}
			account Data[] = new account[i];
			for (int j = 0; j < Data.length; j++) {
				Data[j] = data[j];
			}
			return Data;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	//-------------CheckAcc---------
	public Boolean CheckAcc(String User,String Pass) {
		Boolean x = false;
		account[] Data = DataAcc();
		for (int i = 0; i < Data.length; i++) {
			if(Data[i].getUsername().equals(User)&&Data[i].getPassword().equals(Pass)) {
				x = true;
				break;
			}
		}
		return x;
	}
	//---------takeId-----
	public int IdAcc(String User,String Pass) {
		int x = 0;
		account[] Data = DataAcc();
		for (int i = 0; i < Data.length; i++) {
			if(Data[i].getUsername().equals(User)&&Data[i].getPassword().equals(Pass)) {
				x=i+1;
				break;
			}
		}
		return x;		
	}
	//--------------Data--------------
	public Flight[] Data(){
		File f = new File("D:\\Eclipse\\Airline\\src\\com\\in4\\server\\lib.txt");
		Scanner c = null;
		try {
			c = new Scanner(f,"UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Flight data[] = new Flight[100];
		int i = 0;
		while(c.hasNextLine()) {
			String line = c.nextLine();
			String[] parts = line.split("\t");
			data[i] = new Flight();				
			data[i].setId(parts[0]);
			data[i].setDate(parts[1]);
			data[i].setFrom(parts[2]);
			data[i].setTo(parts[3]);
			data[i].setFlyTime(parts[4]);
			data[i].setTotal(Integer.parseInt(parts[5]));
			data[i].setOdered(Integer.parseInt(parts[6]));
			i++;
			}
		Flight Data[] = new Flight[i];
		for (int j = 0; j < Data.length; j++) {
			Data[j] = data[j];
		}
		return Data;
	}	
	//------------getFlight = findId------------
	@Override
	public Flight getFlight(String x){
		// TODO Auto-generated method stub
		Flight[] data = Data();
		Flight DataFind = new Flight();
		for (int i = 0; i < data.length; i++) {
			if (data[i].getId().equals(x)) {
				DataFind = data[i];
				break;
			}
		}
		return DataFind;		
    }
	//------------Id send client for Flight----------------
	@Override
	public String[] DataId() throws RemoteException {
		// TODO Auto-generated method stub
		Flight[] data = Data();
		String[] id = new String[data.length]; 
		for (int i = 0; i < data.length; i++) {
			id[i] = new String();
			id[i] = data[i].getId();
		}
		return id;
	}		
	//-----------Edit data--------------
	@Override
	public String Order(String x, int y,String user,String password) throws RemoteException {
		String s = null;
		// TODO Auto-generated method stub
		if(CheckAcc(user,password)==true) {
			Flight[] data = Data();
			for (int i = 0; i < data.length; i++) {
				if(data[i].getId().equals(x)) {
					data[i].setOdered(data[i].getOdered()+y);
				}
			}
			try {
				FileWriter writer = new FileWriter("D:\\Eclipse\\Airline\\src\\com\\in4\\server\\lib.txt");
				for (int i = 0; i < data.length; i++) {
					writer.write(data[i].getId()+"\t"+data[i].getDate()+"\t"+data[i].getFrom()+"\t"+data[i].getTo()+"\t"+data[i].getFlyTime()+"\t"+data[i].getTotal()+"\t"+data[i].getOdered()+"\n");
				}
				writer.close();
				FileWriter writerorder = new FileWriter("D:\\Eclipse\\Airline\\src\\com\\history\\Order.txt",true);
				writerorder.write(IdAcc(user,password)+"\t"+x+"\t"+y+"\n");
				writerorder.close();
				s = "Sign up success";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			s = "Sign up fail";
		}
		return s;
	}
	//--------------Check Account Order---------
	@Override
	public String CheckIdAccToPay(String user,String password,String IdFlight) throws RemoteException {
		// TODO Auto-generated method stub
		int total = 0;
		int id = IdAcc(user,password);
		total = TotalTicketsOrder(id,IdFlight);
		return "Account > "+user+" had order "+total+" ticket with Id flight : "+IdFlight;
	}
	//--------------Check Number Ticket---------
	int TotalTicketsOrder(int iduser,String idFlight) {
		History[] DataOrder = HistoryOrder();
		History[] DataPay = HistoryPay();
		int t = 0;
		if(DataOrder!=null) {
			for (int i = 0; i < DataOrder.length; i++) {
				if(DataOrder[i].getIdUser()==iduser && DataOrder[i].getIdFlight().equals(idFlight)) {
					t = t + DataOrder[i].getTickets();
				}
			}
			for (int i = 0; i < DataPay.length; i++) {
				if(DataPay[i].getIdUser()==iduser && DataPay[i].getIdFlight().equals(idFlight)) {
					t = t - DataPay[i].getTickets();
				}
			}
		}
		return t;
	}
	//--------------Pay ticket------------------
	@Override
	public String Pay(String x, int y, String user, String password) throws RemoteException {
		// TODO Auto-generated method stub
		String s = null;
		// TODO Auto-generated method stub
		if(CheckAcc(user,password)==true) {
			int idAcc = IdAcc(user,password);
			Flight[] data = Data();
			if(TotalTicketsOrder(idAcc,x)>=y) {
				try {
					for (int i = 0; i < data.length; i++) {
						if(data[i].getId().equals(x)) {
							data[i].setOdered(data[i].getOdered()-y);
						}
					}
					FileWriter writer = new FileWriter("D:\\Eclipse\\Airline\\src\\com\\in4\\server\\lib.txt");
					for (int i = 0; i < data.length; i++) {
						writer.write(data[i].getId()+"\t"+data[i].getDate()+"\t"+data[i].getFrom()+"\t"+data[i].getTo()+"\t"+data[i].getFlyTime()+"\t"+data[i].getTotal()+"\t"+data[i].getOdered()+"\n");
					}
					writer.close();
					FileWriter writerorder = new FileWriter("D:\\Eclipse\\Airline\\src\\com\\history\\Pay.txt",true);
					writerorder.write(idAcc+"\t"+x+"\t"+y+"\n");
					writerorder.close();
					s = "Sign up success";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					s = "Sign up fail";
				}
			}else s = "Ticket is 0 or more large";
		}else{
			s = "Sign up fail";
		}
		return s;
	}
//------------Display Client--------------
	@Override
	public String Display(int x) throws RemoteException {
		// TODO Auto-generated method stub
		String s = new String();
		switch(x) {
		case 0:{
			s =".-----------------------------------------------------------------------------------------------."
					+"\n"+"|					AIRLINE HELLO !!!					|"
					+"\n"+"*-----------------------------------------------------------------------------------------------*"
					+"\n"+" 1.Flight Details(input number follow flight numbersoft)\t"+"-----------\t"+"2.exit (write exit)"+"\n\n";
			break;
		}
		case 1:{
			 s =".-----------------------------------------------------------------------------------------------."
						+"\n"+"|					Flight Details !!!					|"
						+"\n"+"*-----------------------------------------------------------------------------------------------*"
						+"\n"+"\t\tFlight Details:\n\t"+"1.Order Tickets\t\t"+"2.Pay Tickets\t\t"+"3.Cancel"+"\n";
			 break;
		}
		case 2:{
			 s =".-----------------------------------------------------------------------------------------------."
						+"\n"+"|					Order Ticket !!!					|"
						+"\n"+"*-----------------------------------------------------------------------------------------------*"
						+"\n"+"\t\tTicket:\n\t\t"+"Write return to exit"+"\n\n";
			 break;
		}
		default:{
			s = "Data is not true !!! plesase press again !!!\n\n";
			break;
			}
		}
		return s;
	}
}
