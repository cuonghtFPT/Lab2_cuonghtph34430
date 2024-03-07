package cuonghtph34430.poly.lab2application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder>{
    private Context context;
    private ArrayList<CityModal> list;

    public CityAdapter( Context context,ArrayList<CityModal> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.userentry, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CityModal city = list.get(position);
        holder.textCityName.setText("Name:"+city.getName());
        holder.textPopulation.setText("Popular:"+city.getPopular());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textCityName;
        TextView textPopulation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textCityName = itemView.findViewById(R.id.txtname);
            textPopulation = itemView.findViewById(R.id.txtpopular);
        }
    }
}
