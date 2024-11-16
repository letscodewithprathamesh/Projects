package test;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/edit")

public class EditEmployeeServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false);
		
		if(hs==null)
		{
			req.setAttribute("msg","Session Expired .. <br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			String eId=req.getParameter("eid");
		
			ArrayList<EmployeeBean> al=(ArrayList<EmployeeBean>)hs.getAttribute("alist");
			
			Iterator<EmployeeBean> it=al.iterator();
			
			while(it.hasNext())
			{
				EmployeeBean eb=(EmployeeBean)it.next();
				
				if(eId.equals(eb.geteId()))
				{
					req.setAttribute("ebean", eb);
					
					break; //Once desired output found it will come out of loop
				}
				//end of if loop
			}
			//end of while loop
			
			req.getRequestDispatcher("EditEmployee.jsp").forward(req, res);
		
		}

		
	}
}
