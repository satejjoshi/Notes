package com.example.user.notestaker;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder>
{

    private Context mContext;
    private Cursor mCursor;
    public NotesAdapter(Context context, Cursor cursor)
    {
        mContext = context;
        mCursor= cursor;
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder
    {
        public TextView headText;
        public TextView subText;

        public NotesViewHolder(@NonNull View itemView)
        {
            super(itemView);
            headText= itemView.findViewById(R.id.title_note);
            subText= itemView.findViewById(R.id.content_note);
        }
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater= LayoutInflater.from(mContext);
        View view= inflater.inflate((R.layout.activity_main),viewGroup,false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder notesViewHolder, int position) {
        if(!mCursor.move(position)) {
            return;
        }
        String  mHead= mCursor.getString(mCursor.getColumnIndex(DatabaseValues.DatabaseValuesSubClass.COLUMN_HEAD));
        String mText= mCursor.getString(mCursor.getColumnIndex(DatabaseValues.DatabaseValuesSubClass.COLUMN_TEXT));
        notesViewHolder.headText.setText(mHead);
        notesViewHolder.subText.setText(mText);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }
}
