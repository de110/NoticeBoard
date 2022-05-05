package com.ttff.board1.controller;

import java.util.List;
import java.util.Optional;

import com.ttff.board1.domain.Board;
import com.ttff.board1.repository.BoardRepository;
import com.ttff.board1.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/board")
public class BoardController {
    @Autowired
    private final BoardService boardService;

    @PostMapping
    public Board put(@RequestBody Board board) {
        // return boardRep.save(board);
        return boardService.createBoard(board);
    }
    // // POST로 유저 추가
    // @PostMapping
    // public Board put(@RequestParam String name, @RequestParam String age) {
    // return boardRep.save(new Board(name, age));
    // }

    // 전체 테이블 가져오기
    @GetMapping
    public List<Board> allBoard() {
        return boardService.findAllBoard();
    }

    // id로 테이블 값 가져오기
    @GetMapping(value = "/{id}")
    public Board findOne(@PathVariable Long id) {
        return boardService.findBoard(id);
    }

    // id로 테이블 값 수정
    @PutMapping(value = "/{id}")
    public Board update(@PathVariable Long id, @RequestBody Board board) {
        return boardService.updateBoard(id, board);
    }

    // id로 테이블 값 삭제
    @DeleteMapping
    public void delete(@RequestParam Long id) {
        boardService.deleteBoard(id);
    }
}