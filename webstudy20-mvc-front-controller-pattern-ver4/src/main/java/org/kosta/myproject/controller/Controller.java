package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 		클라이언트의 요청을 처리하는 개별 컨트롤러의 상위 인터페이스 -> 표준화, 캡슐화
 * 		컨트롤러를 사용하는 측은 인터페이스의 추상 메소드 handleRequest 만 파악해서 사용하면 된다. -> 단일한 메세지 방식
 		* @author KOSTA
 *
 */
public interface Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
