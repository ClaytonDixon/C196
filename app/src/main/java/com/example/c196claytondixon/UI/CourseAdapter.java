package com.example.c196claytondixon.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c196claytondixon.Entity.CourseEntity;

import com.example.c196claytondixon.Entity.TermEntity;
import com.example.c196claytondixon.R;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    class CourseViewHolder extends RecyclerView.ViewHolder {
        private final TextView courseItemView;
        private CourseViewHolder(View itemView) {
            super(itemView);
            courseItemView=itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    final CourseEntity current=mCourseEntities.get(position);
                    Intent intent = new Intent(context, editCourse.class);
                    intent.putExtra("courseID", current.getCourseID());
                    intent.putExtra("termID", current.getTermID());
                    intent.putExtra("title", current.getCourseTitle());
                    intent.putExtra("start", current.getCourseStart());
                    intent.putExtra("end", current.getCourseEnd());
                    intent.putExtra("status", current.getCourseStatus());
                    intent.putExtra("notes", current.getCourseNotes());
                    intent.putExtra("instructorName", current.getCourseInstructorName());
                    intent.putExtra("instructorPhoneNumber", current.getCourseInstructorPhoneNumber());
                    intent.putExtra("instructorEmail", current.getCourseInstructorEmail());
                    context.startActivity(intent);
                }
            });
        }
    }
    private List<CourseEntity> mCourseEntities;
    private final Context context;
    private final LayoutInflater mInflater;

    public CourseAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public CourseAdapter.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.course_list_item, parent, false);
        return new CourseAdapter.CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.CourseViewHolder holder, int position) {
        if(mCourseEntities!=null){
            CourseEntity current = mCourseEntities.get(position);
            String name = current.getCourseTitle();
            holder.courseItemView.setText(name);
        }
        else {
            holder.courseItemView.setText("No Course Title");
        }
    }

    public void setCourseEntities(List<CourseEntity> courseEntities) {
        mCourseEntities = courseEntities;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mCourseEntities!=null) {
            return mCourseEntities.size();
        } else return 0;
    }
}
