package com.stock.mvc.dao;

import java.util.List;

public interface IGenericDao<E> {
	
	// ajout et l'enregistrement 
	public E save(E entity);
	
	//ex: modification 
	public E update(E entity);
	
	//ex: select * from nom_tab 
	public List<E> selectAll();
	
	//ex: select * from nom_tab order by sortField asc or desc
	public List<E> selectAll(String sortField , String sort);
	
	//ex : selecte * from nom_table where id="id_entrer";
	public E getById(Long id);
	
	//ex: delete from nom_table where id="id_entrer";
	public void remove(Long id);
	
	//ex: select * from nom_table where col="val";
	public E findOne(String parmName , Object paramValue);
	
	//ex: select * from nom_table where col1="val1" and col2="val2" and .....;
	public E findOne(String[] parmNames , Object[] paramValues);
	
	//bhal findone
	public int findCountBy(String paramName, String paramValue);


}
