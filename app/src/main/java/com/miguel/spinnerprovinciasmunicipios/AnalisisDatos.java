package com.miguel.spinnerprovinciasmunicipios;

import android.util.Log;

public class AnalisisDatos {


    public static String escribirCodigoLocalidad(String provincia, String codLocalidad) {
        String localidad = provincia;
        int opcion = codLocalidad.length();
        switch (opcion) {
            case 1:
                localidad += "00" + codLocalidad;
                break;
            case 2:
                localidad += "0" + codLocalidad;
                break;
            case 3:
                localidad += codLocalidad;
                break;
            default:
                break;
        }
        System.out.println(localidad);
        return localidad;
    }
}
