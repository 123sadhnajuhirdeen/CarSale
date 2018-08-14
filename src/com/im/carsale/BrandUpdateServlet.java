package com.im.carsale;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.im.carsale.controller.BrandController;
import com.im.carsale.model.Brand;

@WebServlet("/brand_update")
public class BrandUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		String name = request.getParameter("name");
		
		Brand brand  = new Brand();
		brand.setId(Integer.parseInt(id));
		brand.setName(name);
		
		boolean done = BrandController.update(brand);
		if(done) {
			response.sendRedirect("brand_list.jsp");
		}else {
			response.sendRedirect("brand_edit.jsp");
		}
	}

}
