package com.bit2016.vo;

public class AuthorDaoTest {

	public static void main(String[] args) {
		insertTest();
	}
	public static void insertTest() {
		//mock data
		AuthorVo vo = new AuthorVo();
		vo.setNo(200L);
		vo.setName("°øÀÚ");
		
		AuthorDao dao = new AuthorDao();
		dao.insert(vo);
	}
}
