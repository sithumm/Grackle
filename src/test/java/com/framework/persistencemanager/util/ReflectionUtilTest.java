/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.persistencemanager.util;

import org.grackle.domain.Users;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sithum
 */
public class ReflectionUtilTest {
    
    public ReflectionUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEntityPropertyValue method, of class ReflectionUtil.
     */
    @Test
    public void testGetEntityPropertyValue() throws Exception {
        System.out.println("getEntityPropertyValue");
        Object entity = new Users(1L, "sithum@gmail.com", "sithum", "nissanka", Short.valueOf("1"));
        String field = "email";
        Object[] args = {new Object()};
        Object expResult = "sithum@gmail.com";
        Object result = ReflectionUtil.getEntityPropertyValue(entity, field, args);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}