package com.yadu.myjetpackdemonew.room_data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {

    public Note(String id, String mNote){
        this.id=id;
        this.mNote = mNote;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getmNote() {
        return mNote;
    }

    @PrimaryKey
    @NonNull
    public String id;

    @NonNull
    @ColumnInfo(name = "note")
    public String mNote;
}
