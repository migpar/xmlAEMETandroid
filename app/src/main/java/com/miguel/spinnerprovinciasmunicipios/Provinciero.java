package com.miguel.spinnerprovinciasmunicipios;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;
@Root(name = "consulta_provinciero", strict = false)
public class Provinciero {
    @ElementList
    private List<Provincia> provinciero;

    public List<Provincia> getProvinciero() {
        return provinciero;
    }

    public void setProvinciero(List<Provincia> provinciero) {
        this.provinciero = provinciero;
    }


}
