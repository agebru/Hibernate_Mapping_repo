package com.spring.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
	@Bean
	public Docket api() {
		// adding header
		ParameterBuilder authorizationBuilder = new ParameterBuilder();
		authorizationBuilder.name("Authorization").modelRef(new ModelRef("String")).parameterType("header")
				.required(false).build();

		ParameterBuilder channelBuilder = new ParameterBuilder();
		channelBuilder.name("ChannelId").modelRef(new ModelRef("String")).parameterType("header").required(false)
				.build();

		ParameterBuilder tokenBuilder = new ParameterBuilder();
		tokenBuilder.name("SC_TOKEN").modelRef(new ModelRef("String")).parameterType("header").required(false).build();

		ParameterBuilder traceBuilder = new ParameterBuilder();
		channelBuilder.name("TraceID").modelRef(new ModelRef("String")).parameterType("header").required(false).build();

		List<Parameter> aParameters = new ArrayList<>();
		aParameters.add(authorizationBuilder.build());
		aParameters.add(channelBuilder.build());
		aParameters.add(tokenBuilder.build());
		aParameters.add(traceBuilder.build());

		return new Docket(DocumentationType.SWAGGER_2).select()
				// .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.apis(RequestHandlerSelectors.basePackage("com.spring.controller")).build();
				//.apiInfo(getApiInfo())
				//.pathMapping("").globalOperationParameters(aParameters);

	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("SwaggerApiTitle").description("SwaggerApiDescription").version("v1.0")
				.license("Swager API License: Internal Use only. Emmanuel Gebru").licenseUrl("").build();
	}

}
