package sg.edu.rp.c346.id19021138.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {

    private ArrayList<Task> taskArrayList;
    private Context context;
    private int resource;

    public TaskAdapter(Context context, int resource, ArrayList<Task> taskArrayList) {
        super(context, resource, taskArrayList);
        this.context = context;
        this.taskArrayList = taskArrayList;
        this.resource = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Inflate View
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(resource, parent, false);

        // Views
        TextView idTv = rowView.findViewById(R.id.tvID);
        TextView descTV = rowView.findViewById(R.id.tvDesc);
        TextView dateTV = rowView.findViewById(R.id.tvDate);

        // Get Data
        Task task = taskArrayList.get(position);

        // Set Data of Views
        idTv.setText(task.getId());
        descTV.setText(task.getDescription());
        dateTV.setText(task.getDate());

        //Check if the property for starts >= 5, if so, "light" up the stars
//		if (/*stars >= 5*/) {
//			iv5.setImageResource(android.R.drawable.btn_star_big_on);
//			iv4.setImageResource(android.R.drawable.btn_star_big_on);
//			iv3.setImageResource(android.R.drawable.btn_star_big_on);
//			iv2.setImageResource(android.R.drawable.btn_star_big_on);
//			iv1.setImageResource(android.R.drawable.btn_star_big_on);
//		}

        return rowView;
    }
    

}
