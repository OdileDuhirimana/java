package com.rra.vehicletracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Vehicle Tracking Management System API",
        version = "1.0",
        description = "API documentation for RRA Vehicle Tracking Management System"
    )
)
public class VehicleTrackingApplication {
    public static void main(String[] args) {
        SpringApplication.run(VehicleTrackingApplication.class, args);
    }
} 