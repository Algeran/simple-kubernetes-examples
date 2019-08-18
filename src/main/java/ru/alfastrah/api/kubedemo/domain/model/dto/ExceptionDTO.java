package ru.alfastrah.api.kubedemo.domain.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ExceptionDTO {

    private final String exceptionMessage;
}
