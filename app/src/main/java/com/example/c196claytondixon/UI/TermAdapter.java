package com.example.c196claytondixon.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c196claytondixon.Entity.TermEntity;
import com.example.c196claytondixon.R;

import java.util.List;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder> {
    class TermViewHolder extends RecyclerView.ViewHolder{
        private final TextView termItemView;
        private TermViewHolder(View itemView) {
            super(itemView);
            termItemView=itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    final TermEntity current=mTermEntities.get(position);
                    Intent intent = new Intent(context, editTerm.class);
                    intent.putExtra("id", current.getTermID());
                    intent.putExtra("name", current.getTermName());
                    intent.putExtra("start", current.getTermStart());
                    intent.putExtra("end", current.getTermEnd());
                    context.startActivity(intent);
                }
            });
        }
    }

    private List<TermEntity> mTermEntities;
    private final Context context;
    private final LayoutInflater mInflater;

    public TermAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public TermAdapter.TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.term_list_item, parent, false);
        return new TermViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TermAdapter.TermViewHolder holder, int position) {
        if(mTermEntities!=null){
            TermEntity current = mTermEntities.get(position);
            String name = current.getTermName();
            holder.termItemView.setText(name);
        }
        else {
            holder.termItemView.setText("No Term Name");
        }
    }

    public void setTermEntities(List<TermEntity> termEntities) {
        mTermEntities = termEntities;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mTermEntities!=null) {
            return mTermEntities.size();
        } else return 0;
    }
}
