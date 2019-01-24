package com.stock.mvc.services;

import java.util.List;

import com.stock.mvc.entities.LigneCommandeClient;

public interface ILigneCommandeClientService {
	
	public LigneCommandeClient save(LigneCommandeClient entity);
	
	public LigneCommandeClient update(LigneCommandeClient entity);
	
	public List<LigneCommandeClient> selectAll();
	
	public List<LigneCommandeClient> selectAll(String sortField , String sort);
	
	public LigneCommandeClient getById(Long id);
	
	public void remove(Long id);
	
	public LigneCommandeClient findOne(String parmName , Object paramValue);
	
	public LigneCommandeClient findOne(String[] parmNames , Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);


}
