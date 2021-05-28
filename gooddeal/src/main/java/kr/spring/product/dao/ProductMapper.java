package kr.spring.product.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.product.vo.ProductReplyVO;
import kr.spring.product.vo.ProductVO;

public interface ProductMapper {
	//중고 장터

	//상품 등록
	@Insert("INSERT INTO product (pro_num,mem_num,pro_title,pro_tag,pro_price,pro_content,pro_status,pro_date,pro_buy,pro_uploadfile1,pro_filename1,pro_uploadfile2,pro_filename2,pro_uploadfile3,pro_filename3) VALUES (product_seq.nextval,#{mem_num},#{pro_title},#{pro_tag},#{pro_price},#{pro_content},#{pro_status},SYSDATE,#{pro_buy},#{pro_uploadfile1},#{pro_filename1},#{pro_uploadfile2},#{pro_filename2},#{pro_uploadfile3},#{pro_filename3})")
	public void insertProduct(ProductVO product);

	//총 레코드 수
	public int selectRowCount();

	//상품 목록
	public List<ProductVO> selectList(Map<String,Object> map);

	//상품 상세 페이지
	@Select("SELECT * FROM product p JOIN member m ON p.mem_num=m.mem_num WHERE pro_num=#{pro_num}")
	public ProductVO selectProduct(Integer pro_num);

	//상품 수정
	public void updateProduct(ProductVO product);

	//상품 삭제
	@Delete("DELETE FROM product WHERE pro_num=#{pro_num}")
	public void deleteProduct(Integer pro_num);

	//판매자 정보 처리
	//총 레코드 수
	public int selectSellerRowCount(Map<String,Object> map);

	//상품 목록
	public List<ProductVO> selectSellerList(Map<String,Object> map);

	//=================댓글===============//
	//댓글
	public List<ProductReplyVO> selectListReply(Map<String,Object> map);
	@Select("SELECT COUNT(*) FROM product_reply WHERE pro_num=#{pro_num}")
	public int selectRowCountReply(Map<String,Object> map);
	@Insert("INSERT INTO product_reply (rep_num,rep_content,pro_num,mem_num) VALUES (pro_reply_seq.nextval,#{rep_content},#{pro_num},#{mem_num})")
	public void insertReply(ProductReplyVO productReply);
	@Update("UPDATE product_reply SET rep_content=#{rep_content} WHERE rep_num=#{rep_num}")
	public void updateReply(ProductReplyVO productReply);
	@Delete("DELETE FROM product_reply WHERE rep_num=#{rep_num}")
	public void deleteReply(Integer rep_num);
	//부모글 삭제시 댓글이 존재하면 부모글 삭제전 댓글 삭제
	@Delete("DELETE FROM product_reply WHERE pro_num=#{pro_num}")
	public void deleteReplyByBoardNum(Integer pro_num);
}
