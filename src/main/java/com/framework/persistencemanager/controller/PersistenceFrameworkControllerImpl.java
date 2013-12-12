/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.persistencemanager.controller;

import com.framework.persistence.requestresponse.PersistenceRequest;
import com.framework.persistence.requestresponse.PersistenceResponse;
import com.framework.persistencemanager.exceptions.NonexistentEntityException;
import com.framework.persistencemanager.exceptions.PreexistingEntityException;
import com.framework.persistencemanager.exceptions.RollbackFailureException;
import com.framework.requestresponsemodel.FingeraRequest;
import com.framework.requestresponsemodel.FingeraResponse;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sithum
 */
public class PersistenceFrameworkControllerImpl implements PersistenceFrameworkController {

	private PersistenceController persistenceControllerLocal;

	@Override
	public FingeraResponse create(FingeraRequest request) {
		PersistenceRequest persistenceRequest = (PersistenceRequest) request;
		PersistenceResponse persistenceResponse = new PersistenceResponse();
		try {
			persistenceControllerLocal.create(persistenceRequest.getParameter(PersistenceRequest.DATA),
					(Class) persistenceRequest.getParameter(PersistenceRequest.PERSISTENCE_TYPE));
			persistenceResponse.setStatus(FingeraResponse.SUCCESS);
		} catch (PreexistingEntityException ex) {
			persistenceResponse.setStatus(FingeraResponse.FAILURE);
			persistenceResponse.setErrorResponse(ex);
			Logger.getLogger(PersistenceFrameworkControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (RollbackFailureException ex) {
			persistenceResponse.setStatus(FingeraResponse.FAILURE);
			persistenceResponse.setErrorResponse(ex);
			Logger.getLogger(PersistenceFrameworkControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception ex) {
			persistenceResponse.setStatus(FingeraResponse.FAILURE);
			persistenceResponse.setErrorResponse(ex);
			Logger.getLogger(PersistenceFrameworkControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			persistenceRequest = null;
		}
		return persistenceResponse;
	}

	@Override
	public FingeraResponse batchCreate(FingeraRequest request) {
		PersistenceRequest persistenceRequest = (PersistenceRequest) request;
		PersistenceResponse persistenceResponse = new PersistenceResponse();
		try {
			boolean isNamedQuery = true;
			String query = "";
			if (persistenceRequest.getParameter(PersistenceRequest.QUERY_NAME) != null) {
				query = persistenceRequest.getParameter(PersistenceRequest.QUERY_NAME).toString();
			} else if (persistenceRequest.getParameter(PersistenceRequest.QUERY) != null) {
				query = persistenceRequest.getParameter(PersistenceRequest.QUERY).toString();
				isNamedQuery = false;
			}
			persistenceControllerLocal.batchCreate((List<Object>) persistenceRequest.getParameter(PersistenceRequest.DATA),
					(Class) persistenceRequest.getParameter(PersistenceRequest.PERSISTENCE_TYPE),
					query, isNamedQuery, (Map<String, Object>) persistenceRequest.getParameter(PersistenceRequest.QUERY_PARAMETERS));
			persistenceResponse.setStatus(FingeraResponse.SUCCESS);
		} catch (PreexistingEntityException ex) {
			persistenceResponse.setStatus(FingeraResponse.FAILURE);
			persistenceResponse.setErrorResponse(ex);
			Logger.getLogger(PersistenceFrameworkControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (RollbackFailureException ex) {
			persistenceResponse.setStatus(FingeraResponse.FAILURE);
			persistenceResponse.setErrorResponse(ex);
			Logger.getLogger(PersistenceFrameworkControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception ex) {
			persistenceResponse.setStatus(FingeraResponse.FAILURE);
			persistenceResponse.setErrorResponse(ex);
			Logger.getLogger(PersistenceFrameworkControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			persistenceRequest = null;
		}
		return persistenceResponse;
	}

	@Override
	public FingeraResponse edit(FingeraRequest request) {
		PersistenceRequest persistenceRequest = (PersistenceRequest) request;
		PersistenceResponse persistenceResponse = new PersistenceResponse();
		try {
			persistenceControllerLocal.edit(persistenceRequest.getParameter(PersistenceRequest.DATA));
			persistenceResponse.setStatus(FingeraResponse.SUCCESS);
		} catch (PreexistingEntityException ex) {
			persistenceResponse.setStatus(FingeraResponse.FAILURE);
			persistenceResponse.setErrorResponse(ex);
			Logger.getLogger(PersistenceFrameworkControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (RollbackFailureException ex) {
			persistenceResponse.setStatus(FingeraResponse.FAILURE);
			persistenceResponse.setErrorResponse(ex);
			Logger.getLogger(PersistenceFrameworkControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception ex) {
			persistenceResponse.setStatus(FingeraResponse.FAILURE);
			persistenceResponse.setErrorResponse(ex);
			Logger.getLogger(PersistenceFrameworkControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			persistenceRequest = null;
		}
		return persistenceResponse;
	}

	@Override
	public FingeraResponse batchEdit(FingeraRequest request) {
		PersistenceRequest persistenceRequest = (PersistenceRequest) request;
		PersistenceResponse persistenceResponse = new PersistenceResponse();
		try {
			boolean isNamedQuery = true;
			String query = "";
			if (persistenceRequest.getParameter(PersistenceRequest.QUERY_NAME) != null) {
				query = persistenceRequest.getParameter(PersistenceRequest.QUERY_NAME).toString();
			} else if (persistenceRequest.getParameter(PersistenceRequest.QUERY) != null) {
				query = persistenceRequest.getParameter(PersistenceRequest.QUERY).toString();
				isNamedQuery = false;
			}
			persistenceControllerLocal.batchEdit((List<Object>) persistenceRequest.getParameter(PersistenceRequest.DATA),
					(Class) persistenceRequest.getParameter(PersistenceRequest.PERSISTENCE_TYPE),
					query, isNamedQuery, (Map<String, Object>) persistenceRequest.getParameter(PersistenceRequest.QUERY_PARAMETERS));
			persistenceResponse.setStatus(FingeraResponse.SUCCESS);
		} catch (PreexistingEntityException ex) {
			persistenceResponse.setStatus(FingeraResponse.FAILURE);
			persistenceResponse.setErrorResponse(ex);
			Logger.getLogger(PersistenceFrameworkControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (RollbackFailureException ex) {
			persistenceResponse.setStatus(FingeraResponse.FAILURE);
			persistenceResponse.setErrorResponse(ex);
			Logger.getLogger(PersistenceFrameworkControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception ex) {
			persistenceResponse.setStatus(FingeraResponse.FAILURE);
			persistenceResponse.setErrorResponse(ex);
			Logger.getLogger(PersistenceFrameworkControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			persistenceRequest = null;
		}
		return persistenceResponse;
	}

	@Override
	public FingeraResponse destroy(FingeraRequest request) {
		PersistenceRequest persistenceRequest = (PersistenceRequest) request;
		PersistenceResponse persistenceResponse = new PersistenceResponse();
		try {
			Integer id = 0;
			Object data = persistenceRequest.getParameter(PersistenceRequest.DATA);
			if (data instanceof Integer) {
				id = (Integer) data;
				persistenceControllerLocal.destroy(id, (Class) persistenceRequest.getParameter(PersistenceRequest.PERSISTENCE_TYPE));
			} else {
				persistenceControllerLocal.destroy(data, (Class) persistenceRequest.getParameter(PersistenceRequest.PERSISTENCE_TYPE));
			}
			persistenceResponse.setStatus(PersistenceResponse.SUCCESS);
		} catch (NonexistentEntityException ex) {
			persistenceResponse.setStatus(FingeraResponse.FAILURE);
			persistenceResponse.setErrorResponse(ex);
			Logger.getLogger(PersistenceFrameworkControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (RollbackFailureException ex) {
			persistenceResponse.setStatus(FingeraResponse.FAILURE);
			persistenceResponse.setErrorResponse(ex);
			Logger.getLogger(PersistenceFrameworkControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception ex) {
			persistenceResponse.setStatus(FingeraResponse.FAILURE);
			persistenceResponse.setErrorResponse(ex);
			Logger.getLogger(PersistenceFrameworkControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			persistenceRequest = null;
		}
		return persistenceResponse;
	}

	@Override
	public FingeraResponse batchDestroy(FingeraRequest request) {
		PersistenceRequest persistenceRequest = (PersistenceRequest) request;
		PersistenceResponse persistenceResponse = new PersistenceResponse();
		try {
			Object query = null;
			boolean isNamedQuery = true;
			if (persistenceRequest.getParameter(PersistenceRequest.QUERY_NAME) != null) {
				query = persistenceRequest.getParameter(PersistenceRequest.QUERY_NAME);
			} else if (persistenceRequest.getParameter(PersistenceRequest.QUERY) != null) {
				query = persistenceRequest.getParameter(PersistenceRequest.QUERY);
				isNamedQuery = false;
			}
			if (query != null) {
				persistenceControllerLocal.batchDestroy(query.toString(), isNamedQuery,
						(Map<String, Object>) persistenceRequest.getParameter(PersistenceRequest.QUERY_PARAMETERS));
			} else {
				persistenceControllerLocal.batchDestroy((List<Object>) persistenceRequest.getParameter(PersistenceRequest.DATA));
			}
			persistenceResponse.setStatus(PersistenceResponse.SUCCESS);
		} catch (NonexistentEntityException ex) {
			persistenceResponse.setStatus(FingeraResponse.FAILURE);
			persistenceResponse.setErrorResponse(ex);
			Logger.getLogger(PersistenceFrameworkControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (RollbackFailureException ex) {
			persistenceResponse.setStatus(FingeraResponse.FAILURE);
			persistenceResponse.setErrorResponse(ex);
			Logger.getLogger(PersistenceFrameworkControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception ex) {
			persistenceResponse.setStatus(FingeraResponse.FAILURE);
			persistenceResponse.setErrorResponse(ex);
			Logger.getLogger(PersistenceFrameworkControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			persistenceRequest = null;
		}
		return persistenceResponse;
	}

	@Override
	public FingeraResponse findEntities(FingeraRequest request) {
		PersistenceRequest persistenceRequest = (PersistenceRequest) request;
		PersistenceResponse persistenceResponse = new PersistenceResponse();
		try {
			String query = "";
			Object data = null;
			if (persistenceRequest.getParameter(PersistenceRequest.QUERY_NAME) != null) {
				query = persistenceRequest.getParameter(PersistenceRequest.QUERY_NAME).toString();
				data = persistenceControllerLocal.findEntities(query, true, (Map<String, Object>) persistenceRequest.getParameter(PersistenceRequest.QUERY_PARAMETERS));
			} else if (persistenceRequest.getParameter(PersistenceRequest.QUERY) != null) {
				query = persistenceRequest.getParameter(PersistenceRequest.QUERY).toString();
				data = persistenceControllerLocal.findEntities(query, false, (Map<String, Object>) persistenceRequest.getParameter(PersistenceRequest.QUERY_PARAMETERS));
			} else if (persistenceRequest.getParameter(PersistenceRequest.PERSISTENCE_TYPE) != null) {
				Class type = (Class) persistenceRequest.getParameter(PersistenceRequest.PERSISTENCE_TYPE);
				if (persistenceRequest.getParameter(PersistenceRequest.MAX_RESULTS) != null) {
					Integer maxResults = (Integer) persistenceRequest.getParameter(PersistenceRequest.MAX_RESULTS);
					Object fr = persistenceRequest.getParameter(PersistenceRequest.FIRST_RESULT);
					Integer firstResult = 0;
					if (fr != null) {
						firstResult = (Integer) fr;
					}
					data = persistenceControllerLocal.findEntities(maxResults, firstResult, type);
				} else {
					data = persistenceControllerLocal.findEntities(type);
				}
			}
			
			persistenceResponse.setStatus(PersistenceResponse.SUCCESS);
			persistenceResponse.setParameter(PersistenceResponse.DATA, data);
		} finally {
			persistenceRequest = null;
		}
		return persistenceResponse;
	}

	@Override
	public FingeraResponse findEntity(FingeraRequest request) {
		PersistenceRequest persistenceRequest = (PersistenceRequest) request;
		PersistenceResponse persistenceResponse = new PersistenceResponse();
		try {
			Object data = null;
			Integer id = (Integer) persistenceRequest.getParameter(PersistenceRequest.DATA);
			Class type = (Class) persistenceRequest.getParameter(PersistenceRequest.PERSISTENCE_TYPE);
			data = persistenceControllerLocal.findEntity(id, type);
			
			persistenceResponse.setStatus(PersistenceResponse.SUCCESS);
			persistenceResponse.setParameter(PersistenceResponse.DATA, data);
		} finally {
			persistenceRequest = null;
		}
		return persistenceResponse;
	}

	@Override
	public FingeraResponse getEntityCount(FingeraRequest request) {
		PersistenceRequest persistenceRequest = (PersistenceRequest) request;
		PersistenceResponse persistenceResponse = new PersistenceResponse();
		try {
			Integer count = persistenceControllerLocal.getEntityCount((Class) persistenceRequest.getParameter(PersistenceRequest.PERSISTENCE_TYPE));
			persistenceResponse.setParameter(PersistenceResponse.DATA, count);
			persistenceResponse.setStatus(PersistenceResponse.SUCCESS);
		} finally {
			persistenceRequest = null;
		}
		return persistenceResponse;
	}
}
