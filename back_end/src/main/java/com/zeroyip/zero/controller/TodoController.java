package com.zeroyip.zero.controller;

import com.zeroyip.zero.pojo.Todo;
import com.zeroyip.zero.service.TodoService;
import com.zeroyip.zero.util.jwt.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/todo", produces = {"application/json; charset=utf-8"})
public class TodoController {
    @Autowired(required = false)
    private TodoService todoService;

    // 展示未过期的待办事项
    @GetMapping(value = "/find")
    public List<Todo> findTodo(@RequestHeader String token) {
        return todoService.findTodo(JWTUtil.getuserEmail(token));
    }

    // 展示已完成的待办事项
    @GetMapping(value = "/findfinishedtodo")
    public List<Todo> findFinishedTodo(@RequestHeader String token) {
        return todoService.findFinishedTodo(JWTUtil.getuserEmail(token));
    }

    // 展示已过期的待办事项
    @GetMapping(value = "/findexpiredtodo")
    public List<Todo> findExpiredTodo(@RequestHeader String token) {
        return todoService.findExpiredTodo(JWTUtil.getuserEmail(token));
    }

    // 根据日期查询待办事项
    @GetMapping(value = "/findtodobydate/{date}")
    public List<Todo> findTodoByDate(@RequestHeader String token,
                                     @PathVariable("date") String date) {
        return todoService.findTodoByDate(JWTUtil.getuserEmail(token), date);
    }

    // 根据优先级查询待办事项
    @GetMapping(value = "/findtodobypri/{priorityLevel}")
    public List<Todo> findTodoByPri(@RequestHeader String token,
                                    @PathVariable("priorityLevel") String priorityLevel) {
        return todoService.findTodoByPri(JWTUtil.getuserEmail(token), priorityLevel);
    }

    // 根据优先级查询待办事项(过期的)
    @GetMapping(value = "/findexpiredtodobypri/{priorityLevel}")
    public List<Todo> findExpiredTodoByPri(@RequestHeader String token,
                                    @PathVariable("priorityLevel") String priorityLevel) {
        return todoService.findExpiredTodoByPri(JWTUtil.getuserEmail(token), priorityLevel);
    }

    // 根据清单查询待办事项
    @PostMapping(value = "/findtodobyinv")
    public List<Todo> findTodoByInv(@RequestHeader String token,
                                    @RequestBody @Valid Todo todo) {
        return todoService.findTodoByInv(JWTUtil.getuserEmail(token), todo.getInvTitle());
    }

    // 根据清单查询待办事项(过期的)
    @PostMapping(value = "/findexpiredtodobyinv")
    public List<Todo> findExpiredTodoByInv(@RequestHeader String token,
                                           @RequestBody @Valid Todo todo) {
        return todoService.findExpiredTodoByInv(JWTUtil.getuserEmail(token), todo.getInvTitle());
    }

    // 关键字查询
    @PostMapping(value = "/searchtodo")
    public List<Todo> searchTodo(@RequestHeader String token,
                                 @RequestBody @Valid Todo todo) {
        return todoService.searchTodo(JWTUtil.getuserEmail(token), todo.getTodoContent());
    }

    // 关键字查询(过期的)
    @PostMapping(value = "/searchexpiredtodo")
    public List<Todo> searchExpiredTodo(@RequestHeader String token,
                                        @RequestBody @Valid Todo todo) {
        return todoService.searchExpiredTodo(JWTUtil.getuserEmail(token), todo.getTodoContent());
    }

    // 添加待办事项
    @PostMapping(value = "/add", consumes = "application/json")
    public void addTodo(@RequestHeader String token,
                        @RequestBody @Valid Todo todo) {
        todoService.addTodo(
                JWTUtil.getuserEmail(token),
                todo.getTodoCreateTime(),
                todo.getTodoContent(),
                todo.getTodoReminderTime(),
                todo.getInvTitle(),
                todo.getPriorityLevel());
    }

    // 修改/删除待办事项选项
    @PatchMapping(value = "/modify/{invNum}", consumes = "application/json")
    public String modifyTodo(@PathVariable("invNum") Integer invNum,
                             @Valid @RequestBody Todo todo) {
        if ( todoService.modifyTodo(invNum, todo) == "true" ) {
            return "Succeeded";
        }
        else {
            return "Failed";
        }
    }

    // 完成待办事项选项
    @PatchMapping(value = "/finish/{invNum}", consumes = "application/json")
    public String finishTodo(@PathVariable("invNum") Integer invNum) {
        if ( todoService.finishTodo(invNum) == "true" ) {
            return "Succeeded";
        }
        else {
            return "Failed";
        }
    }

    // 恢复已完成的待办事项
    @PatchMapping(value = "/recover/{invNum}", consumes = "application/json")
    public String recoverTodo(@PathVariable("invNum") Integer invNum) {
        if ( todoService.recoverTodo(invNum) == "true" ) {
            return "Succeeded";
        }
        else {
            return "Failed";
        }
    }

    // 删除待办事项
    @DeleteMapping(value = "/delete/{invNum}")
    public String deleteTodo(@PathVariable("invNum") Integer invNum) {
        if ( todoService.deleteTodo(invNum) == "true" ) {
            return "Succeeded";
        }
        else {
            return "Failed";
        }
    }
}
