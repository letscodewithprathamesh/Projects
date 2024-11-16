package test;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/update")

public class UpdateEmployeeServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		
		HttpSession hs=req.getSession(false);
		
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired.... <br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			String eId=req.getParameter("eid");
			int bsal=Integer.parseInt(req.getParameter("bsal"));
			float h=Float.parseFloat(req.getParameter("hra"));
			float d=Float.parseFloat(req.getParameter("da"));
			
			float hra = (float)(h*bsal)/100;
			float da = (float)(d*bsal)/100;
			float totSal=bsal+hra+da;
			
			ArrayList<EmployeeBean> al=(ArrayList<EmployeeBean>)hs.getAttribute("alist");
			
			Iterator<EmployeeBean> it=al.iterator();
			
			while(it.hasNext())
			{
				EmployeeBean eb=(EmployeeBean)it.next();
				
				if(eId.equals(eb.geteId()))
				 {
					eb.setbSal(bsal);
					eb.setHra(hra);
					eb.setDa(da);
					eb.setTotSal(totSal);
					
					int k=new UpdateEmplyeeDAO().update(eb);
					
					if(k>0)
					{
						req.setAttribute("msg","Update Successfully .... <br>");
						break;
					}//internal if loop
					
				 }//external if loop
				
			}//end of while
			
			req.getRequestDispatcher("UpdateEmployee.jsp").forward(req, res);
			
		}
	
	}
}





//first we take parameter from request object then we need two more object - Httpsession and ArrayList ... ArrayList Object where we actually change the data and send it employeebean object and the EmployeeBean Object to Dao and it will change it in database
