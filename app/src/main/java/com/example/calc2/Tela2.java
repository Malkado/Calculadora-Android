package com.example.calc2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Tela2 extends MainActivity {
    TextView parte1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        parte1.findViewById(R.id.View1);
            Intent intent=getIntent();
        String valor1= intent.getStringExtra(MainActivity.valor1);
        String valor2= intent.getStringExtra(MainActivity.valor2);
        String exib= valor2+" = "+valor1;
                    parte1.setText(exib);




       /*Intent intent=getIntent();
        Bundle textos= intent.getExtras();
        String recebe=textos.getString("enviar");
        parte1.setText(recebe);*/
    }
}
