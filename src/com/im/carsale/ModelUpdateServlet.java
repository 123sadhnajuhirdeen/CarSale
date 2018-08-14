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

@WebServlet("/model_update")
public class ModelUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		String name = request.getParameter("name");
		String brandId = request.getParameter("brand_id");
		
		Model model  = new Model();
		model.setId(Integer.parseInt(id));
		Brand brand = BrandController.get(Integer.parseInt(brandId));
		model.setBrand(brand);
		model.setName(name);
		
		boolean done = ModelController.update(model);
		if(done) {
			response.sendRedirect("model_list.jsp");
		}else {
			response.sendRedirect("model_edit.jsp");
		}
	}

}
