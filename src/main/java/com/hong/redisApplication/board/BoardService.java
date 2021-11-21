package com.hong.redisApplication.board;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository repository;

    @Cacheable(key ="#p0", value = "getBoards" )
    public List<Board> getBoards(String size) {
        return repository.createBySize(size);
    }

    public List<Board> getNoCacheBoards(String size) {
        return repository.createBySize(size);
    }


    public static int getDbCount(){
        return BoardRepository.getDbCount();
    }
}
