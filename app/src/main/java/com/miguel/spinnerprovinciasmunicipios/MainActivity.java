package com.miguel.spinnerprovinciasmunicipios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.List;


public class MainActivity extends AppCompatActivity implements PeticionesRetrofit.Actualizacion {

    List<Provincia> listaProvincias;
    List<Municipio> listaMunicipios;
    Spinner spinnerProvincias;
    Spinner spinnerMunicipios;
    WebView web;
    Button pedir;
    Button reset;
    PeticionesRetrofit.Actualizacion a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerProvincias = (Spinner) findViewById(R.id.spinnerProvincias);
        spinnerMunicipios = (Spinner) findViewById(R.id.spinnerMunicipios);
        web = (WebView) findViewById(R.id.webViewMunicipio);
        pedir = (Button) findViewById(R.id.buttonPedir);
        reset = (Button) findViewById(R.id.buttonReset);
        a = this;

        PeticionesRetrofit.pedirProvincias(this);
        reset.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                spinnerMunicipios.setVisibility(View.VISIBLE);
                spinnerProvincias.setVisibility(View.VISIBLE);
                web.setVisibility(View.INVISIBLE);


            }


        });

    }

    @Override
    public void recuperardatosProvincias(Provinciero p) {
        listaProvincias = p.getProvinciero();
        ArrayAdapter<Provincia> adaptadorProvincias = new ArrayAdapter<Provincia>(this, R.layout.support_simple_spinner_dropdown_item, listaProvincias);
        spinnerProvincias.setAdapter(adaptadorProvincias);
        spinnerProvincias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String provincia = ((Provincia) spinnerProvincias.getSelectedItem()).getNp();
                PeticionesRetrofit.pedirMunicipios(a, provincia);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void recuperardatosMunicipios(Municipiero m) {
        listaMunicipios = m.getMunicipiero();
        ArrayAdapter<Municipio> adaptadorProvincias = new ArrayAdapter<Municipio>(this, R.layout.support_simple_spinner_dropdown_item, listaMunicipios);
        spinnerMunicipios.setAdapter(adaptadorProvincias);

        pedir.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                String codLocalidad = AnalisisDatos.escribirCodigoLocalidad(((Provincia) spinnerProvincias.getSelectedItem()).getCpine(),
                        ((Municipio) spinnerMunicipios.getSelectedItem()).getLi().getCm());
                PeticionesRetrofit.pedirLocalidad(a, codLocalidad);
                spinnerMunicipios.setVisibility(View.INVISIBLE);
                spinnerProvincias.setVisibility(View.INVISIBLE);
                web.setVisibility(View.VISIBLE);


            }


        });
    }

    @Override
    public void recuperardatosLocalidad(Localidad l) {
        String html = PintarHtml.crearHTML(l);
        web.loadData(html, "text/html", "UTF-8");

    }
}