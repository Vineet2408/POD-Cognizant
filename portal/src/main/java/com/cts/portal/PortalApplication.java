package com.cts.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class PortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalApplication.class, args);

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("special.xml");

		SpecialistDetail country = (SpecialistDetail) context.getBean("de", SpecialistDetail.class);
		GetSpecialist gs=new GetSpecialist();
		
		SpecialistDetail sd=gs.get();
		
		System.out.println(sd.toString());
	}

}
