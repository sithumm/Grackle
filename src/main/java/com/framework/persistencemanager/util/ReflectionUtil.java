/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.persistencemanager.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author sithum
 */
public class ReflectionUtil {
    
    public static Object getEntityPropertyValue (Object entity, String field, Object[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {;
        Method [] m;
        m = entity.getClass().getMethods();
        Method method = null;
        for (Method me : m) {
            if (me.getName().contains("get") && me.getName().toUpperCase().contains(field.toUpperCase())) {
                method = me;
//                break;
            }
        }
        Object result = method.invoke(entity, (Object)args);
        System.out.println("result::"+result);
        return result;
    }
    
}
