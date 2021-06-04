package kr.spring.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.service.BoardService;
import kr.spring.board.vo.BoardVO;
import kr.spring.product.service.ProductService;
import kr.spring.product.vo.ProductVO;
import kr.spring.util.PagingUtil;

@Controller
public class MainController {
	private Logger log = Logger.getLogger(this.getClass());

	//의존 관계 설정
	@Resource
	private ProductService productService;
	@Resource
	private BoardService boardService;

	//자바빈(VO) 초기화
	@ModelAttribute("productVO")
	public ProductVO initCommand() {
		return new ProductVO();
	}
	//상품 목록
	@RequestMapping("/main/main.do")
	public ModelAndView process(
			@RequestParam(value="pageNum",defaultValue="1") int currentPage,
			@RequestParam(value="keyword",defaultValue="") String keyword) {

		//중고 상품
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyword", keyword);
		map.put("start", 1);
		map.put("end", 6);
		List<ProductVO> list = productService.selectList(map);

		//게시판
		Map<String,Object> board_map = new HashMap<String,Object>();
		board_map.put("start", 1);
		board_map.put("end", 3);
		List<BoardVO> board_list = boardService.selectList(board_map);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		mav.addObject("list",list);
		mav.addObject("board_list",board_list);

		return mav;
	}


}
