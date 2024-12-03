package com.merlita.listviewclase;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.merlita.*;
import com.merlita.listviewclase.classes.Titular;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    ListView lv;
    AdaptadorTitulares adaptadorTitulares;
    private final Titular[] datos =
            new Titular[]{
                    new Titular("Título 1", "Subtítulo largo 1"),
                    new Titular("Título 2", "Subtítulo largo 2"),
                    new Titular("Título 3", "Subtítulo largo 3"),
                    new Titular("Título 4", "Subtítulo largo 4"),
                    //...
                    new Titular("Título 15", "Subtítulo largo 15")};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listView);
        adaptadorTitulares = new AdaptadorTitulares(this, datos);

/*
        final String[] datos =
                new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5","Elem2","Elem3","Elem4",
                        "Elem5","Elem2","Elem3","Elem4","Elem5","Elem2","Elem3","Elem4","Elem5",
                        "Elem2","Elem3","Elem4","Elem5","Elem2","Elem3","Elem4","Elem5"};

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, datos);


*/
        lv.setAdapter(adaptadorTitulares);
        //lv.addView(new Button());

    }
}

class AdaptadorTitulares extends ArrayAdapter<Titular> {
    Titular[] datos;
    public AdaptadorTitulares(Context context, Titular[] datos) {
        super(context, R.layout.layout, datos);
        this.datos = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.layout, null);

        TextView lblTitulo = (TextView)item.findViewById(R.id.tvTitulo);
        lblTitulo.setText(datos[position].getTitle());

        TextView lblSubtitulo = (TextView)item.findViewById(R.id.tvSubTitulo);
        lblSubtitulo.setText(datos[position].getSubtitle());

        return(item);
    }

}
