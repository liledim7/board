package com.jdbc.common;

public interface Controller {

	void memberMenu();
	void boardMenu();
	void selectMemberAll();
	void selectMemberById();
	void selectMemberByName();
	void insertMember();
	void updateMember();
	void deleteMember();
	void selectBoardAll();
	void insertBoard();
	void selectBoardByWriter();
	void selectBoardByTitle();
	void updateBoard();
	void deleteBoard();
}
