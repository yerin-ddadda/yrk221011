package org.kosta.myproject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontControllerServletVer4
 */
@WebServlet("/FrontControllerServletVer4")
public class FrontControllerServletVer4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doDispatch(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doDispatch(request, response);
	}

	protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			Controller controller = null;
			if (command.equals("findCustomerById")) {
				controller = new FindCustomerByIdController();
			} 
			else if (command.equals("registerCustomer"))
			{
				controller = new RegisterCustomerController();
			}
			String path = controller.handleRequest(request, response);
			if(path.startsWith("redirect:")) {
				response.sendRedirect(path.substring(9));
			}else {
				//아니면 forward
			}
			request.getRequestDispatcher(path).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
