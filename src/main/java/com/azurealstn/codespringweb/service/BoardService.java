package com.azurealstn.codespringweb.service;

import com.azurealstn.codespringweb.domain.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardService {

    public void register(BoardVO boardVO);

    public BoardVO get(Long bno);

    public boolean modify(BoardVO boardVO);

    public boolean remove(Long bno);

    public List<BoardVO> getList();
}
