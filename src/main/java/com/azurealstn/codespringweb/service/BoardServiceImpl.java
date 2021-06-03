package com.azurealstn.codespringweb.service;

import com.azurealstn.codespringweb.domain.BoardVO;
import com.azurealstn.codespringweb.domain.Criteria;
import com.azurealstn.codespringweb.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private BoardMapper boardMapper;

    @Override
    public void register(BoardVO boardVO) {
        log.info("register.........." + boardVO);

        boardMapper.insertSelectKey(boardVO);
    }

    @Override
    public BoardVO get(Long bno) {
        log.info("get.............." + bno);
        return boardMapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO boardVO) {
        log.info("modify.........." + boardVO);
        return boardMapper.update(boardVO) == 1;
    }

    @Override
    public boolean remove(Long bno) {
        log.info("remove........" + bno);
        return boardMapper.delete(bno) == 1;
    }

    @Override
    public List<BoardVO> getList(Criteria criteria) {
        log.info("get List with criteria: " + criteria);
        return boardMapper.getListWithPaging(criteria);
    }

    @Override
    public int getTotal(Criteria criteria) {
        log.info("get total count");
        return boardMapper.getTotalCount(criteria);
    }


}
