package com.turkcell.app.device.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

public class DeviceDTO {
	private String m_deviceName;
	private String m_host;

	public DeviceDTO(String deviceName, String host)
	{
		m_deviceName = deviceName;
		m_host = host;
	}

	public String getDeviceName()
	{
		return m_deviceName;
	}

	public void setDeviceName(String deviceName)
	{
		//...
		m_deviceName = deviceName;
	}


	public String getHost()
	{
		return m_host;
	}

	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	@JsonSetter("deviceHost")
	public void setHost(String host)
	{
		//...
		m_host = host;
	}
}
