package com.project.todo.models;

/**
 * Represents one item that should be included in http requests.
 * @author aleksandar.pantovic
 *
 */
public class ItemDetailsModel {
	private String title;
	private int hours;
	private String date;
	
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
