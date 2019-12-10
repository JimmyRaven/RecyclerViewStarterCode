package com.example.recyclerviewstudentversion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
// Todo create a player class that will hold info about the player

public class MainActivity extends AppCompatActivity {
    // Todo initialize these variables
    private RecyclerView recyclerView;
    private MyRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<Player> list;

    ItemTouchHelper swipe = new ItemTouchHelper(
            new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT) {
                @Override
                public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                    final int fromPos = viewHolder.getAdapterPosition();
                    final int toPos = target.getAdapterPosition();
                    list.add(toPos, list.remove(fromPos));
                    mAdapter.notifyItemMoved(fromPos, toPos);
                    return true;
                }

                @Override
                public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                    final int fromPosi = viewHolder.getAdapterPosition();
                    list.remove(fromPosi);
                    mAdapter.notifyItemRemoved(fromPosi);

                }
            }
    );

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem mSearch = menu.findItem(R.id.search);
        SearchView mSearchView = (SearchView) mSearch.getActionView();
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);



    }

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        list = getPlayers();
        mAdapter = new MyRecyclerAdapter(list);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        swipe.attachToRecyclerView(recyclerView);

    }


    //Todo create method that will fill list of players
    public ArrayList getPlayers() {
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("Cristiano Ronaldo", 34, 460000000, "football", R.drawable.cronaldo, "https://en.wikipedia.org/wiki/Cristiano_Ronaldo"));
        players.add(new Player("LeBron James", 34, 480000000, "basketball", R.drawable.ljames, "https://en.wikipedia.org/wiki/LeBron_James"));
        players.add(new Player("Lionel Messi", 32, 400000000, "football", R.drawable.lmessi, "https://en.wikipedia.org/wiki/LeBron_James"));
        players.add(new Player("Sun Yang", 27, 3000000, "swimming", R.drawable.syang, "https://en.wikipedia.org/wiki/Sun_Yang"));
        players.add(new Player("Usain Bolt", 33, 90000000, "track and field", R.drawable.ubolt, "https://en.wikipedia.org/wiki/Sun_Yang"));
        players.add(new Player("Zhang Jike", 31, 1000000, "table tennis", R.drawable.zjike, "https://en.wikipedia.org/wiki/Zhang_Jike"));
        players.add(new Player("Serena Williams", 38, 200000000, "tennis", R.drawable.swilliams, "https://en.wikipedia.org/wiki/Serena_Williams"));
        players.add(new Player("Li Na", 37, 50000000, "tennis", R.drawable.lna, "https://en.wikipedia.org/wiki/Li_Na"));
        // Phillip, add another 7
        players.add(new Player("Derrick Rose", 31, 2100000, "basketball", R.drawable.drose, "https://en.wikipedia.org/wiki/Derrick_Rose"));
        players.add(new Player("Aaron Rodgers", 35, 89300000, "American football", R.drawable.arodgers, "https://en.wikipedia.org/wiki/Aaron_Rodgers"));
        players.add(new Player("Canelo Alvarez", 29, 92000000, "boxing", R.drawable.calvarez, "https://en.wikipedia.org/wiki/Canelo_%C3%81lvarez"));
        players.add(new Player("Mike Trout", 28, 50600000, "baseball", R.drawable.mtrout, "https://en.wikipedia.org/wiki/Mike_Trout"));
        players.add(new Player("Conor McGregor", 31, 47000000, "MMA", R.drawable.cmcgregor, "https://en.wikipedia.org/wiki/Conor_McGregor"));
        players.add(new Player("Stephen Curry", 31, 79800000, "basketball", R.drawable.curry, "https://en.wikipedia.org/wiki/Stephen_Curry"));
        players.add(new Player("Chris Paul", 34, 43800000, "basketball", R.drawable.cp, "https://en.wikipedia.org/wiki/Chris_Paul"));
        return players;
    }
}