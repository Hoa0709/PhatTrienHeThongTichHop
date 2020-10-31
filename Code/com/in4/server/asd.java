package com.in4.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.flight.Flight;

public class asd {
	public static Flight[] Data(){
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
			data[i].setEmpty(Integer.parseInt(parts[7]));
			i++;
			}
		Flight Data[] = new Flight[i];
		for (int j = 0; j < Data.length; j++) {
			Data[j] = data[j];
		}
		return Data;
	}
	public static void main(String[] args) {
		
		System.out.print(">>>");
		Scanner scan1 = new Scanner(System.in);
		String txt = scan1.nextLine();
		System.out.print(">>>");
		scan1.nextLine();
		scan1.nextLine();
		scan1.nextLine();
		scan1.nextLine();
		
		
	}
}
