package com.daffzzaqihaq.ourheroes;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.daffzzaqihaq.ourheroes.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {

    @BindView(R.id.my_recycler_view)
    RecyclerView myRecyclerView;

    String[] namaHeroes,detailHeroes;
    int[] gambarHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);


        namaHeroes = getResources().getStringArray(R.array.heroesname);
        detailHeroes = getResources().getStringArray(R.array.heroesdetail);
        gambarHeroes = new int[]{R.drawable.bungtomo, R.drawable.muhatta, R.drawable.patimura, R.drawable.imambonjol, R.drawable.cutnyakdien, R.drawable.kihajardewantara, R.drawable.diponegoro, R.drawable.kartini, R.drawable.soedirman, R.drawable.soekarno};

        Adapter adapter = new Adapter(RecycleActivity.this, gambarHeroes, namaHeroes, detailHeroes);

        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(RecycleActivity.this));
        myRecyclerView.setAdapter(adapter);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.action_profile:
                intent = new Intent(this, Profile.class);
                startActivity(intent);
                break;

            case R.id.action_about:
                intent = new Intent(this, About.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
