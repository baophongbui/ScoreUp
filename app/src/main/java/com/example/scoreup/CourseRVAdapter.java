package com.example.scoreup;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.CourseViewHolder>{
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> info = new ArrayList<>();
    ArrayList<Integer> img = new ArrayList<>();
    private HomeFragment homeFragment;
    private Context context;
    //    private final RecyclerViewInterface recyclerViewInterface;
    public CourseRVAdapter(ArrayList<String> title, ArrayList<String> info, ArrayList<Integer> img, Context context) {
        this.title = title;
        this.info = info;
        this.img = img;
        this.context = context;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coursecardview,parent,false);

        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        holder.txtTitle.setText(title.get(position));
        holder.txtInfo.setText(info.get(position));
        holder.imgCourse.setImageResource(img.get(position));
        holder.constraintLayout.setOnClickListener(v -> {
            if (position == 0){
                Toast.makeText(context,"1",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,MainActivityQuiz.class);
                context.startActivity(intent);

            } else if (position == 1){
                Toast.makeText(context,"2",Toast.LENGTH_SHORT).show();

            } else if (position == 2){
                Toast.makeText(context,"3",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder{
        private TextView txtInfo, txtTitle;
        private ImageView imgCourse;
        private ConstraintLayout constraintLayout;
        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtInfo = itemView.findViewById(R.id.txtInfo);
            imgCourse = itemView.findViewById(R.id.imgCourse);
            constraintLayout = itemView.findViewById(R.id.course1);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (recyclerViewInterface != null){
//                        int pos = getAdapterPosition();
//
//                        if(pos != RecyclerView.NO_POSITION){
//                            recyclerViewInterface.onItemClick(pos);
//                        }
//                    }
//                }
//            });
        }
    }
}

