package com.project.todo.models;

import java.util.List;

public class GetItemsResponseModel {
	List<ItemEntity> items;
	
	public GetItemsResponseModel (List<ItemEntity> items) {
		this.items = items;
	}
	
	public List<ItemEntity> getItems() {
		return items;
	}
	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}
}
