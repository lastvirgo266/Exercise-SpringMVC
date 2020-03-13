package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;


import lombok.extern.log4j.Log4j;
import lombok.AllArgsConstructor;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) { 
		log.info("register ....  "+ board);
		mapper.insertSelectKey(board);
	}
	
	public BoardVO get(Long bno) { 
		log.info("get....." + bno);
		return mapper.read(bno);
	}
	
	public boolean modify(BoardVO board) {
	
		log.info("modify..........." + board);
		return mapper.update(board)==1;
	}
	
	public boolean remove(Long bno) {
		
		log.info("remove...." + bno);
		
		return mapper.delete(bno) == 1;
	}
	
	public List<BoardVO> getList(Criteria cri){
		
		log.info("getList.........");
		
		return mapper.getListWithPaging(cri);
	}
	
	
}
