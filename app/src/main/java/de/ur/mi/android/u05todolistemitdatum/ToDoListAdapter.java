package de.ur.mi.android.u05todolistemitdatum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ToDoListAdapter  extends ArrayAdapter<TaskItem> {

    private ArrayList<TaskItem> taskList;

    public ToDoListAdapter(@NonNull Context context, int resource, ArrayList list) {
        super(context, resource,list);
        taskList = list;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if(v == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService (Context.LAYOUT_INFLATER_SERVICE);

                    v = inflater.inflate(R.layout.layout , null);
        }

        TaskItem task = taskList.get(position);

        if(task != null) {
            TextView textview_task = (TextView) v.findViewById(R.id.textView_task);
            TextView textview_date = (TextView) v.findViewById(R.id.textView_date);

            textview_task.setText(task.getTask());
            textview_date.setText(task.getDate());


        }

        return v;
    }
}
