package com.project.todo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.project.todo.models.ItemEntity;

/**
 * Repository for storing timesheet items.
 * @author aleksandar.pantovic
 *
 */
@Repository
public interface ItemRepository extends CrudRepository<ItemEntity, Long> {
	ItemEntity findById(long id);
	List<ItemEntity> findAllByDate(String date);
}
