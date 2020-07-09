package com.example.template.ui;

import com.example.template.datasource.db.SomeData;

import java.util.List;

public interface ViewContract {
 void updateList(List<SomeData> list);
 String getData();
 void showError();

}
