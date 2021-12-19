package haqnawaz.org.sqlitedb20211216;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button buttonAdd, buttonViewAll;
    EditText editName, editAge;
    Switch switchIsActive;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonUpdate);
        buttonViewAll = findViewById(R.id.buttonViewAll);
        editName = findViewById(R.id.textName);
        editAge = findViewById(R.id.textAge);
        switchIsActive = findViewById(R.id.studentSwitch);
        recyclerView = findViewById(R.id.recyclerViewStudents);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            StudentModel studentModel;

            @Override
            public void onClick(View v) {
                try {
                    studentModel = new StudentModel(editName.getText().toString(), Integer.parseInt(editAge.getText().toString()), switchIsActive.isChecked());
                    DbHelper dbHelper = new DbHelper(MainActivity.this);
                    dbHelper.addStudent(studentModel);
//                    Toast.makeText(MainActivity.this, studentModel.toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "ADDED", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                List<StudentModel> list = dbHelper.getAllStudents();

                recyclerView.setHasFixedSize(true);

                //LinearLayoutManager GridLayoutManager
                layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(layoutManager);

                adapter = new myRecyclerViewAdapter(list) ;
                recyclerView.setAdapter(adapter);
                //adapter.notifyDataSetChanged();



            }
        });

    }
}
