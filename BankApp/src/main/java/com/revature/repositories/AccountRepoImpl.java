package com.revature.repositories;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;

import com.revature.utils.JDBCConnection;

public class AccountRepoImpl implements AccountRepo {
	
	private Connection conn = JDBCConnection.getConnection();

	@Override
	public Account getAccountById(Integer id) {
		String sql = "select * from accounts where aid = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Account a = new Account();
				a.setId(rs.getInt("aid"));
				a.setType(rs.getString("atype"));
				a.setBalance(rs.getDouble("abalance"));
				
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Account> getAccountsByUser(Integer id) {
		List<Account> accounts = new ArrayList<Account>();
		String sql = "select * from accounts where uid = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Account a = new Account();
				a.setId(rs.getInt("aid"));
				a.setType(rs.getString("atype"));
				a.setBalance(rs.getDouble("abalance"));
				a.setStatus(rs.getString("astatus"));

				accounts.add(a);
			}
			return accounts;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void updateAccount(Integer id, Double balance) {
		String sql = "update accounts set abalance = ? where aid = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, balance);
			ps.setInt(2, id);

//			log.info("updating account info");
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void addAccount(Integer id, Account account) {
		String sql = "insert into accounts values (DEFAULT, ?, ?, ?, ?);";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, account.getBalance());
			ps.setString(2, account.getType());
			ps.setInt(3, id);
			ps.setString(4, account.getStatus());

//			log.info("adding account");
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public Double getBalance(Integer id, String type) {
		String sql = "select * from accounts where aid = ? and atype = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, type);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Double dou = rs.getDouble("abalance");
				return dou;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Integer getAccountId(Integer id, String type) {
		String sql = "select * from accounts where aid = ? and atype = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, type);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Integer aid = rs.getInt("aid");
				return aid;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


	@Override
	public void denyAccount(Integer id) {
		String sql = "deny_account(aid_input integer)";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(2, id);
			ps.setString(1, "denied");
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void appoveAccount(Integer id) {
		String sql = "approve_account(aid_input integer)";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(2, id);
			ps.setString(1, "approved");
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	

}
