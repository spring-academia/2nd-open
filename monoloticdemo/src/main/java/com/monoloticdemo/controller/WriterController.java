package com.monoloticdemo.controller;

import com.monoloticdemo.model.form.RegisterWebBookChapterForm;
import com.monoloticdemo.model.form.RegisterWebBookForm;
import com.monoloticdemo.model.form.RegisterWriterForm;
import com.monoloticdemo.service.WriterService;
import com.monoloticdemo.service.WriterWebBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/writer")
@RequiredArgsConstructor
public class WriterController {

    private final WriterService writerService;
    private final WriterWebBookService writerWebBookService;

    @PostMapping("/")
    public ResponseEntity<Long> registerWriter(@RequestBody RegisterWriterForm registerWriterForm) {
        return ResponseEntity.ok(writerService.registerWriter(registerWriterForm));
    }

    @PostMapping("/{writerId}/webBook")
    public ResponseEntity<Long> registerWebBook(
            @PathVariable(value = "writerId") Long writerId,
            @RequestBody RegisterWebBookForm registerWebBookForm) {
        return ResponseEntity.ok(writerWebBookService.registerWebBook(writerId, registerWebBookForm));
    }

    @PostMapping("/{writerId}/webBook/{webBookId}")
    public ResponseEntity<Long> registerWebBook(
            @PathVariable(value = "writerId") Long writerId,
            @PathVariable(value = "webBookId") Long webBookId,
            @RequestBody RegisterWebBookChapterForm registerWebBookChapterForm) {
        return ResponseEntity.ok(writerWebBookService.registerWebBookChapter(writerId, webBookId, registerWebBookChapterForm));
    }

}
