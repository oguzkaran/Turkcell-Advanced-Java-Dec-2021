package com.turkcell.app.device.data.entity;

public class PortInfo {
	public long id;
	public int deviceId;
	public int portNum;
	
	public PortInfo(long id, int deviceId, int portNum)
	{		
		this.id = id;
		this.deviceId = deviceId;
		this.portNum = portNum;
	}
	
	
}
