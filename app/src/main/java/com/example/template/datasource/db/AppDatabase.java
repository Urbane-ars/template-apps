package com.example.template.datasource.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {SomeData.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SomeDataDAO someDataDAO();

}
