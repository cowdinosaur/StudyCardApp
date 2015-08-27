package com.akmal.studycardapp;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.StudyCardHolder> {
    private StudyCard[] mDataset;

    public class StudyCardHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView mTextView;
        private StudyCard mStudyCard;

        public StudyCardHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.question_text);
            v.setOnClickListener(this);
        }

        public void bindStudyCard(StudyCard card) {
            mStudyCard = card;
            mTextView.setText(mStudyCard.question);
        }

        @Override
        public void onClick(View v) {
            if (mStudyCard != null) {
                Intent myIntent = new Intent(v.getContext(), CardActivity.class);
                myIntent.putExtra("study card", mStudyCard);
                v.getContext().startActivity(myIntent);
            }
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(StudyCard[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public StudyCardHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_card_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        StudyCardHolder vh = new StudyCardHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(StudyCardHolder holder, int position) {
        // - get element from your dataset at this position
        StudyCard card = mDataset[position];
        holder.bindStudyCard(card);


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
