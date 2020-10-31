package com.flight;

import java.io.Serializable;

public class Flight implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Total,Odered,Empty;
	private String Flytime,Date,Id,From,To;
	
	public String getDate() { return Date; }
	public void setDate(String x) { this.Date = x; }
	
	public String getFlyTime() { return Flytime; }
	public void setFlyTime(String x) { this.Flytime = x; }
	
	public int getTotal() { return Total; }
	public void setTotal(int x) { this.Total = x; }
	
	public int getOdered() { return Odered; }
	public void setOdered(int x) { this.Odered = x; }

	public String getId() { return Id; }
	public void setId(String x) { this.Id = x; }
	
	public String getFrom() { return From; }
	public void setFrom(String x) { this.From = x; }
	
	public String getTo() { return To; }
	public void setTo(String x) { this.To = x; }
	
}
