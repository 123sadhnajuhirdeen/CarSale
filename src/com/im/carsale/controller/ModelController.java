package com.im.carsale.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.im.carsale.DB;
import com.im.carsale.model.Brand;
import com.im.carsale.model.Member;
import com.im.carsale.model.Model;

public class ModelController {

	public static boolean insert(Model model) {
		String sql = "INSERT INTO model (brand_id,name) "
				+ " VALUES (?,?)";
		
		try {
			Connection c = DB.getCon();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, model.getBrand().getId());
			ps.setString(2, model.getName());
			
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
	
	
	public static boolean update(Model model) {
		String sql = "UPDATE model SET brand_id=?,name=? WHERE id=?";
		
		try {
			Connection c = DB.getCon();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, model.getBrand().getId());
			ps.setString(2, model.getName());
			ps.setInt(3, model.getId());
			
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
		String sql = "DELETE FROM model WHERE id=?";
		
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
	
	public static List<Model> list(){
		List<Model> list = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM model";
			Connection c = DB.getCon();
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Model model = new Model();
				model.setId(rs.getInt("id"));
				model.setName(rs.getString("name"));
				Brand brand = BrandController.get(rs.getInt("brand_id"));
				model.setBrand(brand);
				list.add(model);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static Model get(int id){
		Model model = new Model();
		try {
			String sql = "SELECT * FROM model WHERE id=?";
			Connection c = DB.getCon();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				model.setId(rs.getInt("id"));
				model.setName(rs.getString("name"));
				Brand brand = BrandController.get(rs.getInt("brand_id"));
				model.setBrand(brand);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	
	
	
	
	
	
	
}
