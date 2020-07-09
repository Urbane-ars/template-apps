package com.example.template.ui;


import com.example.template.datasource.db.SomeData;
import com.example.template.repository.MainRepository;

import java.util.List;

import javax.inject.Inject;

public class Presenter {


    MainRepository mainRepository;
    SomeData someData;


    @Inject
    public Presenter(MainRepository mainRepository, SomeData someData) {
        this.mainRepository = mainRepository;
        this.someData = someData;
    }

    private ViewContract viewContract;


    public void attachView(ViewContract firstActivity){
        viewContract = firstActivity;
        loadSavedSomeData();
    }

    public void addData(){
        String text = viewContract.getData();
        if ( text.isEmpty()){
            viewContract.showError();
        }
        else {
            someData.content = text;
            mainRepository.someDataDAO.add(someData);
            loadSavedSomeData();
        }
    }

    void loadSavedSomeData(){
        List<SomeData> someDataList = mainRepository.someDataDAO.getAll();
        viewContract.updateList(someDataList);
    }

    void deleteData(SomeData someData){
        mainRepository.someDataDAO.delete(someData);
        loadSavedSomeData();
    }


}
