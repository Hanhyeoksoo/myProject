package kr.spring.product.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.product.dao.ProductMapper;
import kr.spring.product.vo.ProductVO;


@Service("boardService")
public class ProductService {
	//의존 관계 설정
	@Resource
	private ProductMapper productMapper;
		
	//상품 등록
	public void insertBoard(ProductVO product) {
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
		
}
