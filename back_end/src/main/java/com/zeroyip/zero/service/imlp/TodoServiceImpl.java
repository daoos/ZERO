package com.zeroyip.zero.service.imlp;

import com.zeroyip.zero.mapper.TodoMapper;
import com.zeroyip.zero.pojo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeroyip.zero.service.TodoService;

import java.util.Date;
import java.util.List;

// @Rollback
@Transactional
@Service("todoService")
public class TodoServiceImpl implements TodoService {
    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Override
    public List<Todo> findTodo(String userEmail) {
        return todoMapper.findTodo(userEmail);
    }

    @Override
    public List<Todo> findFinishedTodo(String userEmail) {
        return todoMapper.findFinishedTodo(userEmail);
    }

    @Override
    public List<Todo> findExpiredTodo(String userEmail) {
        return todoMapper.findExpiredTodo(userEmail);
    }

    @Override
    public List<Todo> findTodoByDate(String userEmail, String date) {
        return todoMapper.findTodoByDate(userEmail, date);
    }

    @Override
    public List<Todo> findTodoByPri(String userEmail, String priorityLevel) {
        return todoMapper.findTodoByPri(userEmail, priorityLevel);
    }

    @Override
    public List<Todo> findExpiredTodoByPri(String userEmail, String priorityLevel) {
        return todoMapper.findExpiredTodoByPri(userEmail, priorityLevel);
    }

    @Override
    public List<Todo> findTodoByInv(String userEmail, String invTitle) {
        return todoMapper.findTodoByInv(userEmail, invTitle);
    }

    @Override
    public List<Todo> findExpiredTodoByInv(String userEmail, String invTitle) {
        return todoMapper.findExpiredTodoByInv(userEmail, invTitle);
    }

    @Override
    public List<Todo> searchTodo(String userEmail, String todoContent) {
        return todoMapper.searchTodo(userEmail, todoContent);
    }

    @Override
    public List<Todo> searchExpiredTodo(String userEmail, String todoContent) {
        return todoMapper.searchExpiredTodo(userEmail, todoContent);
    }

    @Override
    public void addTodo(String userEmail,
                        Date todoCreateTime,
                        String todoContent,
                        Date todoReminderTime,
                        String invTitle,
                        String priorityLevel) {
        todoMapper.addTodo(
                userEmail,
                todoCreateTime,
                todoContent,
                todoReminderTime,
                invTitle,
                priorityLevel
        );
    }

    @Override
    public String modifyTodo(Integer todoNum, Todo todoNewContent) {
        if ( todoMapper.modifyTodo(todoNum, todoNewContent) != 0 ) {
            return "true";
        }
        else {
            return "false";
        }
    }

    @Override
    public String finishTodo(Integer invNum) {
        if ( todoMapper.finishTodo(invNum) != 0 ) {
            return "true";
        }
        else {
            return "false";
        }
    }

    @Override
    public String recoverTodo(Integer invNum) {
        if ( todoMapper.recoverTodo(invNum) != 0 ) {
            return "true";
        }
        else {
            return "false";
        }
    }

    @Override
    public String deleteTodo(Integer todoNum) {
        if ( todoMapper.deleteTodo(todoNum) != 0 ) {
            return "true";
        }
        else {
            return "false";
        }
    }
}
