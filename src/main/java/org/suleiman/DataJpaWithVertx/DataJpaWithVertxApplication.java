package org.suleiman.DataJpaWithVertx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.suleiman.DataJpaWithVertx.Verticles.WorkstationVerticle;

@SpringBootApplication
//@ComponentScan(basePackages = "org.suleiman.DataJpaWithVertx")
public class DataJpaWithVertxApplication {



	public static void main(String[] args) {

		SpringApplication.run(DataJpaWithVertxApplication.class, args);

	}

}
