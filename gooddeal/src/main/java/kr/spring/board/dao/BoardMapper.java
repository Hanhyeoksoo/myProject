package kr.spring.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.board.vo.BoardVO;

public interface BoardMapper {
	//글쓰기
	@Insert("INSERT INTO sprboard (board_num,title,content,uploadfile,filename,ip,mem_num) VALUES (sprboard_seq.nextval,#{title},#{content},#{uploadfile},#{filename},#{ip},#{mem_num})")
	public void insertBoard(BoardVO board);
	
	//총 레코드 수
	public int selectRowCount();
	
	//글 목록
	public List<BoardVO> selectList(Map<String,Object> map);
	
	//글 상세 페이지
	@Select("SELECT * FROM sprboard b JOIN member m ON b.mem_num=m.mem_num WHERE b.board_num=#{board_num}")
	public BoardVO selectBoard(Integer board_num);
	
	//조회수 증가
	@Update("UPDATE sprboard SET hit=hit+1 WHERE board_num=#{board_num}")
	public void updateHit(Integer board_num);
	
	//글 수정
	public void updateBoard(BoardVO board);
	
	//글 삭제
	@Delete("DELETE FROM sprboard WHERE board_num=#{board_num}")
	public void deleteBoard(Integer board_num);
	
}


