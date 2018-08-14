package com.im.carsale.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.im.carsale.DB;
import com.im.carsale.model.Brand;
import com.im.carsale.model.Member;

public class BrandController {

	public static boolean insert(Brand brand) {
		String sql = "INSERT INTO brand (name) "
				+ " VALUES (?)";
		
		try {
			Connection c = DB.getCon();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, brand.getName());
			
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
	
	
	public static boolean update(Brand brand) {
		String sql = "UPDATE brand SET name=? WHERE id=?";
		
		try {
			Connection c = DB.getCon();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, brand.getName());
			ps.setInt(2, brand.getId());
			
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
	
	public static boolean delete(int id) {
		String sql = "DELETE FROM brand WHERE id=?";
		
		try {
			Connection c = DB.getCon();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			
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
	
	public static List<Brand> list(){
		List<Brand> list = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM brand";
			Connection c = DB.getCon();
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Brand brand = new Brand();
				brand.setId(rs.getInt("id"));
				brand.setName(rs.getString("name"));
				list.add(brand);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static Brand get(int id){
		Brand brand = new Brand();
		try {
			String sql = "SELECT * FROM brand WHERE id=?";
			Connection c = DB.getCon();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				brand.setId(rs.getInt("id"));
				brand.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return brand;
	}
	
	
	
	
	
	
	
	
	
}
