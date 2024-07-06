package com.configuration.CloudConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudConfigurationApplication {

	public static void main(String[] args) {

		SpringApplication.run(CloudConfigurationApplication.class, args);
	}
}

