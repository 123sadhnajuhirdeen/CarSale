package com.im.carsale;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.im.carsale.controller.BrandController;
import com.im.carsale.controller.MemberController;
import com.im.carsale.model.Brand;
import com.im.carsale.model.Member;

@WebServlet("/brand_add")
public class BrandAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		Brand brand  = new Brand();
		brand.setName(name);
		
		boolean done = BrandController.insert(brand);
		if(done) {
			response.sendRedirect("brand_list.jsp");
		}else {
			response.sendRedirect("brand_add.jsp");
		}
	}

}
