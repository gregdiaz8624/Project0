package com.revature.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Transaction;
import com.revature.utils.JDBCConnection;

public class TransactionRepoImpl implements TransactionRepo {
//	static Logger log = Logger.getLogger(TransactionRepoImpl.class.getName());
	
	private Connection conn = JDBCConnection.getConnection();

	@Override
	public Transaction getTransactionById(Integer id) {
		String sql = "select * from transactions where tid = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Transaction t = new Transaction();

				if (rs.getString("ttype").equals("transfer")) {

					t.setId(rs.getInt("tid"));
					t.setFromAcc(rs.getInt("tfrom"));
					t.setToAcc(rs.getInt("tto"));
					t.setAmount(rs.getDouble("tamount"));
					t.setType(rs.getString("ttype"));
					t.setStatus(rs.getString("tstatus"));

				} else {

					t.setId(rs.getInt("tid"));
					t.setAmount(rs.getDouble("tamount"));
					t.setType(rs.getString("ttype"));
					t.setStatus(rs.getString("tstatus"));

				}
				return t;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Transaction> getTransactions(Integer id) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		String sql = "select * from transactions where cid = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Transaction t = new Transaction();

				if (rs.getString("ttype").equals("transfer")) {

					t.setId(rs.getInt("tid"));
					t.setFromAcc(rs.getInt("tfrom"));
					t.setToAcc(rs.getInt("tto"));
					t.setAmount(rs.getDouble("tamount"));
					t.setType(rs.getString("ttype"));
					t.setStatus(rs.getString("tstatus"));

				} else {

					t.setId(rs.getInt("tid"));
					t.setAmount(rs.getDouble("tamount"));
					t.setType(rs.getString("ttype"));
					t.setStatus(rs.getString("tstatus"));

				}

				transactions.add(t);
			}
			return transactions;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Transaction> getAllTransactions() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		String sql = "select * from transactions;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Transaction t = new Transaction();

				t.setId(rs.getInt("tid"));
				t.setFromAcc(rs.getInt("tfrom"));
				t.setToAcc(rs.getInt("tto"));
				t.setAmount(rs.getDouble("tamount"));
				t.setType(rs.getString("ttype"));
				t.setStatus(rs.getString("tstatus"));

				transactions.add(t);
			}

			return transactions;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// this is for transfer
	@Override
	public void addTransaction(Integer from, Integer to, Double amount, String type, String status) {
		String sql = "insert into transactions values (DEFAULT, ?, ?, ?, ?, ?);";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, from);
			ps.setInt(2, to);
			ps.setDouble(3, amount);
			ps.setString(4, type);
			ps.setString(5, status);

//			log.info("Adding transaction by id");
			ps.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// withdraw/deposit
	@Override
	public void addTransaction(Double amount, String type, String status) {
		String sql = "insert into transactions values (DEFAULT, NULL, NULL, ?, ?, ?);";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setString(2, type);
			ps.setString(3, status);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateTransaction(Integer id) {
		String sql = "call update_transaction(?)";

		try {
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, id);
			cs.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
