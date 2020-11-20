package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    protected ListView listviewperso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listviewperso=findViewById(R.id.listviewperso);

        ArrayList<HashMap<String,String>> listItem =new ArrayList<>();
        HashMap<String,String> map;
        map=new HashMap<>();
        map.put("titre", "Word");
        map.put("descreption", "Editeur de text");
        map.put("img", String.valueOf((R.drawable.word)));
        listItem.add((map));

        map=new HashMap<>();
        map.put("titre", "exel");
        map.put("descreption", "tableur");
        map.put("img", String.valueOf((R.drawable.excel)));
        listItem.add((map));

        map=new HashMap<>();
        map.put("titre", "outlook");
        map.put("descreption", "client de courrier electronique");
        map.put("img", String.valueOf((R.drawable.outlook)));
        listItem.add((map));


        map=new HashMap<>();
        map.put("titre", "powerpoint");
        map.put("descreption", "logiciel de présentation");
        map.put("img", String.valueOf((R.drawable.powerpoint)));
        listItem.add((map));

        SimpleAdapter adapter= new SimpleAdapter(this.getBaseContext(),
                 listItem,
                R.layout.activity_list_item,
                new String[]{"img", "titre", "descreption"},
                new int[]{R.id.img, R.id.titre, R.id.description});

        listviewperso.setAdapter(adapter);
        listviewperso.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),listviewperso.getItemAtPosition(position).get("title"),Toast.LENGTH_LONG).show();
            }
        });
        listviewperso.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            HashMap map = (HashMap) listviewperso.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), (String) map.get("titre"),
                    Toast.LENGTH_SHORT).show();
            String selectedItem = ((TextView) view.findViewById(R.id.titre)).getText().toString();
            Toast.makeText(MainActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
            return true;
            }
        });}}














