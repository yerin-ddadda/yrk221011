package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.CustomerVO;
import org.kosta.myproject.model.MockDAO;

public class FindCustomerByIdController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = null;
		String id = request.getParameter("customerId");
		CustomerVO vo = MockDAO.getInstacne().findCustomerById(id);
		if(vo!=null) {
			request.setAttribute("vo", vo);
			path = "findbyid-ok.jsp";
		}else {
			path = "findbyid-fail.jsp";
		}
		return path; //컨트롤러에서 경로를 반환만 시켜줌
	}

}
