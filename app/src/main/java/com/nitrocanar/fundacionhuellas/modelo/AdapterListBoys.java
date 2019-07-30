package com.nitrocanar.fundacionhuellas.modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nitrocanar.fundacionhuellas.R;

import java.util.ArrayList;

public class AdapterListBoys extends BaseAdapter {

    Context context;
    ArrayList<Ninios> list;

    public AdapterListBoys(Context context, ArrayList<Ninios> list) {
        this.context = context;
        this.list = new ArrayList<>(list);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ImageView img;
        TextView name, lastName, age;
        Button btnMessage;

        view =  LayoutInflater.from(context).inflate(R.layout.item_list_boys, viewGroup, false);

        img = view.findViewById(R.id.imgBoy);
        name = view.findViewById(R.id.textNombreBoy);
        lastName = view.findViewById(R.id.textApellidoBoy);
        age = view.findViewById(R.id.textEdadBoy);
        btnMessage = view.findViewById(R.id.btnMensaje);

        img.setImageResource(R.drawable.user);
        name.setText(list.get(i).getNinNombre());
        lastName.setText(list.get(i).getNinApellido());
        age.setText(list.get(i).getNinEdad());

        return view;
    }
}
