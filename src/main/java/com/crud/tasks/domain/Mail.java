package com.crud.tasks.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@AllArgsConstructor       //Zadanie podstawowe
@RequiredArgsConstructor

@Builder
public class Mail {
    private final String mailTo;
    private final String subject;
    private final String message;
    private String toCc;
}