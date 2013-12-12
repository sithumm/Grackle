/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.persistencemanager.controller;

import com.framework.requestresponsemodel.FingeraRequest;
import com.framework.requestresponsemodel.FingeraResponse;

/**
 *
 * @author sithum
 */
public interface PersistenceFrameworkController {
	
	public FingeraResponse create(FingeraRequest request);

	public FingeraResponse batchCreate(FingeraRequest request);

	public FingeraResponse edit(FingeraRequest request);

	public FingeraResponse batchEdit(FingeraRequest request);

	public FingeraResponse destroy(FingeraRequest request);

	public FingeraResponse batchDestroy(FingeraRequest request);

	public FingeraResponse findEntities(FingeraRequest request);

	public FingeraResponse findEntity(FingeraRequest request);

	public FingeraResponse getEntityCount(FingeraRequest request);
	
}
