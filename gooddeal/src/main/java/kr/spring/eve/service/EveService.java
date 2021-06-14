package kr.spring.eve.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.eve.dao.EveMapper;
import kr.spring.eve.vo.EveReplyVO;
import kr.spring.eve.vo.EveVO;


@Service("eveService")
public class EveService {
	//의존 관계 설정
	@Resource
	private EveMapper eveMapper;

	//상품 등록
	public void insertEve(EveVO eve) {
		eveMapper.insertEve(eve);
	}

	//총 레코드 수
	public int selectRowCount(Map<String,Object> map) {
		return eveMapper.selectRowCount(map);
	}

	//상품 목록
	public List<EveVO> selectList(Map<String,Object> map){
		return eveMapper.selectList(map);
	}

	//판매자 정보 처리
	//총 레코드 수
	public int selectSellerRowCount(Map<String,Object> map) {
		return eveMapper.selectSellerRowCount(map);
	}

	//상품 목록
	public List<EveVO> selectSellerList(Map<String,Object> map){
		return eveMapper.selectSellerList(map);
	}

	//상품 상세
	public EveVO selectEve(Integer eve_num) {
		return eveMapper.selectEve(eve_num);
	}

	//상품 수정
	public void updateEve(EveVO eve) {
		eveMapper.updateEve(eve);
	}
	//상품 삭제
	public void deleteEve(Integer eve_num) {
		eveMapper.deleteReplyByBoardNum(eve_num);
		eveMapper.deleteEve(eve_num);
	}
	
	//============댓글=========//
	public List<EveReplyVO> selectListReply(Map<String, Object> map) {
		return eveMapper.selectListReply(map);
	}

	public int selectRowCountReply(Map<String, Object> map) {
		return eveMapper.selectRowCountReply(map);
	}

	public void insertReply(EveReplyVO boardReply) {
		eveMapper.insertReply(boardReply);
	}

	public void updateReply(EveReplyVO boardReply) {
		eveMapper.updateReply(boardReply);
	}

	public void deleteReply(Integer re_num) {
		eveMapper.deleteReply(re_num);
	}

}
