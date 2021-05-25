package kr.spring.product.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.product.vo.ProductVO;

public interface ProductMapper {
	//중고 장터
	
	//상품 등록
	@Insert("INSERT INTO product (pro_num,mem_num,pro_title,pro_tag,pro_price,pro_content,pro_status,pro_buy) VALUES (#{pro_num},#{mem_num},#{pro_title},#{pro_tag},#{pro_price},#{pro_content},#{pro_status},#{pro_buy})")
	public void insertProduct(ProductVO product);
	
	//총 레코드 수
		public int selectRowCount();
	
	//상품 목록
	public List<ProductVO> selectList(Map<String,Object> map);
	
	
}
