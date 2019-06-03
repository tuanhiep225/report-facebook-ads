package mmo.facebook.ads.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import mmo.facebook.ads.report.config.AppProperties;


@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class ReportApplication {

	public static void main(String[] args) {
		 System.setProperty("spring.devtools.restart.enabled", "true");
		SpringApplication.run(ReportApplication.class, args);
	}
	

}
