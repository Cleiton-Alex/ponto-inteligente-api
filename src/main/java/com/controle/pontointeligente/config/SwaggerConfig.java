package com.controle.pontointeligente.config;
//

import com.controle.pontointeligente.security.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@Profile("dev")
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Qualifier("jwtUserDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;




    @Bean
    public Docket api() {

        String swaggerToken;
        try {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername("admin@cleiton.com");
            swaggerToken = this.jwtTokenUtil.obterToken(userDetails);
        } catch (Exception e) {
            swaggerToken = "";
        }

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.controle.pontointeligente.controllers"))
                .paths(PathSelectors.any()).build()
                .apiInfo(apiInfo())
                .globalOperationParameters(
                        Collections.singletonList(
                                new ParameterBuilder()
                                        .name("Authorization")
                                        .modelRef(new ModelRef("string"))
                                        .parameterType("header")
                                        .required(true)
                                        .hidden(true)
                                        .defaultValue("Bearer " + swaggerToken)
                                        .build()
                        )
                );

    }

    //    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors.basePackage("com.controle.pontointeligente.controllers"))
//                .paths(PathSelectors.any()).build()
//                .apiInfo(apiInfo());
//    }
//
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Ponto Inteligente API")
                .description("Documentação da API de acesso aos endpoints do Ponto Inteligente.").version("1.0")
                .build();
    }
//
//    @Bean
//    public SecurityConfiguration security() {
//        String token;
//        try {
//            UserDetails userDetails = this.userDetailsService.loadUserByUsername("admin@cleiton.com");
//            token = this.jwtTokenUtil.obterToken(userDetails);
//        } catch (Exception e) {
//            token = "";
//        }
//
//        return new SecurityConfiguration(null, null, null, null, "Bearer " + token, ApiKeyVehicle.HEADER,
//                "Authorization", ",");
//    }








}

