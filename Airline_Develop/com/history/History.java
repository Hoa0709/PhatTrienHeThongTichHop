package com.history;

import java.io.Serializable;

public class History implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int IdUser,Tickets;
	private String IdFlight;
	//
	public int getIdUser() { return IdUser; }
	public void setIdUser(int x) { this.IdUser = x; }
	//
	public int getTickets() { return Tickets; }
	public void setTickets(int x) { this.Tickets = x; }
	//
	public String getIdFlight() { return IdFlight; }
	public void setIdFlight(String x) { this.IdFlight = x; }
	//
	public History(){
		IdUser = 0;
		Tickets = 0;
		IdFlight = null;
	}
}
