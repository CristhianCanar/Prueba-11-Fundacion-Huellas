package com.nitrocanar.fundacionhuellas.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.nitrocanar.fundacionhuellas.R;
import com.nitrocanar.fundacionhuellas.modelo.AdapterListBoys;
import com.nitrocanar.fundacionhuellas.modelo.ListBoys;
import com.nitrocanar.fundacionhuellas.modelo.Ninios;

import java.util.ArrayList;

public class ListBoysActivity extends AppCompatActivity {

    private ListView lvLista;
    private AdapterListBoys adapterListBoys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_boys);

        getSupportActionBar().hide();

        lvLista = findViewById(R.id.lvListBoys);

        ListBoys listBoys = new ListBoys();

        ArrayList<Ninios> list = new ArrayList<>(listBoys.bringData());

        Toast.makeText(this, "" + list.get(0).getNinNombre(), Toast.LENGTH_SHORT).show();

        adapterListBoys = new AdapterListBoys(this,  list);

        lvLista.setAdapter(adapterListBoys);


    }
}
