package haqnawaz.org.sqlitedb20211216;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        StudentModel data;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.name);
            textViewAge = itemView.findViewById(R.id.age);
            textViewId = itemView.findViewById(R.id.ID);
            textViewIsActive = itemView.findViewById(R.id.isActive);

        }
    }
}
