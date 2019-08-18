package ru.alfastrah.api.kubedemo.domain.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AppInfoDTO {

    private final String appVersion;
    private final String hostName;
}
