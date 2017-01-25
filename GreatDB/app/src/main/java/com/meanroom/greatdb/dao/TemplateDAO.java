package com.meanroom.greatdb.dao;

import java.util.List;

/**
 * Created by phuon on 25-Jan-17.
 */
public interface TemplateDAO<T> {

    long insert(T t);

    List<T> getAll();

    List<T> lists();

    boolean delete(T t);


    long update(long id,T mNew);






}
