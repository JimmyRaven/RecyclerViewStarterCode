package com.example.recyclerviewstudentversion;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


// Todo Implement methods required
//onCreateViewHolder()
//onBindViewHolder
//getItemCount
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> implements Filterable {

    private List<Player> mPlayer;
    private List<Player> exPlayer;
    Context context;

    public MyRecyclerAdapter(List<Player> mPlayer) {
        this.mPlayer = mPlayer;
        exPlayer=new ArrayList<>(mPlayer);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int   viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item_view,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Player playerlist = mPlayer.get(position);
        holder.nameText.setText(playerlist.getName());
        holder.ageText.setText("Age: " + String.valueOf(playerlist.getAge()));
        holder.worthText.setText("Net Worth: $" + String.valueOf(playerlist.getMoney()));
        holder.sportText.setText(playerlist.getSport());
        holder.pic.setImageResource(playerlist.getImage());


    }



    @Override public int getItemCount() {
        return mPlayer.size();
    }

    @Override
    public Filter getFilter() {
        return exFilter;
    }
    private Filter exFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Player> filterList=new ArrayList<>();
            if(charSequence==null||charSequence.length()==0)
            {
                filterList.addAll(exPlayer);
            }
            else
            {
                String pattern=charSequence.toString().toLowerCase().trim();

                for(Player p:exPlayer)
                {
                    if(p.getName().toLowerCase().contains(pattern))
                    {
                        filterList.add(p);
                    }
                }
            }
            FilterResults results=new FilterResults();
            results.values=filterList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            mPlayer.clear();
            mPlayer.addAll((List)filterResults.values);
            notifyDataSetChanged();
        }
    };


    // Todo implement ViewHolder
public static class MyViewHolder extends RecyclerView.ViewHolder {
    // get references to each of the views in the single_item.xml
    // Todo implement constructor
    ImageView pic;
    TextView nameText, ageText, worthText, sportText;

    private MyViewHolder(@NonNull View itemView) {
        super(itemView);
        nameText = itemView.findViewById(R.id.name);
        ageText = itemView.findViewById(R.id.age);
        worthText = itemView.findViewById(R.id.money);
        sportText = itemView.findViewById(R.id.sport);
        pic = itemView.findViewById(R.id.image);

    }

}


}
