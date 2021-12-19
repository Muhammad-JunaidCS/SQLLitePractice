package haqnawaz.org.sqlitedb20211216;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.MyViewHolder> {
    List<StudentModel> studentsList;

    public myRecyclerViewAdapter(List<StudentModel> studentsList) {
        this.studentsList=studentsList;
    }

    @NonNull
    @Override
    public myRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_record, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.data=studentsList.get(position);
        holder.textViewName.setText(holder.data.getName());
        holder.textViewAge.setText(""+holder.data.getAge());
        holder.textViewIsActive.setText(holder.data.isActive()==true?"True":"False");
        holder.textViewId.setText(""+holder.data.getId());
        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "DELETED", Toast.LENGTH_SHORT).show();
                DbHelper db =new DbHelper(v.getContext());
                db.deleteRecordById(holder.data.getId());

            }
        });
        holder.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(v.getContext(), ""+holder.data.getId(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(v.getContext(),EditActivity.class);
                intent.putExtra("Name",holder.data.getName());
                intent.putExtra("Age",holder.data.getAge());
                intent.putExtra("Id",holder.data.getId());
                intent.putExtra("Active",holder.data.isActive());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewAge;
        TextView textViewId;
        TextView textViewIsActive;
        Button deleteBtn;
        Button editBtn;
        StudentModel data;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.name);
            textViewAge = itemView.findViewById(R.id.age);
            textViewId = itemView.findViewById(R.id.ID);
            textViewIsActive = itemView.findViewById(R.id.isActive);
            deleteBtn=itemView.findViewById(R.id.delete);
            editBtn=itemView.findViewById(R.id.edit);
        }
    }
}
