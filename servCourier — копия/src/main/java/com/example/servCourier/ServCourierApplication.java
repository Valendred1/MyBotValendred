package com.example.servCourier;

import com.example.servCourier.Bot.BotThread;
import com.example.servCourier.Bot.MyBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServCourierApplication {

	public static void main(String[] args) {


		BotThread botThread = new BotThread();
		botThread.start();

		SpringApplication.run(ServCourierApplication.class, args);
	}

}
