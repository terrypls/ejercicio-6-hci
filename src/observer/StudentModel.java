package observer;

import java.util.Observable;
import java.util.Observer;

import java.util.HashMap;

class StudentModel extends Observable {
    HashMap<String, String> listado;

    StudentModel() {
        this.listado = new HashMap<>();
    }

    public void add(String x, String y) {
        listado.put(x, y);
        setChanged();
        notifyObservers();
        System.out.println("Added " + x + " " + y);
    }

    public void delete(String id) {
        String nombre = listado.get(id);
        if (nombre == null) {
            System.out.println("No existe el registro");
        } else {
            listado.remove(id);
            setChanged();
            notifyObservers();
            System.out.println("Delete " + id + " " + nombre);
        }
    }

    public void update(String id, String nombre) {
        String original = listado.get(id);
        if (original == null) {
            System.out.println("No existe el registro");
        } else {
            setChanged();
            notifyObservers();
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