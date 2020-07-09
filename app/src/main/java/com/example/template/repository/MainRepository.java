package com.example.template.repository;



import com.example.template.datasource.db.SomeDataDAO;

import javax.inject.Inject;



public class MainRepository {

   public SomeDataDAO someDataDAO;


    @Inject
    public MainRepository(SomeDataDAO someDataDAO) {
        this.someDataDAO = someDataDAO;
    }


}
