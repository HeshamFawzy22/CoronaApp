package com.example.egyptnews.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.egyptnews.R;
import com.example.egyptnews.model.NewsResponse;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> implements Filterable {

    List<NewsResponse> worldList;
    List<NewsResponse> finalWorldList;

    public NewsAdapter(List<NewsResponse> worldList) {
        this.worldList = worldList;
        finalWorldList = worldList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NewsResponse country = finalWorldList.get(position);

        holder.countryName.setText(country.getCountry());
        holder.casesText.setText("Total cases: " + country.getCases());
        holder.deaths.setText("Total deaths: " + country.getDeaths());
        holder.todayCases.setText("Today's cases: " + country.getTodayCases());
        holder.todaysDeath.setText("Today's deaths: " + country.getTodayDeaths());
        holder.recovered.setText("Recovered: " + country.getRecovered());
        holder.active.setText("Active: " + country.getActive());
        holder.critical.setText("Critical: " + country.getCritical());
        holder.casesPerMillion.setText("Cases/Million: " + country.getCasesPerOneMillion());
    }

    @Override
    public int getItemCount() {
        return finalWorldList == null? 0 : finalWorldList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String searchKeyWord = constraint.toString().toLowerCase();
                if (searchKeyWord == null){
                    finalWorldList = worldList;
                }else {
                    List<NewsResponse> worldListFiltered = new ArrayList<>();
                    for (NewsResponse item : worldList ){
                        if (item.getCountry().toLowerCase().contains(searchKeyWord)){
                            worldListFiltered.add(item);
                        }
                    }
                    finalWorldList = worldListFiltered;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = finalWorldList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                finalWorldList = (List<NewsResponse>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView countryName, casesText, deaths, todayCases, todaysDeath, recovered, active, critical, casesPerMillion;

        public MyViewHolder(View itemView) {
            super(itemView);

            countryName = (TextView) itemView.findViewById(R.id.countryName);
            casesText = (TextView) itemView.findViewById(R.id.casesText);
            deaths = (TextView) itemView.findViewById(R.id.deaths);
            todayCases = (TextView) itemView.findViewById(R.id.todayCases);
            todaysDeath = (TextView) itemView.findViewById(R.id.todaysDeath);
            recovered = (TextView) itemView.findViewById(R.id.recovered);
            active = (TextView) itemView.findViewById(R.id.active);
            critical = (TextView) itemView.findViewById(R.id.critical);
            casesPerMillion = (TextView) itemView.findViewById(R.id.casesPerMillion);
        }
    }
}
