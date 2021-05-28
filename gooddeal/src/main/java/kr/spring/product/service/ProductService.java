package kr.spring.product.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.product.dao.ProductMapper;
import kr.spring.product.vo.ProductReplyVO;
import kr.spring.product.vo.ProductVO;


@Service("productService")
public class ProductService {
	//의존 관계 설정
	@Resource
	private ProductMapper productMapper;

	//상품 등록
	public void insertProduct(ProductVO product) {
		productMapper.insertProduct(product);
	}

	//총 레코드 수
	public int selectRowCount() {
		return productMapper.selectRowCount();
	}

	//상품 목록
	public List<ProductVO> selectList(Map<String,Object> map){
		return productMapper.selectList(map);
	}

	//판매자 정보 처리
	//총 레코드 수
	public int selectSellerRowCount(Map<String,Object> map) {
		return productMapper.selectSellerRowCount(map);
	}

	//상품 목록
	public List<ProductVO> selectSellerList(Map<String,Object> map){
		return productMapper.selectSellerList(map);
	}

	//상품 상세
	public ProductVO selectProduct(Integer pro_num) {
		return productMapper.selectProduct(pro_num);
	}

	//상품 수정
	public void updateProduct(ProductVO product) {
		productMapper.updateProduct(product);
	}
	//상품 삭제
	public void deleteProduct(Integer pro_num) {
		productMapper.deleteReplyByBoardNum(pro_num);
		productMapper.deleteProduct(pro_num);
	}
	
	//============댓글=========//
	public List<ProductReplyVO> selectListReply(Map<String, Object> map) {
		return productMapper.selectListReply(map);
	}

	public int selectRowCountReply(Map<String, Object> map) {
		return productMapper.selectRowCountReply(map);
	}

	public void insertReply(ProductReplyVO boardReply) {
		productMapper.insertReply(boardReply);
	}

	public void updateReply(ProductReplyVO boardReply) {
		productMapper.updateReply(boardReply);
	}

	public void deleteReply(Integer re_num) {
		productMapper.deleteReply(re_num);
	}

}
