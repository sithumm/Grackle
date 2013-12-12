/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java.com.framework.persistencemanager.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author sithum
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.framework.persistencemanager.controller.PersistenceControllerImplTest.class, com.framework.persistencemanager.controller.PersistenceFrameworkControllerImplTest.class})
public class ControllerSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}