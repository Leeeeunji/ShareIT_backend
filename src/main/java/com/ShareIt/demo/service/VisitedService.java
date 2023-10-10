package com.ShareIt.demo.service;

import com.ShareIt.demo.domain.Visited;
import org.springframework.stereotype.Service;

@Service
public class VisitedService {
    Visited visited = Visited.getInstance();
    public void increase(){
        visited.plus();
    }
    public int getCount(){
        return visited.getCount();
    }
}
