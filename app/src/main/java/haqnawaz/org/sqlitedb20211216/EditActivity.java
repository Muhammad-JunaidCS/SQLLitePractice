package haqnawaz.org.sqlitedb20211216;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {
    TextView textName,textAge;
    int id;
    Switch aSwitch;
    Button updateBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        //getting data from intent
        Intent intent=getIntent();
        String name=intent.getStringExtra("Name");
        int age=intent.getIntExtra("Age",0);
        boolean active=intent.getBooleanExtra("Active",false);
        id=intent.getIntExtra("Id",0);

        textName=findViewById(R.id.textName);
        textAge=findViewById(R.id.textAge);
        aSwitch=findViewById(R.id.studentSwitch);

        //setting value in views
        aSwitch.setChecked(active);
        textAge.setText(""+age);
        textName.setText(name);

        updateBtn=findViewById(R.id.buttonUpdate);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper db =new DbHelper(v.getContext());
                db.updateRecordById(id,textName.getText().toString(), Integer.parseInt(textAge.getText().toString()), aSwitch.isChecked());

                Intent intent = new Intent(v.getContext(),MainActivity.class);
                v.getContext().startActivity(intent);
            }
        });

    }
}