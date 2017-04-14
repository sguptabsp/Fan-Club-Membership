package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

import beans.MemberBean;

/**
 * Servlet implementation class for Servlet: MainServlet
 *
 */
 public class MainServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd= null;
		if(request.getParameter("submit").equals("HOME"))
		{
			rd = request.getRequestDispatcher("index.jsp");
		}
		else if(request.getParameter("submit").equals("ADD MEMBER"))
		{
			rd = request.getRequestDispatcher("Member.jsp");
			
		}
		else if(request.getParameter("submit").equals("DELETE MEMBER"))
		{
			MemberDao dao= new MemberDao();
			try {
				ArrayList<MemberBean> member =dao.viewDetail();
				System.out.println(member.get(0).getMemberId());
				request.setAttribute("member", member);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rd = request.getRequestDispatcher("delete.jsp");
		}
		else if(request.getParameter("submit").equals("Delete"))
		{
			String mID=request.getParameter("mID");
			MemberDao dao= new MemberDao();
			String msg=dao.deleteMember(Integer.parseInt(mID));
			try {
				ArrayList<MemberBean> member =dao.viewDetail();
				System.out.println(member.get(0).getMemberId());
				request.setAttribute("member", member);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("msg", msg);
			rd = request.getRequestDispatcher("delete.jsp");
			
		}
		else if(request.getParameter("submit").equals("search"))
		{
			String initial= request.getParameter("initials");
			String fstName=request.getParameter("fName");
			String lstName=request.getParameter("lName");
			 String concatName = initial + " "+fstName;
			 MemberBean beanObj= new MemberBean();
			  beanObj.setFirstName(concatName);
			  beanObj.setLastName(lstName);
			MemberDao dao= new MemberDao();
			try {
				ArrayList<MemberBean> member =dao.view(beanObj);
				request.setAttribute("member", member);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      rd = request.getRequestDispatcher("view.jsp");
		}
		else
		{
			rd = request.getRequestDispatcher("search.jsp");
		}
		rd.forward(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	   String initial= request.getParameter("initials");
	   String firstName= request.getParameter("first");
	   String lastName= request.getParameter("last");
	   String mobile =request.getParameter("cont");
	   String occupation= request.getParameter("occup");
	   String homeAdd =request.getParameter("home_add");
	   String offcAdd =request.getParameter("offc_add");
	   String offContNo =request.getParameter("offc_cont");
	   String emailId=request.getParameter("email");
	   String annIncom = request.getParameter("annualIncome");
	   String memberType = request.getParameter("memberType");
	   String cardNo = request.getParameter("cardno");
	   String agreement = request.getParameter("agree");
	   
	   
	  String concatName = initial + " "+firstName;
	  MemberBean beanObj= new MemberBean();
	  beanObj.setFirstName(concatName);
	  beanObj.setLastName(lastName);
	  beanObj.setContNum(Long.parseLong(mobile));
	  beanObj.setOccupation(occupation);
	  beanObj.setHomeAdd(homeAdd);
	  beanObj.setOffcAdd(offcAdd);
	  beanObj.setOffContNo(Long.parseLong(offContNo));
	  beanObj.setEmail(emailId);
	  beanObj.setAnnualIncome(annIncom);
	  beanObj.setMembershipType(memberType);
	  beanObj.setCreditCardNo(cardNo);
	  beanObj.setAgreement(agreement);
	  
	  
	  MemberDao daoObj = new MemberDao();
	  String msg=null;
	  try {
		daoObj.insertMember(beanObj);
		 msg = daoObj.responseData();
		System.out.println(msg);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	request.setAttribute("msg", msg);
	RequestDispatcher rd = request.getRequestDispatcher("Confirm.jsp");
	rd.forward(request, response);
	   
	}   	  	    
}