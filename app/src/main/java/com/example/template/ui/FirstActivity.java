package com.example.template.ui;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.template.App;
import com.example.template.R;
import com.example.template.datasource.db.SomeData;


import java.util.List;

import javax.inject.Inject;


public class FirstActivity extends AppCompatActivity implements ViewContract {

    @Inject
    Presenter presenter;
    @Inject
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO Launcher Theme
        ((App) getApplication()).getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        init();
    }

    void init(){
        presenter.attachView(this);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.addData();
            }
        });
        RecyclerView recyclerView = findViewById(R.id.list_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void updateList(List<SomeData> list){
        adapter.setData(list);
    }

    public String getData(){
        EditText editText = findViewById(R.id.editText);
        String text = editText.getText().toString();
        editText.setText("");
        return text;
    }


    public void showError() {
        EditText editText = findViewById(R.id.editText);
        editText.setError(this.getString(R.string.no_data));
    }

}
