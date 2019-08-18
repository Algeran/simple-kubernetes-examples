package ru.alfastrah.api.kubedemo.application.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alfastrah.api.kubedemo.domain.model.dto.AppInfoDTO;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class DemoController {

    @GetMapping("/info")
    public AppInfoDTO getAppInfo() throws UnknownHostException {
        return new AppInfoDTO("version 1", InetAddress.getLocalHost().getHostName());
    }
}
