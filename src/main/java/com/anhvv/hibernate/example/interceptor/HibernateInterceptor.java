package com.anhvv.hibernate.example.interceptor;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class HibernateInterceptor extends EmptyInterceptor {

    @Override
    public void onDelete(
            Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {
        System.out.println("Hello delete ");
    }

    @Override
    public boolean onSave(
            Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {
        System.out.println("Hello save ");
        return false;
    }

    @Override
    public int[] findDirty(
            Object entity,
            Serializable id,
            Object[] currentState,
            Object[] previousState,
            String[] propertyNames,
            Type[] types) {
        System.out.println("Hello save ");
        return null;
    }
}
