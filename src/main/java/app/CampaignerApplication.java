package app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CampaignerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CampaignerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Application is running!");

    }
}
