package br.com.ipsamambaia.cadastromembrosserver.config.app;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("br.com.ipsamambaia.cadastromembrosserver.controller"))
            .paths(PathSelectors.ant("/v1/**"))
            .build()
            .apiInfo(getApiInfo());
    }
    
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Cadastro de Membros",
                "API autenticada para cadastro de membros da Primeira Igreja Presbiteriana de Samambaia",
                "1.0",
                "#",
                new Contact("Ministério de Comunicação 1ªIPS","http://www.ipsamambaia.com.br/","contato@ipsamambaia.com.br"),
                "Licença",
                "#",
                Collections.emptyList()
        );
    }
}
