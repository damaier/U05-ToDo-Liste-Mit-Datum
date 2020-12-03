package de.ur.mi.android.u05todolistemitdatum;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private EditText etTaskInput;
    private EditText etTaskDate;
    private ImageButton btnAdd;
    private ListView listView;
    private ToDoListAdapter adapter;
    private ArrayList<TaskItem> todoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setupViews();

    }

    private void findViews() {
        etTaskInput = findViewById(R.id.et_task);
        etTaskDate = findViewById(R.id.editTextDate);
        btnAdd = findViewById(R.id.btn_add);
        listView = findViewById(R.id.todo_listView);
    }

    private void setupViews() {
        todoList = new ArrayList<>();
        adapter = new ToDoListAdapter(this, android.R.layout.simple_list_item_1, todoList);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                todoList.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newTask = etTaskInput.getText().toString().trim();
                String date = etTaskDate.getText().toString().trim();
                if (!newTask.isEmpty()) {
                    todoList.add(new TaskItem(newTask,date));
                    adapter.notifyDataSetChanged();
                    etTaskInput.setText("");
                }
            }
        });

        etTaskDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDatePickerDialog().show();
            }
        });
    }


    private DatePickerDialog createDatePickerDialog(){
        GregorianCalendar today = new GregorianCalendar();
        int day = today.get(Calendar.DAY_OF_MONTH);
        int month = today.get(Calendar.MONTH);
        int year = today.get(Calendar.YEAR);

        return new DatePickerDialog(this, this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        GregorianCalendar date = new GregorianCalendar(year, month, dayOfMonth);
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.GERMANY);
        etTaskDate.setText(df.format(date.getTime()));

    }
}
