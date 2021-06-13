package com.revature.repositories;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;


import com.revature.utils.JDBCConnection;

public class UserRepoImpl implements UserRepo {
	
	private AccountRepo ap = new AccountRepoImpl();
	private Connection conn = JDBCConnection.getConnection();
	
	@Override
	public void addUser(User u) {
		String sql = "insert into users values (default, ?, ?) returning *;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				u.setId(rs.getInt("uid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public User getUserById(Integer id) {
		String sql = "select * from users where uid = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("uid"));
				u.setUsername(rs.getString("uusername"));
				u.setPassword(rs.getString("upassword"));
				u.setAccounts(ap.getAccountsByUser(u.getId()));

				return u;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public User getUser(String un, String pw) {
		String sql = "select * from users where uusername = ? and upassword = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, un);
			ps.setString(2, pw);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("uid"));
				u.setUsername(rs.getString("uusername"));
				u.setPassword(rs.getString("upassword"));
				u.setAccounts(ap.getAccountsByUser(u.getId()));
				return u;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public User getUserNoAcc(String un, String pw) {
		String sql = "select * from users where uusername = ? and upassword = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, un);
			ps.setString(2, pw);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("uid"));
				u.setUsername(rs.getString("uusername"));
				u.setPassword(rs.getString("upassword"));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		String sql = "select * from users left join accounts on users.uid = accounts.uid;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("uid"));
				u.setUsername(rs.getString("uusername"));
				u.setPassword(rs.getString("upassword"));
				u.setAccounts(ap.getAccountsByUser(u.getId()));
				users.add(u);
			}
			return users;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



}