package kr.spring.event.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.event.vo.EventVO;


public interface EventMapper {
    //글쓰기
	@Insert("INSERT INTO event (eve_num,mem_num,eve_title,eve_content,eve_user,eve_start,eve_end,eve_date,eve_status)  VALUES (event_seq.nextval,#{eve_num},#{mem_num},#{eve_title},#{eve_content},#{eve_user},#{eve_start},#{eve_end},#{eve_date},#{eve_status})")
	public void insertBoard(EventVO board);
	
	//총 레코드
	public int selectRowCount();
	
	//수정
	public void updateBoard(EventVO board);
	
	//목록
	public List<EventVO> selcetList(Map<String,Object> map);
	
	//이벤트 체크 페이지
	public List<EventVO> selcetCheck(Map<String,Object> map);
	
	//상세 페이지
	@Select("SELECT * FROM event b JOIN eve_num m ON b.mem_num WHERE b.eve_num=#{eve_num}")
	public EventVO selectBoard(Integer eve_num);
	
	//조회수 증가
	@Update("UPDATE event SET hit=hit+1 WHERE eve_num=#{eve_num}")
	public void updateHit(Integer board_num);
	
	//삭제
	@Delete("DELETE FROM event WHERE eve_num=#{eve_num}")
	public void deleteBoard(Integer eve_num);
}
