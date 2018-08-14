package com.im.carsale.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.im.carsale.DB;
import com.im.carsale.model.Member;

public class MemberController {

	
	public static boolean insert(Member member) {
		String sql = "INSERT INTO member (name, email, phone, password,reg_date,role,status) "
				+ " VALUES (?,?,?,?,now(),'m',1)";
		
		try {
			Connection c = DB.getCon();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getEmail());
			ps.setString(3, member.getPhone());
			ps.setString(4, member.getPassword());
			
			int rows = ps.executeUpdate();
			if(rows>0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
