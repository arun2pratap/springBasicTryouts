package com.spring.basics.springBasicsTryout.pojo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;

import java.io.File;

//import org.springframework.integration.dsl.file.Files;

@Configuration
public class SpringIntegrationFlow {
    @Bean
    IntegrationFlow incomingFile(@Value("${HOME}/Desktop/in") File file){
//        return IntegrationFlows.from(Files.inb);
        return null;
    }
}
