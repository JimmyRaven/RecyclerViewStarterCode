package com.example.recyclerviewstudentversion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;
// Todo create a player class that will hold info about the player

public class MainActivity extends AppCompatActivity {
    // Todo initialize these variables
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<Player> list;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);

    }
    //Todo create method that will fill list of players
    public List getPlayers()
    {
        List<Player> list = Arrays.asList(new Player[]{
                new Player("Lionel Messi",32,44224400.00,"football",R.drawable.mesi),
                new Player("David Robert Joseph Beckham",44,1291800.00,"football",R.drawable.beckham),
                new Player("Hanyu Yuzulu",24,500000,"figure skating",R.drawable.hanyu),
                new Player("Zhang Jike",31,500000,"Ping-pong",R.drawable.zhang),
                new Player("Lin Dan",36,10000000,"Badminton",R.drawable.lin),
                new Player("Lee Chong Wei",37,5000000,"Badminton",R.drawable.lee),
                new Player("Lee Sang-hyeok (Faker)",23,890000,"E-sports (LOL)",R.drawable.faker),
                new Player("Fu Yuanhui",23,5000000,"Swimming",R.drawable.fu),
                new Player("Lang Ping",58,5000000,"Volleyball",R.drawable.lang)
        });
        return list;
    }
}