package com.zeroyip.zero.service;

import com.zeroyip.zero.pojo.Memorandum;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("memorandumService")
public interface MemorandumService {
    List<Memorandum> findMemorandum(String userEmail);

    void addMemorandum(String userEmail, Memorandum memorandum);

    String patchMemorandum(Integer memorandumNum, Memorandum content);

    String deleteMemorandum(Integer memorandumNum);
}
