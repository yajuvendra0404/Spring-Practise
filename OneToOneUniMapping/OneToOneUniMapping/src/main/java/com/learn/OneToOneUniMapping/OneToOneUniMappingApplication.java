package com.learn.OneToOneUniMapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.learn.OneToOneUniMapping.DAO.AppDAOImpl;
import com.learn.OneToOneUniMapping.Entity.Instructor;
import com.learn.OneToOneUniMapping.Entity.InstructorDetails;

@SpringBootApplication
public class OneToOneUniMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneUniMappingApplication.class, args);
	}

	/*
	 * Spring will inject "AppDAOImpl" automatically 
	 * no need to inject or use @Autowired annotation
	*/
	
	@Bean
	public CommandLineRunner commandLineRunner (AppDAOImpl appDAOImpl) {
		return runner -> {
			this.createInstructor(appDAOImpl);
		};
	}
	
	public void createInstructor(AppDAOImpl appDAOImpl) {
	
		/*
		 * "instructor" entity has the FK for "instructordetails"
		 * so when you call instructor's "setInstructorDetails()" method 
		 * data for "instructordetails" will also be saved.
		 * first the data for "instructordetails" will be saved and then
		 * data for "instructor" will be saved
		*/
		
		Instructor instructor = new Instructor("tim","bits","tim@bits.com");

		InstructorDetails instructordetails = new InstructorDetails("www.youtube.com", "dance");
		
		instructor.setInstructorDetails(instructordetails);
		
		appDAOImpl.save(instructor);

	}
}
