package com.stock.mvc.dao.impl;

import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.loader.criteria.CriteriaQueryTranslator;

import com.stock.mvc.dao.IGenericDao;


@SuppressWarnings("unchecked")
public class GenericDaoImpl <E> implements IGenericDao<E> {

	@PersistenceContext
	EntityManager em;
	
	private Class<E> type;
	
	 
	


	public GenericDaoImpl() {
		 
		 Type t = getClass().getGenericSuperclass();
		 ParameterizedType pt= (ParameterizedType) t;
		 type =(Class<E>)pt.getActualTypeArguments()[0];
		 
			}
	
	public Class<E> getType() {
		return type;
	}

	
	
	
	@Override
	public E save(E entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public E update(E entity) {
		
		return em.merge(entity);
	}

	@Override
	public List<E> selectAll() {
		Query query =em.createQuery("select t from "+ type.getSimpleName() + " t"); 
		return query.getResultList();
	}

	@Override
	public List<E> selectAll(String sortField, String sort) {
		Query query =em.createQuery("select t from "+ type.getSimpleName() + " t order by " +sortField+ " "+ sort); 
		return query.getResultList();		
	}

	@Override
	public E getById(Long id) {
		
		return em.find(type, id);
	}

	@Override
	public void remove(Long id) {
		E tab = em.getReference(type, id);
		em.remove(tab);
	}

	@Override
	public E findOne(String parmName, Object paramValue) {
		
		Query query = em.createQuery(" select t from" + type.getSimpleName() + " t where " + parmName + "= :x");
		query.setParameter(parmName, paramValue);
		return query.getResultList().size()>0 ? (E) query.getResultList().get(0):null;		

	}
	
	@Override
	public E findOne(String[] parmNames, Object[] paramValues) {
		if(parmNames.length !=paramValues.length ) {
			
			return null;
		}
		 String queryString ="select e from"+ type.getSimpleName() + " e where"  ;
		 int len =parmNames.length;
		 for(int i=0;i<len;i++) {
			 queryString+="e."+parmNames[i]+"=:i"+i;
			 if((i+1)<len ) { 
				 queryString+="and"; 
			 }
		 }
		 Query query =em.createNamedQuery(queryString);
		 for(int i=0; i<paramValues.length ;i++) {
			 
			 query.setParameter("x"+i, paramValues[i]);
		 }
			return query.getResultList().size()>0 ? (E) query.getResultList().get(0):null;		
		 
	}


	@Override
	public int findCountBy(String paramName, String paramValue) {
		Query query = em.createQuery("select t from" + type.getSimpleName() + " t where " + paramName + "= :x");
		query.setParameter(paramName, paramValue);
		return query.getResultList().size()>0 ? ((Long) query.getSingleResult()).intValue() :0;
	}
	
	
	

}
