package kr.spring.event.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.event.dao.EventMapper;
import kr.spring.event.vo.EventVO;


@Service("eventService")
public class EventService {
	
	//의존 관계
	@Resource
	private EventMapper eventMapper;
	
	//글쓰기
	public void insertBoard(EventVO board) {
		eventMapper.insertBoard(board);
	}
	
	//총 레코드 수
	public int selectRowCount() {
		return eventMapper.selectRowCount();
	}
	
	//글 목록
	public List<EventVO> selectList(Map<String,Object> map){
		return eventMapper.selcetList(map);
	}
	
	//글 상세 페이지
	public EventVO selectBoard(Integer board_num) {
		return eventMapper.selectBoard(board_num);
	}
	
	//조회수 증가
	public void updateHit(Integer board_num) {
		eventMapper.updateHit(board_num);
	}
	
	//글 수정
	public void updateBoard(EventVO board) {
		eventMapper.updateBoard(board);
	}
	
	//글 삭제
	public void deleteBoard(Integer board_num) {
		eventMapper.deleteBoard(board_num);
	}	

}
