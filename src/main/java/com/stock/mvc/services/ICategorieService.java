package com.stock.mvc.services;

import java.util.List;

import com.stock.mvc.entities.Category;

public interface ICategorieService {
	
	
public Category save(Category entity);

public Category update(Category entity);

public List<Category> selectAll();

public List<Category> selectAll(String sortField , String sort);

public Category getById(Long id);

public void remove(Long id);

public Category findOne(String parmName , Object paramValue);

public Category findOne(String[] parmNames , Object[] paramValues);

public int findCountBy(String paramName, String paramValue);

}
