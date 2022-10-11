package org.kosta.myproject.test;

public class TestCaseStringRedirect {
	public static void main(String[] args) {
		String path = "redirect:register-result.jsp";
		System.out.println(path.startsWith("redirect:"));
		//위 문자열 path를 redirect:를 제외하고 path로 출력
		System.out.println("redirect:".trim().length());
		System.out.println(path.substring(9));
	}
	
}
