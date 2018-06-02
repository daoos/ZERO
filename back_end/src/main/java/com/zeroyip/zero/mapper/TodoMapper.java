package com.zeroyip.zero.mapper;

import com.zeroyip.zero.pojo.Todo;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TodoMapper {
    List<Todo> findTodo(String userEmail);

    List<Todo> findFinishedTodo(String userEmail);

    List<Todo> findExpiredTodo(String userEmail);

    List<Todo> findTodoByDate(@Param("userEmail") String userEmail, @Param("date") String date);

    List<Todo> findTodoByPri(@Param("userEmail") String userEmail, @Param("priorityLevel") String priorityLevel);

    List<Todo> findExpiredTodoByPri(@Param("userEmail") String userEmail, @Param("priorityLevel") String priorityLevel);

    List<Todo> findTodoByInv(@Param("userEmail") String userEmail, @Param("invTitle") String invTitle);

    List<Todo> findExpiredTodoByInv(@Param("userEmail") String userEmail, @Param("invTitle") String invTitle);

    List<Todo> searchTodo(@Param("userEmail") String userEmail, @Param("todoContent") String todoContent);

    List<Todo> searchExpiredTodo(@Param("userEmail") String userEmail, @Param("todoContent") String todoContent);

    void addTodo(@Param("userEmail") String userEmail,
                 @Param("todoCreateTime") Date todoCreateTime,
                 @Param("todoContent") String todoContent,
                 @Param("todoReminderTime") Date todoReminderTime,
                 @Param("invTitle") String invTitle,
                 @Param("priorityLevel") String priorityLevel);

    int modifyTodo(@Param("todoNum") Integer todoNum, @Param("todoNewContent") Todo todoNewContent);

    int finishTodo(Integer invNum);

    int recoverTodo(Integer invNum);

    int deleteTodo(Integer todoNum);

    int deleteRedundancy();
}