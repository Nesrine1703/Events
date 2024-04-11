package com.example.ms_commentairesetevaluations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsCommentairesEtEvaluationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCommentairesEtEvaluationsApplication.class, args);
    }

}
