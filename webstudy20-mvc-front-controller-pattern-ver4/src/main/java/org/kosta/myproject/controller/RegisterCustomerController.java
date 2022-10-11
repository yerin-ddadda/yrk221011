package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.CustomerVO;
import org.kosta.myproject.model.MockDAO;

public class RegisterCustomerController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MockDAO dao = MockDAO.getInstacne();
		dao.registerCustomer(new CustomerVO(request.getParameter("customerId"),request.getParameter("customerName"), request.getParameter("customerAddress")));
		System.out.println("고객 등록 컨트롤러 : " + request.getParameter("customerName"));
		return "redirect:register-result.jsp";
	}

}
