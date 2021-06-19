package edu.escuelaing.edu.picasYFamas.picasYFamas;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class PicasYFamasApplication {

	public static void main(String[] args) {
		int port = getPort();
		SpringApplication app = new SpringApplication(PicasYFamasApplication.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", port));
		app.run(args);
		//SpringApplication.run(PicasYFamasApplication.class, args);
	}
	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 5000; //returns default port if heroku-port isn't set(i.e. on localhost)
	}
}
