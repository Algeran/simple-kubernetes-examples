package ru.alfastrah.api.kubedemo.application.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.alfastrah.api.kubedemo.domain.model.dto.AppInfoDTO;

@RestController
public class DemoController {

    @GetMapping("/info")
    public AppInfoDTO getAppInfo() {
        final RestTemplate restTemplate = new RestTemplate();
        final AppInfoDTO appInfoFromV1 = restTemplate.getForObject("http://demo-kube-service-v1:8083/info", AppInfoDTO.class);
        return new AppInfoDTO("version 3", appInfoFromV1 != null ? appInfoFromV1.toString() : null);
    }
}
