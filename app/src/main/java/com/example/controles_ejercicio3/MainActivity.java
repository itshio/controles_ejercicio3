package com.example.controles_ejercicio3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvnombre,tvapellidos,tvestado,tvprovincia,tvedad;
    Spinner spprovincia;
    RadioGroup rgestado;
    CheckBox cbterminos;
    ImageButton papelera,anterior,siguiente;
    EditText etnombre,etapellidos,etedad;
    Button btaceptar;
    ArrayList<Persona>lista_personas= new ArrayList<Persona>();
    int indice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btaceptar=(Button)findViewById(R.id.btn_aceptar);

        tvnombre=(TextView)findViewById(R.id.txt_nombre);
        tvapellidos=(TextView)findViewById(R.id.txt_apellidos);
        tvedad=(TextView)findViewById(R.id.txt_edad);
        tvestado=(TextView)findViewById(R.id.txt_estado);
        tvprovincia=(TextView)findViewById(R.id.txt_provincia);

        spprovincia= (Spinner)findViewById(R.id.sp_provincias);

        rgestado=(RadioGroup)findViewById(R.id.rg_estadocivil);

        cbterminos=(CheckBox)findViewById(R.id.cb_terminos);

        papelera=(ImageButton)findViewById(R.id.img_papelera);
        anterior=(ImageButton)findViewById(R.id.img_anterior);
        siguiente=(ImageButton)findViewById(R.id.img_siguiente);

        etnombre=(EditText) findViewById(R.id.et_nombre);
        etapellidos=(EditText) findViewById(R.id.et_apellidos);
        etedad=(EditText) findViewById(R.id.et_edad);

        String [] provincias = {"","Cadiz","Almeria","Sevilla","Granada","Cordoba","Jaen","Malaga","Huelva"};
        ArrayAdapter<String> adaptadorprovincias = new ArrayAdapter<String>(this,
                R.layout.item_spinner,provincias);
        spprovincia.setAdapter(adaptadorprovincias);




    }//On CREATE

    public void activable (View view) {

        if(cbterminos.isChecked()){
            btaceptar.setEnabled(true);
        }else{
            btaceptar.setEnabled(false);
        }
    }


    public void aceptar (View view){

        String cajanombre=etnombre.getText().toString();
        String cajaapellidos=etapellidos.getText().toString();
        String cajaedad=etedad.getText().toString();
        String spprovincias= spprovincia.getSelectedItem().toString();
        int idestado=rgestado.getCheckedRadioButtonId();


        if(cbterminos.isChecked()) {






           if(cajanombre.equals("")||cajaapellidos.equals("")|| cajaedad.equals("")||spprovincias.equals("")||idestado==-1){

                toast("Faltan campos obligatorios por rellenar");

            }else{

                RadioButton rbcopia= (RadioButton)findViewById(idestado);
                String estado= rbcopia.getText().toString();
                int edad = Integer.parseInt(cajaedad);
                Persona p = new Persona (cajanombre,cajaapellidos,spprovincias,estado,edad);
                lista_personas.add(p);
                limpiador();

            }


        }else{

            toast("Acepta los terminos");

        }





    }


    public void papelera (View view){

        limpiador();

    }

    public void anterior (View view){

        if(indice>0){
            indice--;
            cargarpersona();


        }else{

            toast("Este es el primero");

        }

    }

    public void siguiente (View view){

        if(indice<lista_personas.size()-1){

            indice++;
            cargarpersona();

        }else{

            indice=0;
            cargarpersona();

        }


    }


private void toast (String mensaje){

    Toast.makeText(getApplicationContext(), mensaje,
            Toast.LENGTH_LONG).show();

}

private void limpiador (){

    etnombre.setText("");
    etapellidos.setText("");
    etedad.setText("");
    spprovincia.setSelection(0);
    rgestado.clearCheck();
    cbterminos.setChecked(false);





}

private void cargarpersona (){

    Persona p=lista_personas.get(indice);
    tvnombre.setText("Nombre: "+p.getNombre());
    tvapellidos.setText("Apellidos: "+p.getApellido());
    tvedad.setText("Edad: "+p.getEdad());
    tvprovincia.setText("Provincia: "+p.getProvincia());
    tvestado.setText("Estado: "+p.getEstado_civil());



}



}//NO BORRAR
