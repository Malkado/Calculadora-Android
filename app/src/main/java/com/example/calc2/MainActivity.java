package com.example.calc2;

import android.content.Intent;
import java.lang.String;
import android.util.Log;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    TextView exibir2;
    TextView exibir1;
    public static final String exibir="Exibir";
    int id = 0;
    String aux ;
    String res="0";
    String campo1,campo2;
    double resp;
    protected static String valor1, valor2;


    protected static final String Categoria = "Calculadora";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_calculadora);
        exibir2 = findViewById(R.id.view);
        exibir1 = findViewById(R.id.entrada);

        Log.i(Categoria,getLocalClassName()+".onCreate() chamado:"+ savedInstanceState);

        exibir1.setText("0");
        campo1=exibir1.getText().toString();
        campo2=exibir2.getText().toString();


    }
    public void enviar(View v) {
        Toast.makeText(this, "função funcionando!", Toast.LENGTH_SHORT).show();
        valor1=exibir1.getText().toString();
        valor2=exibir2.getText().toString();
        Intent it = new Intent(this, Tela2.class);
        it.putExtra("Valor1", valor1);
        it.putExtra("Valor2", valor2);
        startActivity(it);

        /*Bundle bundle= new Bundle();
            espaco=" = ";
            valor2=exibir2.getText().toString();
            valor1=exibir1.getText().toString();
             enviar = valor2 +espaco+ valor1;
            bundle.putString("enviar", enviar);
            it.putExtras(bundle);*/

    }

    //ESCREVER NUMERO
    public void AddNumero(View v) {
        String ex1 = exibir1.getText().toString();
        String numero = ((TextView) v).getText().toString();
        if (ex1.equals("0")) {
            exibir1.setText("");
            exibir1.setText(numero);

        } else if (ex1==res) {
            exibir2.setText("");
            exibir1.setText("");
            exibir1.setText(numero);




        }
        else {
            exibir1.setText(exibir1.getText() + numero);
        }

    }

    //ESCREVER SINAL +
    public void adic(View v) {
        aux = exibir1.getText().toString();
        if (aux != null) {
            exibir1.setText("");
            id = 8;
        }else {

            Toast.makeText(this, "não existe valores para calcular", Toast.LENGTH_SHORT).show();


        }
    }

    //ESCREVER SINAL *
    public void multi(View v) {
        aux = exibir1.getText().toString();
        if (aux != null) {

            exibir1.setText("");
            id = 9;
        } else {

            Toast.makeText(this, "não existe valores para calcular", Toast.LENGTH_SHORT).show();


        }
    }

    //ESCREVER SINAL /
    public void div(View v) {
        aux = exibir1.getText().toString();
            if (aux != null) {

                exibir1.setText("");
                id = 10;
            } else {

                Toast.makeText(this, "não existe valores para calcular", Toast.LENGTH_SHORT).show();

            }
        }

    //ESCREVER SINAL -
    public void sub(View v) {
        aux = exibir1.getText().toString();
        if (aux != null) {

            exibir1.setText("");
            id = 11;
        } else {

            Toast.makeText(this, "não existe valores para calcular", Toast.LENGTH_SHORT).show();


        }
    }

    //FUNÇÃO PRIMÁRIA "FATORIAL"
    public void fatorial(View v) {
        aux = exibir1.getText().toString();
        double aux2 = Double.parseDouble(aux);
        if (aux != null) {

            exibir1.setText(exibir1.getText() + "!");
            id = 1;

        } else {

            Toast.makeText(this, "não existe valores para calcular", Toast.LENGTH_SHORT).show();
        }

    }

    //FUNÇÃO PRIMÁRIA "RAIZ"
    public void raiz(View v) {
        aux = exibir1.getText().toString();
        if (aux != null) {
            if (aux != "0") {
                exibir1.setText("√" + exibir1.getText());
                id = 2;
            } else {

                Toast.makeText(this, "não existe valores para calcular", Toast.LENGTH_SHORT).show();

            }
        }
    }

    //FUNÇÃO PRIMÁRIA "POTÊNCIA"
    public void pontencia(View v) {
        aux = exibir1.getText().toString();
        if (aux != null) {

            exibir1.setText("");
            id = 3;
        } else {

            Toast.makeText(this, "não existe valores para calcular", Toast.LENGTH_SHORT).show();

        }
    }

    //FUNÇÃO PRIMÁRIA "SENO"
    public void seno(View v) {
        if (exibir1 != null) {
            aux=exibir1.getText().toString();
            exibir1.setText("SEN "+exibir1.getText() + "°");

            id = 4;
        } else {

            exibir2.setText("ERRO!!");

        }

    }

    //FUNÇÃO PRIMÁRIA "TANGENTE"
    public void tangente(View v) {
        if (exibir1 != null) {
            aux=exibir1.getText().toString();
            exibir1.setText("TAN "+exibir1.getText() + "°");

            id = 5;
        } else {

            Toast.makeText(this, "não existe valores para calcular", Toast.LENGTH_SHORT).show();

        }
    }

    //FUNÇÃO PRIMÁRIA "COSSENO"
    public void cos(View v) {
        if (exibir1 != null) {
            aux=exibir1.getText().toString();
            exibir1.setText("COS "+exibir1.getText() + "°");

            id = 6;
        } else {

            Toast.makeText(this, "não existe valores para calcular", Toast.LENGTH_SHORT).show();

        }
    }
    public void porcent(View v) {
        aux= exibir1.getText().toString();
        if(aux!=null){
            exibir1.setText("");
            id=7;
        }
    }

    //FUNÇÃO IGUALDADE+ FUNÇÃO SECUNDÁRIA DAS OPERAÇÕES
    public void igualdade(View v) {

        if(id==1) {

            if (aux.equals("0")) {

                exibir2.setText(exibir1.getText());
                exibir1.setText("1");

            } else {

                double valor = Double.parseDouble(aux);
                double f = valor;


                while (valor > 1) {
                    f = f * (valor - 1);
                    valor--;

                }

                exibir2.setText(exibir1.getText());
                exibir1.setText("" + f);
                res = String.valueOf(f);
                Log.i(Categoria, getClassName()+".Calculo Fatorial foi chamado com o valor :"+valor);
                Log.i(Categoria, getClassName()+"Resultado do cálculo Fatorial é: "+res  );
                id = 0;
                aux="0";
            }
        }else if(id==2) {


                double num = Double.parseDouble(aux);
                resp = Math.sqrt(num);

            exibir2.setText(exibir1.getText());
            exibir1.setText("" + resp);
            res = String.valueOf(resp);
            Log.i(Categoria, getClassName()+".Calculo da Raiz foi chamado com o valor :"+num);
            Log.i(Categoria, getClassName()+"Resultado do cálculo da Raiz é: "+res  );
            id = 0;
            aux="0";
        }else if(id==3){
                if (exibir1.equals("")) {
                    exibir2.setText("ERRO!");

                } else {
                    double base = Double.parseDouble(aux);
                    double expo = Double.parseDouble(exibir1.getText().toString());
                    double equa = Math.pow(base, expo);
                    exibir2.setText(""+base+"^"+expo);
                    exibir1.setText("" + equa);
                    res = String.valueOf(equa);
                    id = 0;
                    aux="0";

                }
        }else if(id==4){

                double aux_s = Double.parseDouble(aux);
                double rad = Math.toRadians(aux_s);
                resp = Math.sin(rad);

                exibir2.setText(exibir1.getText());
                exibir1.setText("" + resp);
            res = String.valueOf(resp);
            Log.i(Categoria, getClassName()+".Calculo do Seno foi chamado com o valor :"+aux_s);
            Log.i(Categoria, getClassName()+"Resultado do cálculo do Seno é: "+res  );

            id = 0;
            aux="0";

        }else if(id==5){

                double aux_t = Double.parseDouble(aux);
            double rad = Math.toRadians(aux_t);
                double result = Math.tan(rad);
                exibir2.setText(exibir1.getText());
                exibir1.setText("" + result);
            res = String.valueOf(result);
            Log.i(Categoria, getClassName()+".Calculo da Tangente foi chamado com o valor :"+aux_t);
            Log.i(Categoria, getClassName()+"Resultado do cálculo da Tangente é: "+res  );
            id = 0;
            aux="0";

        }else if(id==6) {

                double aux_c = Double.parseDouble(aux);
            double rad = Math.toRadians(aux_c);
                double result2 = Math.cos(rad);
                exibir2.setText(exibir1.getText());
                exibir1.setText("" + result2);
            res = String.valueOf(result2);
            Log.i(Categoria, getClassName()+".Calculo do Cosseno foi chamado com o valor :"+aux_c);
            Log.i(Categoria, getClassName()+"Resultado do cálculo do Cosseno é: "+res  );
            id = 0;
            aux="0";

        }else if (id==7){

            double porcent=Double.parseDouble(aux);
            double aux2 = Double.parseDouble(exibir1.getText().toString());
            double calc_porcent=(porcent/100)*aux2;
            exibir2.setText(""+porcent+"% de" + aux2);
            exibir1.setText(""+ calc_porcent);
            res = String.valueOf(calc_porcent);
            Log.i(Categoria, getClassName()+".Porcentagem chamada com os valores :"+porcent+" e "+ aux2);
            Log.i(Categoria, getClassName()+"Resultado do cálculo de porcentagem é: "+res  );
            id = 0;
            aux="0";


        }else if (id==8){
            String aux2;
            aux2=exibir1.getText().toString();
            double num1,num2;
            num1=Double.parseDouble(aux);
            num2=Double.parseDouble(aux2);
            double calc= num1+num2;
            exibir2.setText(aux +"+"+aux2);
            exibir1.setText(""+calc);
            Log.i(Categoria, getClassName()+".Soma foi chamada com os valores :"+num1+ " e "+ num2);
            Log.i(Categoria, getClassName()+"O resultado da soma é: "+calc  );
            id=0;
            aux="0";

        }else if (id==9){
            String aux2;
            aux2=exibir1.getText().toString();
            double num1,num2;
            num1=Double.parseDouble(aux);
            num2=Double.parseDouble(aux2);
            double calc= num1*num2;
            exibir2.setText(aux +"*"+aux2);
            exibir1.setText(""+calc);
            Log.i(Categoria, getClassName()+".Multiplicação foi chamada com os valores :"+num1+ " e "+ num2);
            Log.i(Categoria, getClassName()+"O resultado da Multiplicação é: "+calc  );
            id=0;
            aux="0";

        }else if (id==10){
            String aux2;
            aux2=exibir1.getText().toString();
            double num1,num2;
            num1=Double.parseDouble(aux);
            num2=Double.parseDouble(aux2);
            double calc= num1/num2;
            exibir2.setText(aux +"/"+aux2);
            exibir1.setText(""+calc);
            Log.i(Categoria, getClassName()+".Divisão foi chamada com os valores :"+num1+ " e "+ num2);
            Log.i(Categoria, getClassName()+"O resultado da Divisão é: "+calc  );
            id=0;
            aux="0";


        }else if (id==11){
            String aux2;
            aux2=exibir1.getText().toString();
            double num1,num2;
            num1=Double.parseDouble(aux);
            num2=Double.parseDouble(aux2);
            double calc= num1-num2;
            exibir2.setText(aux +"-"+aux2);
            exibir1.setText(""+calc);
            Log.i(Categoria, getClassName()+".Subtração foi chamada com os valores :"+num1+ " e "+ num2);
            Log.i(Categoria, getClassName()+"O resultado da Subtração é: "+calc );
            id=0;
            aux="0";

        }

    }



//LIMPA TELA

    public void clear(View v) {

        exibir1.setText("0");
        exibir2.setText("");
        id=0;
        aux="";
    }

    //ADICIONA O PONTO NO EXIBIR1
    public void ponto(View v) {
        if (exibir1.getText() != "0") {
            exibir1.setText(exibir1.getText() + ".");
        } else {
            exibir2.setText("ERRO!");
        }
    }

    //TRANSFORMA O VALOR DO EXIBIR 1 EM NEGATIVO
    public void negative(View v) {
        if (exibir1.getText() != "0") {
            double num = Double.parseDouble(exibir1.getText().toString());
            num = num * (-1);
            String tela = String.valueOf(num);
            exibir1.setText(tela);
        } else {
            exibir2.setText("ERRO!");
        }
    }


    protected void onStart(){
        super.onStart();
        Log.i(Categoria, getClassName()+".onStart() camado.");
        exibir1.setText(campo1);
        exibir2.setText(campo2);

    }
    protected void onRestart(){
        super.onRestart();
        Log.i(Categoria, getClassName()+".onRestart() camado.");
        exibir1.setText(campo1);
        exibir2.setText(campo2);

    }
    protected void onResume(){
        super.onResume();
        Log.i(Categoria, getClassName()+".onResume() camado.");

    }
    protected void onPause(){
        super.onPause();
        Log.i(Categoria, getClassName()+".onPause() camado.");
        campo1= exibir1.getText().toString();
        campo2= exibir2.getText().toString();
    }
    protected void onStop(){
        super.onStop();
        Log.i(Categoria, getClassName()+".onStop() camado.");
        campo1= exibir1.getText().toString();
        campo2= exibir2.getText().toString();

    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i(Categoria, getClassName()+".onDestroy() camado.");
    }
    private String getClassName(){
        String s = getClass().getName();
        return s.substring(s.lastIndexOf("."));
    }
}
