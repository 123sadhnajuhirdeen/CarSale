package com.im.carsale;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.im.carsale.controller.BrandController;
import com.im.carsale.model.Brand;

@WebServlet("/brand_delete")
public class BrandDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		boolean done = BrandController.delete(Integer.parseInt(id));
		if(done) {
			response.sendRedirect("brand_list.jsp");
		}else {
			response.sendRedirect("brand_list.jsp");
		}
	}


}
