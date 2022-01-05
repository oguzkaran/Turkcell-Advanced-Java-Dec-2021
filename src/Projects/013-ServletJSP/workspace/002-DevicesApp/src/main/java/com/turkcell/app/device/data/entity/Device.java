package com.turkcell.app.device.data.entity;

import java.util.Set;

public class Device { 
	public int id;
	public String name;
	public String host;
	
	public Set<PortInfo> ports;
	
	public Device()
	{
		this(0, "", "");
	}
	
	public Device(int id, String name, String host)
	{		
		this.id = id;
		this.name = name;
		this.host = host;
	}
	
	public Device(String name, String host)
	{	
		this(0, name, host);
	}		
}
