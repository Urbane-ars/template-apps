package com.example.template.datasource.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface SomeDataDAO {

    @Insert
    void add(SomeData someData);

    @Delete
    void delete(SomeData someData);


    @Query("SELECT * FROM SomeData")
    List<SomeData> getAll();


}
