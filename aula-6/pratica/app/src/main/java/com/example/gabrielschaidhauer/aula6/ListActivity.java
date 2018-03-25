package com.example.gabrielschaidhauer.aula6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private String [] nomes = {"Gabriel", "Rodrigo", "Lucas", "Nelson", "Guilherme", "Aline"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        this.listView = findViewById(R.id.list_view);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ListActivity.this, MapsActivity.class);
                i.putExtra("nome", nomes[position]);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.listView.setAdapter(new ListAdapter());
    }


    private class ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return nomes.length;
        }

        @Override
        public Object getItem(int position) {
            return nomes[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View olderItem, ViewGroup parent) {
            View view = null;

            if(olderItem == null) {
                view = LayoutInflater.from(ListActivity.this).inflate(R.layout.fragment_nome, parent, false);
            } else {
                view = olderItem;
            }

            ((TextView) view.findViewById(R.id.nome)).setText((String) getItem(position));

            return view;
        }
    }
}
