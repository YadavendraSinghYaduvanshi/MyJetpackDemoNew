package com.yadu.myjetpackdemonew.room_data;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yadu.myjetpackdemonew.R;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteViewHolder> {

    private LayoutInflater layoutInflater;
    private Context mContext;
    private List<Note> mNotes;

    public NoteListAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_note_layout, parent,false);
        NoteViewHolder noteViewHolder = new NoteViewHolder(itemView);
        return noteViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {

        if(mNotes != null){
            Note note = mNotes.get(position);
            holder.setData(note.getmNote(), position);

        }else {
            //Covers the case data not set yet
            holder.tv_note.setText("No note");
        }
    }

    @Override
    public int getItemCount() {
        if(mNotes==null){
            return 0;
        }
        else {
            return mNotes.size();
        }

    }

    public void setNodes(List<Note> notes){
        mNotes = notes;
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_note;
        private int mPosition;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_note = (TextView) itemView.findViewById(R.id.tv_note_item);
        }

        public void setData(String note, int position) {

            tv_note.setText(note);
            mPosition = position;
        }
    }
}
