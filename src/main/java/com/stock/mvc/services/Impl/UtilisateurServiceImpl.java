package com.stock.mvc.services.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.dao.IUtilisateurDao;
import com.stock.mvc.entities.Utilisateur;
import com.stock.mvc.services.IUtilisateurService;
@Transactional
public class UtilisateurServiceImpl  implements IUtilisateurService{

	private IUtilisateurDao dao;
	
	
	
	public void setDao(IUtilisateurDao dao) {
		this.dao = dao;
	}

	@Override
	public Utilisateur save(Utilisateur entity) {
		return dao.save(entity);
	}

	@Override
	public Utilisateur update(Utilisateur entity) {
		return dao.update(entity);
	}

	@Override
	public List<Utilisateur> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Utilisateur> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Utilisateur getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Utilisateur findOne(String parmName, Object paramValue) {
		return dao.findOne(parmName, paramValue);
	}

	@Override
	public Utilisateur findOne(String[] parmNames, Object[] paramValues) {
		return dao.findOne(parmNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
