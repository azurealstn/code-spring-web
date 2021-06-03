package com.azurealstn.codespringweb.service;

import com.azurealstn.codespringweb.domain.BoardVO;
import com.azurealstn.codespringweb.domain.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void testExist() {
        log.info("boardService: " + boardService);
        assertNotNull(boardService);
    }

    @Test
    public void testRegister() {
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("새로 작성하는 제목");
        boardVO.setContent("새로 작성하는 내용");
        boardVO.setWriter("새로 작성하는 나");

        boardService.register(boardVO);

        log.info("생성된 게시물의 번호: " + boardVO.getBno());
    }

    @Test
    public void testGetList() {
        //boardService.getList().forEach(board -> log.info("board: " + board));
        boardService.getList(new Criteria(2, 10)).forEach(board -> log.info("board: " + board));
    }

    @Test
    public void testGet() {
        log.info("boardService.get: " + boardService.get(1L));
    }

    @Test
    public void testDelete() {
        log.info("Remove result: " + boardService.remove(2L));
    }

    @Test
    public void testUpdate() {
        BoardVO boardVO = boardService.get(4L);

        if (boardVO == null) return;

        boardVO.setTitle("제목을 수정합니다.");
        log.info("modify result: " + boardService.modify(boardVO));
    }
}
