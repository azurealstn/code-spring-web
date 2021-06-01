package com.azurealstn.codespringweb.mapper;

import com.azurealstn.codespringweb.domain.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void testGetList() {
        boardMapper.getList().forEach(board -> log.info("board: " + board));
    }

    @Test
    public void testInsert() {
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("제목");
        boardVO.setContent("내용");
        boardVO.setWriter("나");

        boardMapper.insert(boardVO);

        log.info("boardVO: " + boardVO);
    }

    @Test
    public void testInsertSelectKey() {
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("제목");
        boardVO.setContent("내용");
        boardVO.setWriter("나");

        boardMapper.insertSelectKey(boardVO);

        log.info("boardVO: " + boardVO);
    }

    @Test
    public void testRead() {
        //존재하는 게시물 번호로 테스트할 것
        BoardVO boardVO = boardMapper.read(5L);

        log.info("boardVO: " + boardVO);
    }

    @Test
    public void testDelete() {
        log.info("delete count: " + boardMapper.delete(3L));
    }

    @Test
    public void testUpdate() {
        BoardVO boardVO = new BoardVO();
        boardVO.setBno(5L);
        boardVO.setTitle("수정된 제목");
        boardVO.setContent("수정된 내용");
        boardVO.setWriter("수정된 나");

        int count = boardMapper.update(boardVO);
        log.info("update count: " + count);
    }
}
