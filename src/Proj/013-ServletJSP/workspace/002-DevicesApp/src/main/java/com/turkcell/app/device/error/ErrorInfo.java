package com.turkcell.app.device.error;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ErrorInfo {
	public String dateTime;
	public String message;
	public int status;
	
	public ErrorInfo(String message, int status)
	{
		this.dateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").format(LocalDateTime.now());
		this.message = message;
		this.status = status;		
	}
}
