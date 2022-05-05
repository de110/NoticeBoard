package com.ttff.board1.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.ttff.board1.domain.Board;
import com.ttff.board1.repository.BoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    // public List<Board> listAllBoards() {
    // return boardRepository.findAll();
    // }

    public boolean deleteBoard(@PathVariable Long id) {
        Optional<Board> board = boardRepository.findById(id);

        if (board.isPresent()) {
            boardRepository.delete(board.get());
            return true;
        }
        return false;
    }

    public Board findBoard(Long id) {
        return boardRepository.findById(id).get();
    }

    public List<Board> findAllBoard() {
        return boardRepository.findAll();
    }

    @Transactional
    public Board updateBoard(Long id, Board nBoard) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        board.update(nBoard.getTitle(), nBoard.getContents());
        return board;
    }
}
