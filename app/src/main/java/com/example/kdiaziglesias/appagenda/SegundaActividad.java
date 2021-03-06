package com.example.kdiaziglesias.appagenda;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kdiaziglesias.appagenda.R;
//Lo tuve que hacer de nuevo porque mi anterior progama MiPriopioApp no me subia los commits.
public class SegundaActividad extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        EditText out = (EditText)findViewById(R.id.pnombre3);
        EditText out2 = (EditText)findViewById(R.id.ptelefono2);


        Button botonok = (Button)findViewById(R.id.bok);

        Button botelimina = (Button)findViewById(R.id.beliminar);


        botelimina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                EditText text = (EditText) findViewById(R.id.pnombre3);
                EditText text2 = (EditText) findViewById(R.id.ptelefono2);

                String salutation="";
                String enterName = text.getText().toString();
                String enterTelefono = text2.getText().toString();

                salutation = getResources().getString(R.string.elimino)+salutation+" "+ enterName+" "+enterTelefono;

                Intent intento = new Intent(SegundaActividad.this,BorraAgenda.class);
                intento.putExtra("salutation",salutation);
                startActivityForResult(intento,1);



            }
        });


        botonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText text = (EditText) findViewById(R.id.pnombre3);
                EditText text2 = (EditText) findViewById(R.id.ptelefono2);
                EditText dentro =(EditText) findViewById(R.id.pnombre2);






                if ("".equals(text.getText().toString())) {

                    String msg = getResources().getString(R.string.ok);

                    showToast("Te falta el nombre ");

                    return;
                }


                if ("".equals(text2.getText().toString())) {

                    String msg = getResources().getString(R.string.ok);

                    showToast("Te falta el telefono ");

                    return;
                }

                String enterName = text.getText().toString();
                String ponerTelefono = text2.getText().toString();


                Intent intento = new Intent(SegundaActividad.this,Agenda.class);
                intento.putExtra("salutation",enterName);
                startActivityForResult(intento,1);


            }
        });




    }
    public void showToast(String msg){

        Context contexto = getApplicationContext();
        int duracion = Toast.LENGTH_SHORT;
        Toast tostada = Toast.makeText(contexto,msg,duracion);
        tostada.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.segunda_actividad, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
