package com.example.template.di;

import android.content.Context;

import androidx.room.Room;

import com.example.template.App;
import com.example.template.datasource.db.AppDatabase;
import com.example.template.datasource.db.SomeDataDAO;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class StorageModule {
    private Context context;

    public StorageModule(App app) {
        context = app.getApplicationContext();
    }

    @Singleton
    @Provides
    SomeDataDAO providesSomeDataDAO(){
        return (Room.databaseBuilder(context, AppDatabase.class, "appData").allowMainThreadQueries().build()).someDataDAO(); // TODO asynchronously run the query
    }


}
