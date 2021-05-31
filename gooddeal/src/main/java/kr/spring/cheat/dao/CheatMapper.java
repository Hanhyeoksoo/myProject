package kr.spring.cheat.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import kr.spring.cheat.vo.CheatVO;

public interface CheatMapper {
    //글쓰기
	@Insert("INSERT INTO cheat_board (che_num,mem_num,che_title,che_content,che_pnum,che_date)  VALUES (cheat_board_seq.nextval,#{mem_num},#{che_title},#{che_content},#{che_pnum},SYSDATE)")
	public void insertBoard(CheatVO board);
	
	//총 레코드
	public int selectRowCount();
	
	//수정
	public void updateBoard(CheatVO board);
	
	//목록
	public List<CheatVO> selectList(Map<String,Object> map);
	
	//상세 페이지
	@Select("SELECT * FROM cheat_board b JOIN member m ON b.mem_num=m.mem_num WHERE b.che_num=#{che_num}")
	public CheatVO selectBoard(Integer cheat_num);
	
	//조회수 증가
	@Update("UPDATE cheat_board SET che_view=che_view+1 WHERE che_num=#{che_num}")
	public void updateHit(Integer chaet_num);
	
	//삭제
	@Delete("DELETE FROM cheat_board WHERE che_num=#{che_num}")
	public void deleteBoard(Integer cheat_num);
}
