package test;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/logout")

public class LogoutServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		
		HttpSession hs=req.getSession(false);
		
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired.....<br>");
		}
		else
		{
			hs.removeAttribute("abean"); // Object removed from Session Object
			hs.removeAttribute("alist");
			hs.invalidate(); //Session Destroyed
			req.setAttribute("msg", "LogOut Sucessfully <br>");
		}
		
		req.getRequestDispatcher("Msg.jsp").forward(req, res);
		
		
		
		
		
		
	}

}
