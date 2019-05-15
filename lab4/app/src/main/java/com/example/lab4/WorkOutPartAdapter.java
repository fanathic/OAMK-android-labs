package com.example.lab4;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lab4.model.PausePart;
import com.example.lab4.model.WorkOutPartBase;
import com.example.lab4.model.WorkoutPart;

import java.util.ArrayList;
import java.util.List;

public class WorkOutPartAdapter extends ArrayAdapter<WorkOutPartBase> {
    private Context mContext;
    private List<WorkOutPartBase> workoutPartList = new ArrayList<>();

    public WorkOutPartAdapter(@NonNull Context context, ArrayList<WorkOutPartBase> workoutPartList) {
        super(context, 0, workoutPartList);
        this.mContext = context;
        this.workoutPartList = workoutPartList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            if(getItemViewType(position) == 0) {
                listItem = LayoutInflater.from(mContext).inflate(R.layout.list_row_workout, parent, false);
            } else if(getItemViewType(position) == 1) {
                listItem = LayoutInflater.from(mContext).inflate(R.layout.list_row_pause, parent, false);
            }
        WorkOutPartBase currentWorkOutPartBase = workoutPartList.get(position);
        if(currentWorkOutPartBase != null) {
            TextView textView;
            TextView textView2;
            if(getItemViewType(position) == 0) {
                textView = listItem.findViewById(R.id.textView_list_row_workout_type);
                textView2 = listItem.findViewById(R.id.textView_list_row_length);
            } else  {
                textView = listItem.findViewById(R.id.textView_list_row_workout_type);
                textView2 = listItem.findViewById(R.id.textView_list_row_length);
            }
            textView.setText(currentWorkOutPartBase.getType());
            textView2.setText(Integer.toString(currentWorkOutPartBase.getLength()));
        }
        return  listItem;

    }

    @Override
    public int getItemViewType(int position){
        if(workoutPartList.get(position) instanceof  WorkoutPart)
        {
            return 0;
        } else if(workoutPartList.get(position) instanceof PausePart)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

}
