package com.teja.service;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.teja.bo.MyPostsBO;
import com.teja.dao.MyPostsDAO;
import com.teja.dto.MyPostsDTO;
import com.teja.dto.SerializedMyPostsDTO;

public class MyPosts_Service {

	public List<MyPostsBO> getMyPosts(MyPostsDTO dto) throws NamingException, SQLException {

		int sno = dto.getSno();
		int uid = dto.getUid();
		int max_num = (sno * 10);
		int min_num = 0;

		if (sno == 1) {
			min_num = 1;
		} else if (sno > 2) {
			min_num = (max_num - 9);
		}
		SerializedMyPostsDTO serialDTO = new SerializedMyPostsDTO();
		serialDTO.setUid(uid);
		serialDTO.setMin_num(min_num);
		serialDTO.setMax_num(max_num);
		MyPostsDAO dao = new MyPostsDAO();
		List<MyPostsBO> al = dao.getMyPosts(serialDTO);
		return al;
	}
}
