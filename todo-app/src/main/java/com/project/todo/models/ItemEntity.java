package com.project.todo.models;

import javax.persistence.*;

/**
 * Represents one timesheet item which should be used in the database.
 * @author aleksandar.pantovic
 *
 */
@Entity(name="items")
public class ItemEntity {
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String title;
	@Column(nullable=false)
	private int hours;
	@Column(nullable=false)
	private String date;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
