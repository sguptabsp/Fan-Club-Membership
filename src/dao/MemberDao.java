package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.MemberBean;


import connection.DBConnection;

public class MemberDao 
{
	PreparedStatement prepstmnt = null;
	ResultSet rs = null;
	Connection con=null;

	public void insertMember(MemberBean MB) throws SQLException
	{
		System.out.println("In Dao:");
		con=DBConnection.createConnection();
		String prepQuery = "INSERT INTO addmember VALUES (seq_St_Act.nextVal,?,?,?,?,?,?,?,?,?,?,?,?)";
		prepstmnt = con.prepareStatement(prepQuery);
		
		prepstmnt.setString(1, MB.getFirstName());
		prepstmnt.setString(2,MB.getLastName());
		prepstmnt.setLong(3, MB.getContNum());
		prepstmnt.setString(4,MB.getOccupation());
		prepstmnt.setString(5,MB.getHomeAdd());
		prepstmnt.setString(6, MB.getOffcAdd());
		prepstmnt.setLong(7, MB.getOffContNo());
		prepstmnt.setString(8, MB.getEmail());
		prepstmnt.setString(9,MB.getAnnualIncome());
		prepstmnt.setString(10, MB.getMembershipType());
		prepstmnt.setString(11, MB.getCreditCardNo());
		prepstmnt.setString(12, MB.getAgreement());
		int i = prepstmnt.executeUpdate();
		System.out.println(i);
		con.commit();
		DBConnection.CloseAll(con, prepstmnt, rs);
	}
		
		public String responseData() throws SQLException
		{
			con=DBConnection.createConnection();
			String query="SELECT MAX(memberId) FROM addmember";
			prepstmnt = con.prepareStatement(query);
			rs=prepstmnt.executeQuery();
			
			int last=0;
			while (rs.next()) {
				last =rs.getInt("MAX(memberId)");	
			}
			System.out.println("Member ID is: "+last);
			String msg = "U R SUCCESSFULLY REGISTERED AND UR MEMBER ID IS :"+last;
			DBConnection.CloseAll(con, prepstmnt, rs);	
			return msg;
		}
		
		
		public ArrayList<MemberBean> viewDetail() throws SQLException
		{
			ArrayList<MemberBean> member= new ArrayList<MemberBean>();
			con=DBConnection.createConnection();
			String query="SELECT memberId,firstName,lastName FROM addmember";
			prepstmnt = con.prepareStatement(query);
			rs=prepstmnt.executeQuery();
			System.out.println("in viewDetail");
			while (rs.next()) {
				MemberBean obj= new MemberBean();
				obj.setMemberId(rs.getInt("memberId"));	
				obj.setFirstName(rs.getString("firstName"));
				obj.setLastName(rs.getString("lastName"));
				member.add(obj);	
			}
			DBConnection.CloseAll(con, prepstmnt, rs);	
			return member;
			
		}
		
		public String deleteMember(int mID)
		{
			
			con=DBConnection.createConnection();
			String query="DELETE FROM addmember where memberId='"+mID+"'";
			try {
				prepstmnt = con.prepareStatement(query);
				rs=prepstmnt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return "Such Member Account does not exist in database";
				//e.printStackTrace();
			}
			
			DBConnection.CloseAll(con, prepstmnt, rs);	
			return "Account is Successfuly Deleted!";
		}
		
		public ArrayList<MemberBean> view(MemberBean mem) throws SQLException
		{
			ArrayList<MemberBean> member= new ArrayList<MemberBean>();
			con=DBConnection.createConnection();
			String query="SELECT * FROM addmember where memberId='"+mem.getMemberId()+"' OR firstName='"+mem.getFirstName()+"' OR lastName='"+mem.getLastName()+"'";
			prepstmnt = con.prepareStatement(query);
			rs=prepstmnt.executeQuery();
			System.out.println("in viewDetail");
			while (rs.next()) {
				MemberBean obj= new MemberBean();
				obj.setMemberId(rs.getInt("memberId"));	
				obj.setFirstName(rs.getString("firstName"));
				obj.setLastName(rs.getString("lastName"));
				obj.setContNum(rs.getInt("ContactNo"));
				obj.setHomeAdd(rs.getString("homeAdd"));
				obj.setOffcAdd(rs.getString("officeAdd"));
				obj.setOffContNo(rs.getInt("offccontact"));
				obj.setOccupation(rs.getString("occupation"));
				obj.setCreditCardNo(rs.getString("creditcardno"));
				member.add(obj);
			}
			DBConnection.CloseAll(con, prepstmnt, rs);	
			return member;
			
		}

	}
	

