package com.zeroyip.zero.service;

import com.zeroyip.zero.pojo.Todo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("todoService")
public interface TodoService {
    List<Todo> findTodo(String userEmail);

    List<Todo> findFinishedTodo(String userEmail);

    List<Todo> findExpiredTodo(String userEmail);

    List<Todo> findTodoByDate(String userEmail, String date);

    List<Todo> findTodoByPri(String userEmail, String priorityLevel);

    List<Todo> findExpiredTodoByPri(String userEmail, String priorityLevel);

    List<Todo> findTodoByInv(String userEmail, String invTitle);

    List<Todo> findExpiredTodoByInv(String userEmail, String invTitle);

    List<Todo> searchTodo(String userEmail, String todoContent);

    List<Todo> searchExpiredTodo(String userEmail, String todoContent);

    void addTodo(String userEmail,
                 Date todoCreateTime,
                 String todoContent,
                 Date todoReminderTime,
                 String invTitle,
                 String priorityLevel);

    String modifyTodo(Integer todoNum, Todo todoNewContent);

    String finishTodo(Integer invNum);

    String recoverTodo(Integer invNum);

    String deleteTodo(Integer todoNum);
}
