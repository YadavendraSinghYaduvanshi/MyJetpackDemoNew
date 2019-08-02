package com.yadu.myjetpackdemonew.room_data;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private String TAG = this.getClass().getSimpleName();
    private NoteDAO noteDao;
    private NoteRoomDatabase noteDb;
    private LiveData<List<Note>> mAllNotes;

    public NoteViewModel(Application application){

        super(application);

        noteDb = NoteRoomDatabase.getDatabase(application);
        noteDao = noteDb.noteDAO();
        mAllNotes = noteDao.getAllNotes();
    }

    public void insert(Note note){
        new InsertAsynckTask(noteDao).execute(note);
    }

    LiveData<List<Note>> getAllNotes(){
       return mAllNotes;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
            Log.i(TAG, "ViewModel Destroyed");
    }

    private class InsertAsynckTask extends AsyncTask<Note, Void, Void> {

        NoteDAO mNoteDao;
        public InsertAsynckTask(NoteDAO mNoteDao) {

            this.mNoteDao = mNoteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {

            mNoteDao.insert(notes[0]);
            return null;
        }
    }
}
