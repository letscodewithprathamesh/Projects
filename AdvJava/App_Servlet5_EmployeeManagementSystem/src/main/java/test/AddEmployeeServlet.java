package test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/add")

public class AddEmployeeServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false); //accessing existing session....if session not there it will create session if parameter=false
		
		//why cookiee or session gives null value while destroying because they are class and class or Non-Primitive data type will return null by default like int return 0 
		
		if(hs==null)
		{
			req.setAttribute("msg","Session Expired ... <br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			EmployeeBean eb=new EmployeeBean();
			
			eb.seteId(req.getParameter("eid"));
			eb.seteName(req.getParameter("ename"));
			eb.seteDesg(req.getParameter("edesg"));
			
			int bSal=Integer.parseInt(req.getParameter("bsal"));
			
			float h=Float.parseFloat(req.getParameter("hra"));
			
			float d = Float.parseFloat(req.getParameter("da"));
			
			float hra=(float)(h*bSal)/100;
			
			float da=(float)(d*bSal)/100;
			
			float totSal=bSal+hra+da;
			
			
			eb.setbSal(bSal);
			eb.setHra(hra);
			eb.setDa(da);
			eb.setTotSal(totSal);
			
			
			int k=new AddEmplyeeDAO().insert(eb);
			
			if(k>0)
			{
				req.setAttribute("msg", "Employee Added Successfully..... <br>");
				
				req.getRequestDispatcher("AddEmployee.jsp").forward(req, res);
				
			}
			
			
		}
		
	
	}
	
	
}
