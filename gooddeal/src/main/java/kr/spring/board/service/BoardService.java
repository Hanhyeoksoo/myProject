package kr.spring.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.board.dao.BoardMapper;
import kr.spring.board.vo.BoardVO;

@Service("boardService")
public class BoardService {
	//의존 관계 설정
	@Resource
	private BoardMapper boardMapper;
	
	//글쓰기
	public void insertBoard(BoardVO board) {
		boardMapper.insertBoard(board);
	}
	
	//총 레코드 수
	public int selectRowCount() {
		return boardMapper.selectRowCount();
	}
	
	//글 목록
	public List<BoardVO> selectList(Map<String,Object> map){
		return boardMapper.selectList(map);
	}
	
	//글 상세 페이지
	public BoardVO selectBoard(Integer board_num) {
		return boardMapper.selectBoard(board_num);
	}
	
	//조회수 증가
	public void updateHit(Integer board_num) {
		boardMapper.updateHit(board_num);
	}
	
	//글 수정
	public void updateBoard(BoardVO board) {
		boardMapper.updateBoard(board);
	}
	
	//글 삭제
	public void deleteBoard(Integer board_num) {
		boardMapper.deleteBoard(board_num);
	}
	
}






