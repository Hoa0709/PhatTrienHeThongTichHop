package com.acount;

import java.io.Serializable;

public class account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//--------------------
	private int IdAcc;
	private String Username,Password;
	//IdAcc
	public int getId() { return IdAcc; }
	public void setId(int x) { this.IdAcc = x; }
	//UserName
	public String getUsername() { return Username; }
	public void setUsername(String x) { this.Username = x; }
	//Password
	public String getPassword() { return Password; }
	public void setPassword(String x) { this.Password = x; }
	//Default
	public account(){
		IdAcc = 0;
		Username = "Noname";
		Password = null;
	}
}
