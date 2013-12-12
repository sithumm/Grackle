/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.persistencemanager.controller;

import com.framework.persistencemanager.exceptions.NonexistentEntityException;
import com.framework.persistencemanager.exceptions.PreexistingEntityException;
import com.framework.persistencemanager.exceptions.RollbackFailureException;
import com.framework.persistencemanager.util.ReflectionUtil;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author sithum
 */
public class PersistenceControllerImpl implements PersistenceController {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("GracklePU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction etx = em.getTransaction();

    /**
     *
     * @param entity
     * @param type
     * @throws PreexistingEntityException
     * @throws RollbackFailureException
     * @throws Exception
     */
    @Override
    public void create(Object entity, Class type) throws PreexistingEntityException, RollbackFailureException, Exception {
        try {
            etx.begin();
            em.persist(entity);
            etx.commit();
        } catch (Exception ex) {
            try {
                etx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findEntity((Integer) ReflectionUtil.getEntityPropertyValue(entity, "id", null), type.getClass()) != null) {
                throw new PreexistingEntityException("Record already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void batchCreate(List<Object> entityList, Class type, String query, boolean isNamedQuery, Map<String, Object> params) throws PreexistingEntityException, RollbackFailureException, Exception {
        try {
            int index = 0;
            int[] ids = new int[entityList.size()];
            params.put("IDS", ids);
            etx.begin();
            for (Object entity : entityList) {
                em.persist(entity);
                ids[index] = (Integer) ReflectionUtil.getEntityPropertyValue(entity, "id", null);
                if (++index % 25 == 0) {
                    em.flush();
                }
            }
            etx.commit();
        } catch (Exception ex) {
            try {
                etx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (this.findEntities(query, isNamedQuery, params) != null) {
                throw new PreexistingEntityException("Some records already exist.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void edit(Object entity) throws NonexistentEntityException, RollbackFailureException, Exception {
        try {
            etx.begin();
            entity = em.merge(entity);
            etx.commit();
        } catch (Exception ex) {
            try {
                etx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = (Integer) ReflectionUtil.getEntityPropertyValue(entity, "id", null);
                if (findEntity(id, entity.getClass()) == null) {
                    throw new NonexistentEntityException("The record with id :: " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void batchEdit(List<Object> entityList, Class type, String query, boolean isNamedQuery, Map<String, Object> params) throws NonexistentEntityException, RollbackFailureException, Exception {
        try {
            int index = 0;
            int[] ids = new int[entityList.size()];
            params.put("IDS", ids);
            etx.begin();
            for (Object entity : entityList) {
                ids[index] = (Integer) ReflectionUtil.getEntityPropertyValue(entity, "id", null);
                entity = em.merge(entity);
                if (++index % 25 == 0) {
                    em.flush();
                }
            }
            etx.commit();
        } catch (Exception ex) {
            try {
                etx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                List<Object> list = findEntities(query, isNamedQuery, params);
                if (list == null || list.size() < entityList.size()) {
                    throw new NonexistentEntityException("Some records  no longer exist.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void destroy(Integer id, Class type) throws NonexistentEntityException, RollbackFailureException, Exception {
        try {
            etx.begin();
            Object entity;
            try {
                entity = em.getReference(type, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The record with id :: " + id + " no longer exists.", enfe);
            }
            em.remove(entity);
            etx.commit();
        } catch (Exception ex) {
            try {
                etx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void destroy(Object entity, Class type) throws NonexistentEntityException, RollbackFailureException, Exception {
        try {
            etx.begin();
            Integer id = (Integer) ReflectionUtil.getEntityPropertyValue(entity, "id", null);
            try {
                entity = em.getReference(type, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The record with id :: " + id + " no longer exists.", enfe);
            }
            em.remove(entity);
            etx.commit();
        } catch (Exception ex) {
            try {
                etx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void batchDestroy(List<Object> entityList) throws NonexistentEntityException, RollbackFailureException, Exception {
        try {
            etx.begin();
            for (Object entity : entityList) {
                em.remove(entity);
            }
            etx.commit();
        } catch (Exception ex) {
            try {
                etx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void batchDestroy(String query, boolean isNamedQuery, Map<String, Object> params) throws NonexistentEntityException, RollbackFailureException, Exception {
        try {
            etx.begin();
            List<Object> list = findEntities(query, isNamedQuery, params);
            for (Object entity : list) {
                em.remove(entity);
            }
            etx.commit();
        } catch (Exception ex) {
            try {
                etx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Object> findEntities(Class type) {
        return findEntities(true, -1, -1, type);
    }

    @Override
    public List<Object> findEntities(int maxResults, int firstResult, Class type) {
        return findEntities(false, maxResults, firstResult, type);
    }

    private List<Object> findEntities(boolean all, int maxResults, int firstResult, Class type) {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(type));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param query
     * @param queryName
     * @param params
     * @return
     */
    @Override
    public List<Object> findEntities(String query, boolean isNamedQuery, Map<String, Object> params) {
        try {
            Query q = null;
            if (isNamedQuery) {
                q = em.createNamedQuery(query);
                q = this.setParameters(q, params);
            } else if (query != null && !"".equals(query)) {
                q = em.createQuery(query);
                q = this.setParameters(q, params);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    private Query setParameters(Query q, Map<String, Object> params) {
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                q.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return q;
    }

    @Override
    public Object findEntity(Integer id, Class type) {
        try {
            return em.find(type, id);
        } finally {
            em.close();
        }
    }

    @Override
    public int getEntityCount(Class type) {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Object> rt = cq.from(type);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}