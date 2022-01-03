package com.turkcell.app.device.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "devices")
public class Device { //POJO
	@Id
	@Column(name = "device_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	@Column(nullable = false, length = 100)
	public String name;

	@Column(nullable = false, length = 15)
	public String host;
	
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
