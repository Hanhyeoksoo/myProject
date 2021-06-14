package kr.spring.eve.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.eve.vo.EveReplyVO;
import kr.spring.eve.vo.EveVO;


public interface EveMapper {
	//중고 장터

	//상품 등록
	@Insert("INSERT INTO eve (eve_num,mem_num,eve_title,eve_tag,eve_price,eve_content,eve_status,eve_date,eve_buy,eve_uploadfile1,eve_filename1,eve_uploadfile2,eve_filename2,eve_uploadfile3,eve_filename3) VALUES (eve_seq.nextval,#{mem_num},#{eve_title},#{eve_tag},#{eve_price},#{eve_content},#{eve_status},SYSDATE,#{eve_buy},#{eve_uploadfile1},#{eve_filename1},#{eve_uploadfile2},#{eve_filename2},#{eve_uploadfile3},#{eve_filename3})")
	public void insertEve(EveVO eve);

	//총 레코드 수
	public int selectRowCount(Map<String,Object> map);

	//상품 목록
	public List<EveVO> selectList(Map<String,Object> map);

	//상품 상세 페이지
	@Select("SELECT * FROM eve p JOIN member m ON p.mem_num=m.mem_num WHERE eve_num=#{eve_num}")
	public EveVO selectEve(Integer eve_num);

	//상품 수정
	public void updateEve(EveVO eve);

	//상품 삭제
	@Delete("DELETE FROM eve WHERE eve_num=#{eve_num}")
	public void deleteEve(Integer eve_num);

	//판매자 정보 처리
	//총 레코드 수
	public int selectSellerRowCount(Map<String,Object> map);

	//상품 목록
	public List<EveVO> selectSellerList(Map<String,Object> map);

	//=================댓글===============//
	//댓글
	public List<EveReplyVO> selectListReply(Map<String,Object> map);
	@Select("SELECT COUNT(*) FROM eve_reply WHERE eve_num=#{eve_num}")
	public int selectRowCountReply(Map<String,Object> map);
	@Insert("INSERT INTO eve_reply (rep_num,rep_content,eve_num,mem_num) VALUES (eve_reply_seq.nextval,#{rep_content},#{eve_num},#{mem_num})")
	public void insertReply(EveReplyVO eveReply);
	@Update("UPDATE eve_reply SET rep_content=#{rep_content} WHERE rep_num=#{rep_num}")
	public void updateReply(EveReplyVO eveReply);
	@Delete("DELETE FROM eve_reply WHERE rep_num=#{rep_num}")
	public void deleteReply(Integer rep_num);
	//부모글 삭제시 댓글이 존재하면 부모글 삭제전 댓글 삭제
	@Delete("DELETE FROM eve_reply WHERE eve_num=#{eve_num}")
	public void deleteReplyByBoardNum(Integer eve_num);
}
