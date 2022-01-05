package com.turkcell.app.device.error;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ErrorInfo {
	private String m_dateTime;
	private String m_message;
	private int m_status;
	
	public ErrorInfo(String message, int status)
	{
		m_dateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").format(LocalDateTime.now());
		m_message = message;
		m_status = status;
	}

	public String getDateTime()
	{
		return m_dateTime;
	}

	public void setDateTime(String dateTime)
	{
		//...
		m_dateTime = dateTime;
	}

	public String getMessage()
	{
		return m_message;
	}

	public void setMessage(String message)
	{
		//...
		m_message = message;
	}

	public int getStatus()
	{
		return m_status;
	}

	public void setStatus(int status)
	{
		//...
		m_status = status;
	}
}
