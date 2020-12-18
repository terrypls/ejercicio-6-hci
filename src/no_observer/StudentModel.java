package no_observer;

import java.util.*;

class StudentModel {
    HashMap<String, String> listado;

    StudentModel() {
        this.listado = new HashMap<String, String>();
    }

    public void add(String x, String y) {
        listado.put(x, y);
        System.out.println("Added " + x + " " + y);
    }

    public void delete(String id) {
        String nombre = listado.get(id);
        if (nombre == null) {
            System.out.println("No existe el registro");
        } else {
            listado.remove(id);
            System.out.println("Delete " + id + " " + nombre);
        }
    }

    public void update(String id, String nombre) {
        String original = listado.get(id);
        if (original == null) {
            System.out.println("No existe el registro");
        } else {
            listado.replace(id, nombre);
            System.out.println("Update " + id + " " + original + " por " + nombre);
        }
    }

    public String getList() {
        StringBuilder l = new StringBuilder();
        for (String item : listado.keySet()) {
            l.append(item).append("  ").append(listado.get(item)).append("\n");
        }

        return l.toString();
    }

}