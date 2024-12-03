package com.merlita.listviewclase;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    TextView tv;
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
        tv = findViewById(R.id.textView);
        adaptadorTitulares = new AdaptadorTitulares(this, datos);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Alternativa 1:
                /*String opcionSeleccionada =
                        ((Titular)adapterView.getItemAtPosition(i)).getTitle();
                tv.setText(opcionSeleccionada);*/

                //Alternativa 2:
                String opcionSeleccionada =
                      ((TextView)view.findViewById(R.id.tvTitulo))
                          .getText().toString();
                tv.setText(opcionSeleccionada);

            }
        });


        lv.setAdapter(adaptadorTitulares);

    }
}

class AdaptadorTitulares extends ArrayAdapter<Titular> {
    Titular[] datos;
    public AdaptadorTitulares(Context context, Titular[] datos) {
        super(context, R.layout.layout, datos);
        this.datos = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        ViewHolder contenedor;

        if(item == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.layout, null);
            contenedor = new ViewHolder();
            contenedor.title =(TextView)item.findViewById(R.id.tvTitulo);
            contenedor.subtitle = (TextView)item.findViewById(R.id.tvSubTitulo);
            item.setTag(contenedor);
        }else{
            contenedor = (ViewHolder)item.getTag();
        }

        contenedor.title.setText(datos[position].getTitle());
        contenedor.subtitle.setText(datos[position].getSubtitle());

        return(item);
    }

    class ViewHolder{
        TextView title, subtitle;
    }
}
