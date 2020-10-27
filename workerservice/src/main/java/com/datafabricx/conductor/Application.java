package com.datafabricx.conductor;

import com.tuplescale.conductor.client.WorkflowSmartClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.io.IOException;

@ComponentScan({"com.datafabricx","com.tuplescale.conductor"})
@SpringBootApplication
public class Application {

	@Autowired
	private WorkflowSmartClientImpl workflowSmartClientImpl;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void  registerWorkflow() throws IOException {
		workflowSmartClientImpl.registerWorflowWithTasksFromConfiguredPath(true);
	}
}
