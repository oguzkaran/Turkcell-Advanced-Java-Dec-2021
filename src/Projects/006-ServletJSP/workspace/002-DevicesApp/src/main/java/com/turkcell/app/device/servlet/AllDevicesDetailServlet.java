package com.turkcell.app.device.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.csystem.util.data.service.DataServiceException;

import com.google.gson.Gson;
import com.turkcell.app.device.error.ErrorInfo;
import com.turkcell.app.device.service.DeviceAppServiceFactory;

@WebServlet("/api/devices/details/all")
public class AllDevicesDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		var out = response.getWriter();
		var gson = new Gson();
		
		try {
			//TODO:	
		}
		catch (DataServiceException ex) {
			response.setStatus(503);
			out.print(gson.toJson(new ErrorInfo("Internal error occurs", 503)));
		}
		catch (Throwable ex) {
			response.setStatus(401);
			out.print(gson.toJson(new ErrorInfo(ex.getMessage(), 401)));
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		doGet(request, response);
	}

}
