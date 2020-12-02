package de.ur.mi.android.u05todolistemitdatum;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ToDoListAdapter  extends ArrayAdapter<TaskItem> {

    private ArrayList<TaskItem> taskList;

    public ToDoListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if(v == null) {

        }

        TaskItem task = taskList.get(position);

        if(task != null) {


        }

        return v;
    }
}
