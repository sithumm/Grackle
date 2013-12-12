/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.persistencemanager.controller;

import com.framework.persistencemanager.exceptions.NonexistentEntityException;
import com.framework.persistencemanager.exceptions.PreexistingEntityException;
import com.framework.persistencemanager.exceptions.RollbackFailureException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sithum
 */
public interface PersistenceController {

	public void create(java.lang.Object entity, java.lang.Class type) throws PreexistingEntityException, RollbackFailureException,  java.lang.Exception;

	public void batchCreate(List<Object> entityList, Class type, String query, boolean isNamedQuery, Map<String, Object> params) throws PreexistingEntityException, RollbackFailureException,  java.lang.Exception;

	public void edit(java.lang.Object entity) throws NonexistentEntityException, RollbackFailureException,  java.lang.Exception;

	public void batchEdit(List<Object> entityList, Class type, String query, boolean isNamedQuery, Map<String, Object> params) throws NonexistentEntityException, RollbackFailureException, java.lang.Exception;

	public void destroy(java.lang.Integer id, java.lang.Class type) throws NonexistentEntityException, RollbackFailureException, java.lang.Exception;
	
	public void destroy(Object entity, java.lang.Class type) throws NonexistentEntityException, RollbackFailureException, java.lang.Exception;

	public void batchDestroy(List<Object> entityList) throws NonexistentEntityException, RollbackFailureException, java.lang.Exception;
	
	public void batchDestroy(String query, boolean isNamedQuery, Map<String, Object> params) throws NonexistentEntityException, RollbackFailureException, Exception;

	public java.util.List<java.lang.Object> findEntities(java.lang.Class type);

	public java.util.List<java.lang.Object> findEntities(int maxResults, int firstResult, java.lang.Class type);

	public java.lang.Object findEntity(java.lang.Integer id, java.lang.Class type);

	public int getEntityCount(Class type);

	public java.util.List<java.lang.Object> findEntities(java.lang.String query, boolean isNamedQuery, java.util.Map<java.lang.String, java.lang.Object> params);
}
