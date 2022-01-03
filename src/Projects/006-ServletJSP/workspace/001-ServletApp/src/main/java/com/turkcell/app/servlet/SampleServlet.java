package com.turkcell.app.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.turkcell.app.ClientInfo;


@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		var out = response.getWriter();
		
		try {			
			var name = request.getParameter("name");
			var familyName = request.getParameter("familyName");
			response.setContentType("text/json");
			
			if (name != null && familyName != null) {
				var ci = new ClientInfo(name, familyName);
				var gson = new Gson();				
				var json = gson.toJson(ci);
				
				out.println(json);
			}
			else
				out.println("Invalid Parameters");
			
		
		}	
		catch (Throwable ex) {
			out.println(ex.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().print("Post forbidden");		
	}
}
