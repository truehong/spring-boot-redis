package com.hong.redisApplication.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    BoardService service;

    @GetMapping("/boards")
    public List<Board> boards(String size) {
        List<Board> boards = service.getBoards(size);
        return boards;
    }

    @GetMapping("/v1/boards")
    public List<Board> NoCacheBoards(String size) {
        List<Board> boards = service.getNoCacheBoards(size);
        return boards;
    }

    @GetMapping("/count")
    public int count() {
        return service.getDbCount();
    }
}
