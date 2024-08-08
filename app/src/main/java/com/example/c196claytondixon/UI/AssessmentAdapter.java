package com.example.c196claytondixon.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c196claytondixon.Entity.AssessmentEntity;
import com.example.c196claytondixon.R;

import java.util.List;

public class AssessmentAdapter extends RecyclerView.Adapter<AssessmentAdapter.AssessmentViewHolder> {
    class AssessmentViewHolder extends RecyclerView.ViewHolder {
        private final TextView assessmentItemView;
        private AssessmentViewHolder(View itemView) {
            super(itemView);
            assessmentItemView=itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    final AssessmentEntity current=mAssessmentEntities.get(position);
                    Intent intent = new Intent(context, editAssessment.class);
                    intent.putExtra("id", current.getAssessmentID());
                    intent.putExtra("title", current.getAssessmentTitle());
                    intent.putExtra("start", current.getAssessmentStart());
                    intent.putExtra("end", current.getAssessmentEnd());
                    intent.putExtra("type", current.getAssessmentType());
                    intent.putExtra("courseID", current.getCourseID());
                    context.startActivity(intent);
                }
            });
        }
    }
    private List<AssessmentEntity> mAssessmentEntities;
    private final Context context;
    private final LayoutInflater mInflater;

    public AssessmentAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public AssessmentAdapter.AssessmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.assessment_list_item, parent, false);
        return new AssessmentAdapter.AssessmentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AssessmentAdapter.AssessmentViewHolder holder, int position) {
        if(mAssessmentEntities!=null){
            AssessmentEntity current = mAssessmentEntities.get(position);
            String name = current.getAssessmentTitle();
            holder.assessmentItemView.setText(name);
        }
        else {
            holder.assessmentItemView.setText("No Assessment Title");
        }
    }

    public void setAssessmentEntities(List<AssessmentEntity> assessmentEntities) {
        mAssessmentEntities = assessmentEntities;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mAssessmentEntities!=null) {
            return mAssessmentEntities.size();
        } else return 0;
    }

    }

