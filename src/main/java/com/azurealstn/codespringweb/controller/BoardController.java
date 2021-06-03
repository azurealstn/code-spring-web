package com.azurealstn.codespringweb.controller;

import com.azurealstn.codespringweb.domain.BoardVO;
import com.azurealstn.codespringweb.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@AllArgsConstructor
@RequestMapping("/board/*")
@Controller
public class BoardController {

    private BoardService boardService;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("list");
        model.addAttribute("list", boardService.getList());
    }

    @PostMapping("/register")
    public String register(BoardVO boardVO, RedirectAttributes redirectAttributes) {
        log.info("register: " + boardVO);

        boardService.register(boardVO);

        redirectAttributes.addFlashAttribute("result", boardVO.getBno());

        return "redirect:/board/list";
    }

    @PostMapping("/modify")
    public String modify(BoardVO boardVO, RedirectAttributes redirectAttributes) {
        log.info("modify: " + boardVO);

        if (boardService.modify(boardVO)) redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno, RedirectAttributes redirectAttributes) {
        log.info("remove: " + bno);

        if (boardService.remove(bno)) redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/board/list";
    }

    //글 등록 페이지
    @GetMapping("/register")
    public void register() {

    }

    //조회 페이지
    @GetMapping({"/get", "/modify"})
    public void get(@RequestParam("bno") Long bno, Model model) {
        log.info("/get or modify");
        model.addAttribute("board", boardService.get(bno));
    }
}
