package com.example.template.datasource.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import javax.inject.Inject;

@Entity
public class SomeData {
   @Inject
   public SomeData() {
   }

   @PrimaryKey(autoGenerate = true)
   @ColumnInfo(name = "id")
   public int id;

   @ColumnInfo(name = "content")
   public String content;

   @NonNull
   @Override
   public String toString() {
      return String.format("id: %s; content: %s ", id, content);
   }
}
