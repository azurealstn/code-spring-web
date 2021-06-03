package com.azurealstn.codespringweb.service;

import com.azurealstn.codespringweb.domain.BoardVO;
import com.azurealstn.codespringweb.domain.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardService {

    public void register(BoardVO boardVO);

    public BoardVO get(Long bno);

    public boolean modify(BoardVO boardVO);

    public boolean remove(Long bno);

    public List<BoardVO> getList(Criteria criteria);

    public int getTotal(Criteria criteria);
}
