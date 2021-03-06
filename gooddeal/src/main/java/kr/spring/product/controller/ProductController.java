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
import org.springframework.ui.Model;
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
	@RequestMapping(value="/product/write.do",method=RequestMethod.POST)
	public String submit(@Valid ProductVO productVO,
			BindingResult result,
			HttpServletRequest request,
			HttpSession session) {

		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return "productWrite";
		}

		//회원 번호 셋팅
		productVO.setMem_num((Integer)session.getAttribute("user_num"));
		//글쓰기
		productService.insertProduct(productVO);

		return "redirect:/product/list.do";

	}

	//===상품 목록 페이지 ===//
	//상품 목록
	@RequestMapping("/product/list.do")
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
				new PagingUtil(currentPage,count,9,10,"list.do","&keyword="+keyword);

		List<ProductVO> list = null;
		if(count > 0) {
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			list = productService.selectList(map);
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("productList");
		mav.addObject("count", count);
		mav.addObject("list",list);
		mav.addObject("pagingHtml",page.getPagingHtml());

		return mav;
	}

	//====상품  상세======//
	@RequestMapping("/product/detail.do")
	public ModelAndView detail(@RequestParam int pro_num) {
		if(log.isDebugEnabled()) {
			log.debug("<<pro_num>> : " + pro_num);
		}

		ProductVO product = productService.selectProduct(pro_num);

		return new ModelAndView("productView","product",product);

	}

	//=====상품 수정======//
	//수정 폼
	@RequestMapping(value="/product/update.do",method=RequestMethod.GET)
	public String formUpdate(@RequestParam int pro_num,Model model) {
		ProductVO productVO = productService.selectProduct(pro_num);
		model.addAttribute("productVO", productVO);

		return "productModify";
	}
	//수정 폼에서 전송된 데이터 처리
	@RequestMapping(value="/product/update.do",method=RequestMethod.POST)
	public String submitUpdate(@Valid ProductVO productVO,
			BindingResult result,
			HttpServletRequest request) {
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return "productModify";
		}

		//글 수정
		productService.updateProduct(productVO);

		return "redirect:/product/list.do";
	}

	//======상품 삭제========//
	@RequestMapping("/product/delete.do")
	public String submitDelete(@RequestParam int pro_num) {
		//상품 삭제
		productService.deleteProduct(pro_num);

		return "redirect:/product/list.do";
	}

	//이미지 출력
	@RequestMapping("/product/imageView.do")
	public ModelAndView viewImage(@RequestParam int pro_num, @RequestParam int img_num) {
		ProductVO product = productService.selectProduct(pro_num);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		
		if(img_num == 1) {
			mav.addObject("imageFile",product.getPro_uploadfile1());
			mav.addObject("filename", product.getPro_filename1());
		}else if(img_num == 2) {
			mav.addObject("imageFile",product.getPro_uploadfile2());
			mav.addObject("filename", product.getPro_filename2());
		}else if(img_num == 3) {
			mav.addObject("imageFile",product.getPro_uploadfile3());
			mav.addObject("filename", product.getPro_filename3());
		}
		
		return mav;
	}

}
