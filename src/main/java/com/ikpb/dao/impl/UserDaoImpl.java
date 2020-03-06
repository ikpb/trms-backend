package com.ikpb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ikpb.dao.UserDAO;
import com.ikpb.domain.ReimbursementForm;
import com.ikpb.domain.User;
import com.ikpb.util.ConnectionFactory;

public class UserDaoImpl implements UserDAO {
	private static final String USER_TABLE = "employee";
	private static final String SELECT_ALL_EMPLOYEE = "select * from " + USER_TABLE;
	private static final String SELECT_USER_BY_EMAIL = "select * from " + USER_TABLE + " where email=?";
	private static final String SELECT_USER_BY_ID = "select * from " + USER_TABLE + " where id=?";
	@Override
	public void createUser(User User) {
		// TODO Auto-generated method stub

	}

	@Override
	public User editUser(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserById(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		User tempUser=null;
		try{
			Connection conn = ConnectionFactory.getConnection();
			//putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_EMAIL);
			ps.setInt(1, email);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			if(rs.next()) {
				tempUser= new ReimbursementForm(rs.getInt("formid"), rs.getString("userid"),rs.getTimestamp("dateofevent"),
						rs.getString("locationaddress"),rs.getString("locationcity"),rs.getString("locationstate"),rs.getInt("cost"),
						rs.getString("gradeformat"),rs.getString("typeofevent"),rs.getString("workjustification"),rs.getDate("submissiondate"),rs.getString("description"),rs.getDate("enddate"));
			}
			
			ps.execute();
			//allows us to execute a query without a result
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return tempReimburseForm;
	}

	@Override
	public List<User> getAllUsers() {
		List <User> tempUsers= new ArrayList<User>();
		try{
			Connection conn = ConnectionFactory.getConnection();
			//putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement(SELECT_ALL_EMPLOYEE);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			while(rs.next()) {
				tempUsers.add(new ReimbursementForm(rs.getInt("formid"), rs.getString("userid"),rs.getTimestamp("dateofevent"),
						rs.getString("locationaddress"),rs.getString("locationcity"),rs.getString("locationstate"),rs.getInt("costs"),
						rs.getString("gradeformat"),rs.getString("typeofevent"),rs.getString("workjustification"),rs.getDate("submissiondate"),rs.getString("description"),rs.getDate("enddate")));
			}
			
			ps.execute();
			//allows us to execute a query without a result
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return tempUsers;
	}

}
