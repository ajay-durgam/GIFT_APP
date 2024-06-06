package com.edubridge.giftapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.giftapp.model.Gift;
import com.edubridge.giftapp.util.GiftUtil;

public class GiftDaoImpl implements GiftDao {
	Connection con = GiftUtil.getConnection();

	@Override
	public int addGift(Gift g) {

		String INSERT_QUERY = "insert into gift(name,price,occasion,rating) values(?,?,?,?)";
		int status = 0;

		try {
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
			ps.setString(1, g.getName());
			ps.setDouble(2, g.getPrice());
			ps.setString(3, g.getOccasion());
			ps.setFloat(4, g.getRating());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public List<Gift> findGifts() {
		String SELECT_QUERY = "select * from gift";
		List<Gift> giftList = new ArrayList<>();

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(SELECT_QUERY);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Gift g = new Gift();
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setPrice(rs.getDouble("price"));
				g.setOccasion(rs.getString("occasion"));
				g.setRating(rs.getFloat("rating"));
				giftList.add(g);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return giftList;
	}

	@Override
	public Gift findGiftByName(String name) {
		String SELECT_QUERY = "select  * from gift where name=?";
		int status = 0;
		// PreparedStatement;
		Gift g = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(SELECT_QUERY);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			g = new Gift();
			if (rs.next()) {
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setPrice(rs.getDouble("price"));
				g.setOccasion(rs.getString("occasion"));
				g.setRating(rs.getFloat("rating"));

			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return g;
	}

	@Override
	public int updateGift(Gift c) {

		String UPDATE_QUERY = "UPDATE gift SET name= ?,price=?,occasion=?,rating=? where id=?";
		int status = 0;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(UPDATE_QUERY);
			ps.setString(1, c.getName());
			ps.setDouble(2,c.getPrice());
			ps.setString(3, c.getOccasion());
			ps.setFloat(4, c.getRating());
			ps.setInt(5, c.getId());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public int deleteGiftByName(String name) {

		String DELETE_QUERY = "delete from gift where name=?";
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			ps.setString(1, name);
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public void deleteAllGifts() {
		String DELETE_QUERY = "delete from gift";
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			 ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
