package com.zeroyip.zero.controller;

import com.zeroyip.zero.pojo.Memorandum;
import com.zeroyip.zero.service.MemorandumService;
import com.zeroyip.zero.util.jwt.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/memorandum", produces = {"application/json; charset=utf-8"})
public class MemorandumController {
    @Autowired(required = false)
    private MemorandumService memorandumService;

    // 展示备忘录
    @GetMapping(value = "/find")
    public List<Memorandum> findMemorandum(@RequestHeader String token) {
        return memorandumService.findMemorandum(JWTUtil.getuserEmail(token));
    }

    // 添加备忘录
    @PostMapping(value = "/add", consumes = "application/json")
    public void addMemorandum(@RequestHeader String token,
                              @RequestBody @Valid Memorandum memorandum) {
        memorandumService.addMemorandum(JWTUtil.getuserEmail(token), memorandum);
    }

    // 修改待办事项选项
    @PatchMapping(value = "{/modify", consumes = "application/json")
    public String patchMemorandum(@Valid @RequestBody Memorandum content) {
        if ( memorandumService.patchMemorandum(content.getMemNum(), content) == "true" ) {
            return "Succeeded";
        }
        else {
            return "Failed";
        }
    }

    // 删除待办事项
    @DeleteMapping(value = "/delete")
    public String deleteMemorandum(@Valid @RequestBody Memorandum content) {
        if ( memorandumService.deleteMemorandum(content.getMemNum()) == "true" ) {
            return "Succeeded";
        }
        else {
            return "Failed";
        }
    }
}
