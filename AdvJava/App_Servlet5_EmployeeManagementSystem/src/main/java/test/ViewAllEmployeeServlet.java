package test;

import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/view")

public class ViewAllEmployeeServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		
		HttpSession hs=req.getSession(false);
		
		if(hs==null)
		{
			req.setAttribute("msg","Session Expired ...  <br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			ArrayList<EmployeeBean> al=new ViewAllEmployeeDAO().retrieve();
			hs.setAttribute("alist", al); //setting al object to Session Object
			req.getRequestDispatcher("ViewAllEmployee.jsp").forward(req, res);
		}
		
		
		
		
	}
	
	
	
}
