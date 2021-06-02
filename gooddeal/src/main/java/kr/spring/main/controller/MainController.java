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

import kr.spring.product.service.ProductService;
import kr.spring.product.vo.ProductVO;
import kr.spring.util.PagingUtil;

@Controller
public class MainController {
	private Logger log = Logger.getLogger(this.getClass());

	//의존 관계 설정
	@Resource
	private ProductService productService;

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

			Map<String,Object> map = new HashMap<String,Object>();
			map.put("keyword", keyword);
			//총 레코드 수
			int count = productService.selectRowCount(map);

			if(log.isDebugEnabled()) {
				log.debug("<<pageNum>> : " + currentPage);
				log.debug("<<count>> : " + count);
			}

			//페이징 처리
			PagingUtil page = 
					new PagingUtil(currentPage,count,6,10,"list.do","&keyword="+keyword);

			List<ProductVO> list = null;
			if(count > 0) {
				map.put("start", page.getStartCount());
				map.put("end", page.getEndCount());
				list = productService.selectList(map);
			}

			ModelAndView mav = new ModelAndView();
			mav.setViewName("main");
			mav.addObject("list",list);

			return mav;
		}

}
