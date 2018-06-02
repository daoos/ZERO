package com.zeroyip.zero.mapper;

import com.zeroyip.zero.pojo.TeamworkMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeamworkMessageMapper {
    void sendMessage(TeamworkMessage teamworkMessage);
}