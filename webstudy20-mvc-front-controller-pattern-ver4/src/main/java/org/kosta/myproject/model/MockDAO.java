package org.kosta.myproject.model;
// Mock : 가짜, 모조, MockDAO : 테스트를 위한 모조 객체
// Singleton Pattern : 시스템 상에서 단 하나의 객체를 생성 ( 특정 클래스의 인스턴스 )해서
//									공유해 사용하고자 할 때 적용하는 설계 패턴
//									외부에서 생성하는 것을 차단, private 생성자, 
//									객체를 반복해서 생성하지 않으므로 서버의 자원을 절약
public class MockDAO {
	private static MockDAO instance = new MockDAO();
	private MockDAO() {}
	public static MockDAO getInstacne() {
		return instance;
	}
	
	public CustomerVO findCustomerById(String id) {
		CustomerVO vo = null;
		if(id!=null && id.equals("java"))
			vo = new CustomerVO(id, "아이유", "오리");
		return vo;
	}
	
	public void registerCustomer(CustomerVO customerVO) {
		System.out.println("register customer "+customerVO);
	}
}
