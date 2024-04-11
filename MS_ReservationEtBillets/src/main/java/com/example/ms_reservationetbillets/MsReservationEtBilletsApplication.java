package com.example.ms_reservationetbillets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class MsReservationEtBilletsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsReservationEtBilletsApplication.class, args);
	}

}
