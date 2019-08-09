package com.scott.processor.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
public class MessageService {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${processor.api.scheme}")
    private String scheme;

    @Value("${processor.api.host}")
    private String host;

    @Value("${processor.api.port}")
    private String port;

    @Value("${processor.api.messages-endpoint}")
    private String messagesEndpoint;


    public void sendMessageToApi(String message) {

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host)
                .port(port)
                .pathSegment(messagesEndpoint)
                .build();

        ResponseEntity response = restTemplate.postForEntity(
                uriComponents.toUriString(),
                message,
                String.class
        );

        log.info("{}", response);
    }
}
