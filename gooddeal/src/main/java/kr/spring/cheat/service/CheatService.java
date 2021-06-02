package kr.spring.cheat.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import kr.spring.cheat.dao.CheatMapper;
import kr.spring.cheat.vo.CheatVO;

@Service("cheatService")
public class CheatService {
	
	//의존 관계
	@Resource
	private CheatMapper cheatMapper;
	
	//글쓰기
	public void insertBoard(CheatVO board) {
		cheatMapper.insertBoard(board);
	}
	
	//총 레코드 수
	public int selectRowCount() {
		return cheatMapper.selectRowCount();
	}
	
	//글 목록
	public List<CheatVO> selectList(Map<String,Object> map){
		return cheatMapper.selectList(map);
	}
	
	//글 상세 페이지
	public CheatVO selectBoard(Integer board_num) {
		return cheatMapper.selectBoard(board_num);
	}
	
	//조회수 증가
	public void updateHit(Integer board_num) {
		cheatMapper.updateHit(board_num);
	}
	
	//글 수정
	public void updateBoard(CheatVO board) {
		cheatMapper.updateBoard(board);
	}
	
	//글 삭제
	public void deleteBoard(Integer che_num) {
		cheatMapper.deleteBoard(che_num);
	}	
	//관리자 확인
	public void updateCheatByAdmin(Integer che_num) {
		cheatMapper.updateCheatByAdmin(che_num);
	}

}
