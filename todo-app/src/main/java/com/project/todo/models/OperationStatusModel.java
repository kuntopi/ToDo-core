package com.project.todo.models;

/**
 * Represents a model that is sent in http response to represent the status of requested operation.
 * @author aleksandar.pantovic
 *
 */
public class OperationStatusModel {
	private String operationName;
	private String operationStatus;	
	
	public OperationStatusModel(String name, String status) {
		operationName = name;
		operationStatus = status;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getOperationStatus() {
		return operationStatus;
	}

	public void setOperationStatus(String operationStatus) {
		this.operationStatus = operationStatus;
	}
	
}
