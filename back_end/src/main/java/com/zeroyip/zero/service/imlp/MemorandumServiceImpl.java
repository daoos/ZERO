package com.zeroyip.zero.service.imlp;

import com.zeroyip.zero.mapper.MemorandumMapper;
import com.zeroyip.zero.pojo.Memorandum;
import com.zeroyip.zero.service.MemorandumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// @Rollback
@Transactional
@Service("memorandumService")
public class MemorandumServiceImpl implements MemorandumService {
    @Autowired(required = false)
    private MemorandumMapper memorandumMapper;

    @Override
    public List<Memorandum> findMemorandum(String userEmail) {
        return memorandumMapper.findMemorandum(userEmail);
    }

    @Override
    public void addMemorandum(String userEmail, Memorandum memorandum) {
        memorandumMapper.addMemorandum(userEmail, memorandum);
    }

    @Override
    public String patchMemorandum(Integer memorandumNum, Memorandum content) {
        if ( memorandumMapper.patchMemorandum(memorandumNum, content) != 0 ) {
            return "true";
        }
        else {
            return "false";
        }
    }

    @Override
    public String deleteMemorandum(Integer memorandumNum) {
        if ( memorandumMapper.deleteMemorandum(memorandumNum) != 0 ) {
            return "true";
        }
        else {
            return "false";
        }
    }
}
