package com.teja.service;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.teja.bo.PostsBO;
import com.teja.dao.UserPostsDAO;
import com.teja.dto.PostsDTO;
import com.teja.dto.SerializedPostsDTO;

public class Posts_Service {

	public List<PostsBO> getPosts(PostsDTO dto) throws NamingException, SQLException {

		int sno = dto.getSno();
		String city = dto.getCity();
		int max_num = (sno * 10);
		int min_num = 0;

		if (sno == 1) {
			min_num = 1;
		} else if (sno > 2) {
			min_num = (max_num - 9);
		}
		SerializedPostsDTO serialDTO = new SerializedPostsDTO();
		serialDTO.setCity(city);
		serialDTO.setMin_num(min_num);
		serialDTO.setMax_num(max_num);
		UserPostsDAO dao = new UserPostsDAO();
		List<PostsBO> al = dao.getPosts(serialDTO);
		return al;
	}
}
