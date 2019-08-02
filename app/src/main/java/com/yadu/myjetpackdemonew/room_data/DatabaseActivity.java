package com.yadu.myjetpackdemonew.room_data;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yadu.myjetpackdemonew.AddNoteActivity;
import com.yadu.myjetpackdemonew.R;

import java.util.List;
import java.util.UUID;

public class DatabaseActivity extends AppCompatActivity {

    private static final int ADD_NOTE_ACTIVTY_REQUEST_CODE = 1;
    NoteViewModel noteViewModel;

    RecyclerView rec_note;
    NoteListAdapter noteListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        rec_note = (RecyclerView) findViewById(R.id.rec_note);
        noteListAdapter = new NoteListAdapter(this);
        rec_note.setAdapter(noteListAdapter);
        rec_note.setLayoutManager(new LinearLayoutManager(this));

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               Intent in = new Intent(getApplicationContext(), AddNoteActivity.class);
               startActivityForResult(in, ADD_NOTE_ACTIVTY_REQUEST_CODE);
            }
        });

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);

        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                noteListAdapter.setNodes(notes);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_NOTE_ACTIVTY_REQUEST_CODE && resultCode == RESULT_OK){

            //Code to insert
            final String note_id = UUID.randomUUID().toString();
            Note note = new Note(note_id, data.getStringExtra(AddNoteActivity.NOTE_ADDED));
            noteViewModel.insert(note);

            Toast.makeText(getApplicationContext(), "Data saved", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Data not saved", Toast.LENGTH_SHORT).show();
        }
    }
}
