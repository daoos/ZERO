package com.zeroyip.zero.mapper;

import com.zeroyip.zero.pojo.Memorandum;
import com.zeroyip.zero.pojo.MemorandumExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemorandumMapper {
    List<Memorandum> findMemorandum(String userEmail);

    void addMemorandum(@Param("userEmail") String userEmail, @Param("memorandum") Memorandum memorandum);

    int patchMemorandum(@Param("memorandumNum") Integer memorandumNum, @Param("content") Memorandum content);

    int deleteMemorandum(Integer memorandumNum);
}