package com.project.todo.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.todo.models.GetItemsResponseModel;
import com.project.todo.models.ItemDetailsModel;
import com.project.todo.models.ItemEntity;
import com.project.todo.models.OperationStatusModel;
import com.project.todo.services.ItemService;

@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	/**
	 * Gets all items and maximum hours for the specified date.
	 * @param date
	 * @return
	 */
	@GetMapping(path="/{date}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public GetItemsResponseModel getItems(@PathVariable String date) {
		List<ItemEntity> items = itemService.getAllItems(date);
		
		GetItemsResponseModel response = new GetItemsResponseModel(items);
		
		return response;
	}
	
	/**
	 * Creates a new item given in the request body.
	 * @param itemDetails
	 * @return
	 */
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ItemEntity createUser(@RequestBody ItemDetailsModel itemDetails) {		
		ItemEntity itemEntity = new ItemEntity();
		BeanUtils.copyProperties(itemDetails, itemEntity);
		
		ItemEntity createdItem = itemService.createItem(itemEntity);
		//BeanUtils.copyProperties(createdItem, returnValue);
		return createdItem;		
	}
	
	/**
	 * Updates information of the selected item.
	 * @param item
	 * @return
	 */
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ItemEntity updateItem(@RequestBody ItemEntity item) {
		ItemEntity updatedItem = itemService.updateItem(item);
		
		return updatedItem;
	}

	/**
	 * Deletes the given item.
	 * @param item
	 * @return
	 */
	@DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public OperationStatusModel deleteItem(@RequestBody ItemEntity item) {
		OperationStatusModel operationStatus = itemService.deleteItem(item.getId());
		return operationStatus;
	}
}
