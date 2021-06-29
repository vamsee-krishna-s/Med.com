package com.Vamsee.medcom;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable{
    Context context;
    ArrayList<Medicine_Collection> medicineArrayList;
    ArrayList<Medicine_Collection> filterlist;
    public MyAdapter(Context context, ArrayList<Medicine_Collection> medicineArrayList) {
        this.context = context;
        this.medicineArrayList = medicineArrayList;
        this.filterlist = medicineArrayList;
    }

    @Override
    public int getItemCount() {
        return medicineArrayList.size();
    }

    @NotNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.dip_item,parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NotNull MyAdapter.MyViewHolder holder, int position) {

        Medicine_Collection medicine_collection = medicineArrayList.get(position);
        holder.Address.setText(medicine_collection.Address);
        holder.Name.setText(medicine_collection.Name);
        holder.Mobile.setText(medicine_collection.Mobile);
        holder.City.setText(medicine_collection.City);

        holder.rep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                String str = medicine_collection.Mobile;


                
                Intent intent = new Intent(v.getContext(), report.class);
                intent.putExtra("Key",str);
                context.startActivity(intent);
            }
        });

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                String no = medicine_collection.Mobile;

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+no));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public Filter getFilter() {

        Filter mfilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();

                if (charString.isEmpty()) {

                    filterlist = medicineArrayList;
                } else {

                    ArrayList<Medicine_Collection> filteredList = new ArrayList<>();

                    for (Medicine_Collection androidVersion : medicineArrayList) {

                        if (androidVersion.getCity().toLowerCase().contains(charString) || androidVersion.getName().toLowerCase().contains(charString)) {

                            filteredList.add(androidVersion);
                        }
                    }

                    filterlist = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filterlist;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

            }
        };

        return mfilter;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView Address, City, Mobile, Name;
        Button rep, call;
        public MyViewHolder(@NotNull View itemView) {
            super(itemView);
            Address = itemView.findViewById(R.id.AddressText);
            City = itemView.findViewById(R.id.locationN);
            Mobile = itemView.findViewById(R.id.line);
            Name = itemView.findViewById(R.id.personName);
            rep = itemView.findViewById(R.id.reportBtn);
            call = itemView.findViewById(R.id.ContactNumber);

        }

    }

}