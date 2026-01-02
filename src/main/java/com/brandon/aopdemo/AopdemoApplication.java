package com.brandon.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.brandon.aopdemo.dao.AccountDAO;
import com.brandon.aopdemo.dao.SecondDAO;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, SecondDAO secondDAO) {
		return args -> {
			demoTheBeforeAdvice(accountDAO, secondDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, SecondDAO secondDAO) {
		System.out.println("\nMain Program: demoTheBeforeAdvice");
		accountDAO.addAccount();
		accountDAO.addAccounting("wew");
		secondDAO.addAccount();
		accountDAO.setName("Brandon");
		System.out.println(accountDAO.getName());
	}

}
