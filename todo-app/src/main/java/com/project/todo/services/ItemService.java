package com.project.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.todo.models.ItemEntity;
import com.project.todo.models.OperationStatusModel;
import com.project.todo.repositories.ItemRepository;

import javassist.NotFoundException;

/**
 * Service that manipulates the timesheet items.
 * @author aleksandar.pantovic
 *
 */
@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;
	
	/**
	 * Inserts item to the database.
	 * @param item
	 * @return
	 */
	public ItemEntity createItem(ItemEntity item) {
		ItemEntity storedDetails = itemRepository.save(item);
		return storedDetails;
	}
	/**
	 * Updates given item in the database.
	 * @param item
	 * @return
	 */
	public ItemEntity updateItem(ItemEntity item) {
		ItemEntity storedDetails = itemRepository.save(item);
		return storedDetails;
	}
	/**
	 * Deletes the given item from the database.
	 * @param id
	 * @return
	 */
	public OperationStatusModel deleteItem(long id) {
		try {
			ItemEntity entity = itemRepository.findById(id);
			if (entity == null) {
				return new OperationStatusModel("Delete","Failed. Requested item was not found.");
			}
			itemRepository.delete(entity);
			
			return new OperationStatusModel("Delete","Success");
		}
		catch (IllegalArgumentException e) {
			System.out.println("ItemEntity was null: " + e);
			return new OperationStatusModel("Delete","Failed");
		}
	}
	
	/**
	 * Returns all the items from the database for the specific date.
	 * @param date
	 * @return
	 */
	public List<ItemEntity> getAllItems(String date) {
		List<ItemEntity> items = itemRepository.findAllByDate(date);
		return items;
	}
}
