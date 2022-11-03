package com.schoolproject.shoepingmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

/**
 * buy를 할 때 돈을 count만큼 곱해서 계산하는거
 */
@SpringBootApplication
public class ShoepingmallApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoepingmallApplication.class, args);
	}

//	@Bean
//	public PageableHandlerMethodArgumentResolverCustomizer customzie() {
//		return p -> {
//			p.setOneIndexedParameters(true); // page 1부터 시작하게 한다.
//			p.setMaxPageSize(10); // page의 사이즈를 10으로 저장
//		}
//	}


}
