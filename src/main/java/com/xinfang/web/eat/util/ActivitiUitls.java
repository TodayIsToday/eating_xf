package com.xinfang.web.eat.util;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;

import oracle.net.aso.p;

/**
 * activiti 学习类
 * @author hk
 *
 */
public class ActivitiUitls {
	public static void main(String[] args) {
		// Create activiti process engine
		ProcessEngine processEngine = ProcessEngineConfiguration
				.createStandaloneProcessEngineConfiguration()
				.buildProcessEngine();
		
		// Get activiti service
		RepositoryService repositoryService = processEngine.getRepositoryService();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		
		// Deploy the process definition
		repositoryService.createDeployment().addClasspathResource("config/activiti/test/VacationRequest.bpmn20.xml").deploy();
		
		// Start a prcess instance
		//runtimeService.startProcessInstanceByKey("process");
		
	}
}
