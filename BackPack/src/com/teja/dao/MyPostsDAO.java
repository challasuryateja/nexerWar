package com.teja.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.teja.bo.MyPostsBO;
import com.teja.dto.SerializedMyPostsDTO;

public class MyPostsDAO {

	private static final String POSTS_CALL = "{call MY_POSTS_PROCEDURE(?,?,?,?,?,?,?,?,?,?)}";

	public List<MyPostsBO> getMyPosts(SerializedMyPostsDTO dto) throws NamingException, SQLException {
		int uid = dto.getUid();
		int min_num = dto.getMin_num();
		int max_num = dto.getMax_num();

		// initializing required params
		Connection con = null;
		InitialContext ic = null;
		DataSource ds = null;
		CallableStatement cs = null;
		MyPostsBO bo = null;
		ResultSet rs = null;
		List<MyPostsBO> ten_Posts = null;

		ten_Posts = new ArrayList<MyPostsBO>();
		// create InitialContext object
		ic = new InitialContext();

		// get DataSource object ref from Jndi Registry
		ds = (DataSource) ic.lookup("java:/comp/env/jdbc/myoracle");

		// getting connection
		con = ds.getConnection();
		// calling procedure to get values
		cs = con.prepareCall(POSTS_CALL);
		cs.setInt(1, uid);
		cs.setInt(2, min_num);
		cs.setInt(3, max_num);
		cs.registerOutParameter(4, Types.INTEGER);
		cs.registerOutParameter(5, Types.INTEGER);
		cs.registerOutParameter(6, Types.VARCHAR);
		cs.registerOutParameter(7, Types.VARCHAR);
		cs.registerOutParameter(8, Types.INTEGER);
		cs.registerOutParameter(9, Types.INTEGER);
		cs.registerOutParameter(10, Types.INTEGER);
		

		rs = cs.executeQuery();
		while (rs.next()) {
			bo = new MyPostsBO();
			bo.setPost_id(rs.getInt(4));
			bo.setPic_count(rs.getInt(5));
			bo.setArea(rs.getString(6));
			bo.setCity(rs.getString(7));
			bo.setBedrooms(rs.getInt(8));
			bo.setBathrooms(rs.getInt(9));
			bo.setAvg_rating(rs.getInt(10));

			ten_Posts.add(bo);
		}
		return ten_Posts;
	}
}
