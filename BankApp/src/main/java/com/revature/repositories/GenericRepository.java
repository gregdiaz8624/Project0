package com.revature.repositories;

import java.util.List;

public interface GenericRepository<T> {
	
	// These will be the methods that align with CRUD operations (how we interact with the database)
	
	// CREATE
	public T add(T t);
	
	// READ
	public T getById(Integer id);
	
	public List<T> getAll();
	
	// UPDATE
	public void update(T t);
	
	// DELETE
	public void delete(T t);
}
