package com.jdbc.controller;


import java.util.ArrayList;
import java.util.List;

import com.jdbc.common.BoardControllerI;
import com.jdbc.model.dto.Board;
import com.jdbc.model.service.BoardSevice;
import com.jdbc.view.BoardView;
import com.jdbc.view.MainView;
import static com.jdbc.common.JDBCTemplate.*;

public class BoardController implements BoardControllerI{

	BoardSevice service=new BoardSevice();
	public void mainMenu() {
		new MainView().mainMenu();
	}
	

	@Override
	public void boardMenu() {
		new BoardView().boardMenu();
		
	}

	

	@Override
	public void selectBoardAll() {
		List<Board> boards=service.selectBoardAll();
		new MainView().printBoards(boards);
		
	}

	@Override
	public void insertBoard() {
		Board board=new BoardView().insertBoard();
		int result=service.insertBoard(board);
		new MainView().printMsg(result>0?"등록 성공":"등록 실패");
		
		
	}

	@Override
	public void selectBoardByWriter() {
		int writer=Integer.parseInt(new MainView().inputData("작성자 idx"));
		List<Board> boards=service.selectBoardByWriter(writer);
		new MainView().printBoards(boards);
		
	}

	@Override
	public void selectBoardByTitle() {
		String title=new MainView().inputData("검색할 제목");
		List<Board> boards=service.selectBoardByTitle(title);
		new MainView().printBoards(boards);
		
	}

	@Override
	public void updateBoard() {
		int idx=Integer.parseInt(new MainView().inputData("수정할 게시물 idx"));
		Board board=new BoardView().updateBoard();
		int result=service.updateBoard(board, idx);
		new MainView().printMsg(result>0?"수정 성공":"수정실패");
		
	}

	@Override
	public void deleteBoard() {
		int idx=Integer.parseInt(new MainView().inputData("삭제할 게시물 idx"));
		int result=service.deleteBoard(idx);
		new MainView().printMsg(result>0?"삭제 성공":"삭제실패");
				
		
	}

}
