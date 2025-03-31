package com.ncu.RealTimeVoting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.ncu.RealTimeVoting")
public class RealTimeVotingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealTimeVotingApplication.class, args);
	}

}
