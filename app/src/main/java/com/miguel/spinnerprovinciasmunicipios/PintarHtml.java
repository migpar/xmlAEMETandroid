package com.miguel.spinnerprovinciasmunicipios;

import java.util.List;

public class PintarHtml {

    private static String inicioHTML = "<!DOCTYPE html>" + "<html lang='en'>" + "<head>"
            + "    <meta charset='UTF-8'>"
            + "    <meta name='viewport' content= 'width=device-width, initial-scale=1.0'>"
            + "    <title>Tabla Covid</title>" + "</head>" + "<body>" + "";
    private static String finalHTML = "</body>" + "</html>";


    public static String crearHTML(Localidad l) {
        List<Dia> lista = l.getPrediccion();
        String tabla = "<table border='2'>";
        tabla += "<tr>" + "<td style = 'background-color: hsl(220, 100%, 50%)'>" + "Fecha" + "</td>"
                + "<td style = 'background-color: hsl(165, 100%, 50%)'>" + "Temperatura Maxima" + "</td>" +
                "<td style = 'background-color: hsl(165, 100%, 50%)'>" + "Temperatura Minima" + "</td></tr>";

        for (int i = 0; i < lista.size(); i++) {
            tabla += "<tr>";
            tabla += "<td style = 'background-color: hsl(181, 100%, 50%)'>" + lista.get(i).getFecha() + "</td>";
            tabla += "<td style = 'background-color: hsl(63, 100%, 83%)'>" + lista.get(i).getTemperatura().getMaxima() + "</td>";
            tabla += "<td style = 'background-color: hsl(63, 100%, 83%)'>" + lista.get(i).getTemperatura().getMinima() + "</td></tr>";
        }
        tabla += "</table>";
        return inicioHTML + tabla + finalHTML;
    }
}
