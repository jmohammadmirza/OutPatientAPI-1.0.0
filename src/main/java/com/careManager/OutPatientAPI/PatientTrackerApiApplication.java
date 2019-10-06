package com.careManager.OutPatientAPI;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientTrackerApiApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientTrackerApiApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(PatientTrackerApiApplication.class, args);
	}
	
    @PostConstruct
    public void startupApplication() {
        // log startup
		 LOGGER.info("  ____    _    _   _______   _____               _______   _____   ______   _   _   _______                _____    _____ \n" + 
		 		"  / __ \\  | |  | | |__   __| |  __ \\      /\\     |__   __| |_   _| |  ____| | \\ | | |__   __|       /\\     |  __ \\  |_   _|\n" + 
		 		" | |  | | | |  | |    | |    | |__) |    /  \\       | |      | |   | |__    |  \\| |    | |         /  \\    | |__) |   | |  \n" + 
		 		" | |  | | | |  | |    | |    |  ___/    / /\\ \\      | |      | |   |  __|   | . ` |    | |        / /\\ \\   |  ___/    | |  \n" + 
		 		" | |__| | | |__| |    | |    | |       / ____ \\     | |     _| |_  | |____  | |\\  |    | |       / ____ \\  | |       _| |_ \n" + 
		 		"  \\____/   \\____/     |_|    |_|      /_/    \\_\\    |_|    |_____| |______| |_| \\_|    |_|      /_/    \\_\\ |_|      |_____|"); 
		 
    }
}
