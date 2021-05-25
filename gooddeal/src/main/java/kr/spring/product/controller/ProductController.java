package kr.spring.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.product.service.ProductService;
import kr.spring.product.vo.ProductVO;
import kr.spring.util.PagingUtil;

@Controller
public class ProductController {
	private Logger log = Logger.getLogger(this.getClass());
	
	//의존 관계 설정
	@Resource
	private ProductService productService;
	
	//자바빈(VO) 초기화
	@ModelAttribute("productVO")
	public ProductVO initCommand() {
		return new ProductVO();
	}
	
	//====상품 등록 페이지====
	//상품 등록폼
	@RequestMapping(value="/product/write.do",method=RequestMethod.GET)
	public String form() {
		return "productWrite";
	}
	
	//전송된 데이터 처리
//	@RequestMapping(value="/product/write.do",method=RequestMethod.POST)
//	public String submit(@Valid ProductVO productVO,
//			             BindingResult result,
//			             HttpServletRequest request,
//			             HttpSession session) {
//		
//		return "redirect:/product/list.do";
//	}
	
	//===상품 목록 페이지 ===//
	//상품 목록
	@RequestMapping("/product/list.do")
	public ModelAndView process(
	@RequestParam(value="pageNum",defaultValue="1") int currentPage) {
		
		//총 레코드 수
				/*int count = productService.selectRowCount();
				
				if(log.isDebugEnabled()) {
					log.debug("<<pageNum>> : " + currentPage);
					log.debug("<<count>> : " + count);
				}
				
				//페이징 처리
				PagingUtil page = 
						new PagingUtil(currentPage,count,10,10,"list.do");
				
				List<ProductVO> list = null;
				if(count > 0) {
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("start", page.getStartCount());
					map.put("end", page.getEndCount());
					list = productService.selectList(map);
				}
				*/
				ModelAndView mav = new ModelAndView();
				mav.setViewName("productList");
				//mav.addObject("count", count);
				//mav.addObject("list",list);
				//mav.addObject("pagingHtml",page.getPagingHtml());
				
				return mav;
	}
	
	
	
	
	
	
	
	
	}
