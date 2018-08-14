package com.im.carsale;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.im.carsale.controller.BrandController;
import com.im.carsale.controller.ModelController;
import com.im.carsale.model.Brand;
import com.im.carsale.model.Model;
 
@WebServlet("/model_add")
public class ModelAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brandId = request.getParameter("brand_id");
		String name = request.getParameter("name");
		
		Model model  = new Model();
		model.setName(name);
		
		Brand brand = BrandController.get(Integer.parseInt(brandId));
		model.setBrand(brand);
		
		boolean done = ModelController.insert(model);
		if(done) {
			response.sendRedirect("model_list.jsp");
		}else {
			response.sendRedirect("model_add.jsp");
		}
	}

}
