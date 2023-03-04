package com.communitysite.mapper;

import java.util.List;

import com.communitysite.domain.BoardVO;

public interface BoardMapper {
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
}
