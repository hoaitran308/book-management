package com.nogroup.bookui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BookuiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookuiApplication.class, args);
	}

}
