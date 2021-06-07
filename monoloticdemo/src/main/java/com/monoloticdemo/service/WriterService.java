package com.monoloticdemo.service;

import com.monoloticdemo.model.entity.Writer;
import com.monoloticdemo.model.form.RegisterWriterForm;
import com.monoloticdemo.repository.WriterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
/**
 * writer에 대한 CRUD
 */
@RequiredArgsConstructor
public class WriterService {

    private final WriterRepository writerRepository;

    public Long registerWriter(RegisterWriterForm registerWriterForm) {

        return writerRepository.save(
                Writer.builder()
                        .name(registerWriterForm.getName())
                        .createdAt(LocalDateTime.now()).build()
        ).getWriterId();

    }
}
