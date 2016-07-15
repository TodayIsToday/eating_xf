package com.xinfang.web.eat.modules.workFlow.service.imp;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinfang.web.eat.modules.workFlow.service.WorkFlowService;

public class WorkFlowServiceImpl implements WorkFlowService {

	@Autowired
	private ProcessEngine processEngine;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private ManagementService managementService;
	@Autowired
	private FormService formService;

	
	@Override
	public void deploymentLocalProcess(String processName) {
		processEngine.getRepositoryService().createDeployment()
			.addClasspathResource("config/activiti/test/VacationRequest.bpmn20.xml")
			.deploy();

	}

}
