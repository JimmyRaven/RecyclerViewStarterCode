package com.example.recyclerviewstudentversion;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


// Todo Implement methods required
//onCreateViewHolder()
//onBindViewHolder
//getItemCount
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private List<Player> mPlayer;

    public MyRecyclerAdapter(List<Player> mPlayer) {
        this.mPlayer = mPlayer;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int   viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_view,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Player playerlist = mPlayer.get(position);
        holder.nameText.setText(playerlist.getName());
        holder.ageText.setText(playerlist.getAge());
        holder.worthText.setText(String.valueOf(playerlist.getMoney()));
        holder.sportText.setText(playerlist.getSport());
        holder.pic.setImageResource(playerlist.getImage());


    }




// Todo implement ViewHolder
public static class MyViewHolder extends RecyclerView.ViewHolder {
    // get references to each of the views in the single_item.xml
    // Todo implement constructor
    ImageView pic;
    TextView nameText, ageText, worthText, sportText;

    private MyViewHolder(@NonNull View itemView) {
        nameText = itemView.findViewbyId(R.id.name);
        ageText = itemView.findViewbyId(R.id.age);
        worthText = itemView.findViewbyId(R.id.money);
        sportText = itemView.findViewbyId(R.id.sport);
        pic = itemView.findViewbyId(R.id.pic);

    }
}
}
