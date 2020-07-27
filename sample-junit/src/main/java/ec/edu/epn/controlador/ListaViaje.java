package ec.edu.epn.controlador;

import java.util.LinkedList;
import javax.swing.JOptionPane;

public class ListaViaje {

    private Nodo raiz;

    public ListaViaje() {
        this.raiz = null;
    }

    public ListaViaje(Nodo raiz) {
        this.raiz = raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    private boolean listaVacia() {
        return this.raiz == null;
    }



    public Viaje buscarViaje(String id) {
        boolean b = false;
        Viaje aux = null;
        if (this.listaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay Viajes en la lista!");
            return null;
        } else {
            Nodo p = this.raiz;
            while (p != null) {
                if (p.getViaje().getIndiceViaje().equals(id)) {
                    aux = p.getViaje();
                    b = true;
                    break;
                } else {
                    p = p.getEnlace();
                }
            }
        }
        if (b == false) {
            JOptionPane.showMessageDialog(null, "Viaje no Encontrado", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        return aux;
    }

    public boolean agregarViaje(Viaje nuevo) {
        if (nuevo.getIndiceViaje() == null) {
            nuevo.setIndiceViaje(this.generarIDNuevoViaje());
        }
        boolean b = false;
        if (this.listaVacia()) {
            this.raiz = new Nodo(nuevo);
        } else {
            Nodo p = this.raiz;
            Nodo q = p;
            Nodo r = new Nodo(nuevo);
            while (p != null) {
                if (r.getViaje().getFecha().equals(p.getViaje().getFecha())) {
                    if (r.getViaje().getOrigen().equals(p.getViaje().getOrigen())
                            && r.getViaje().getDestino().equals(p.getViaje().getDestino())) {
                        JOptionPane.showMessageDialog(null, "El Viaje ya se encuentra en la lista!",
                                "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return false;
                    } else if (p == this.raiz) {
                        this.raiz = r;
                        r.setEnlace(p);
                        b = true;
                        break;
                    } else {
                        q.setEnlace(r);
                        r.setEnlace(p);
                        b = true;
                        break;
                    }
                } else if (r.getViaje().fechaClase().before(p.getViaje().fechaClase())) {
                    if (p == this.raiz) {
                        this.raiz = r;
                        r.setEnlace(p);
                        b = true;
                        break;
                    } else {
                        q.setEnlace(r);
                        r.setEnlace(p);
                        b = true;
                        break;
                    }
                } else {
                    q = p;
                    p = p.getEnlace();
                }
            }
            if (b == false) {
                q.setEnlace(r);
            }
        }
        return true;
    }
    
    public boolean bajarDisponibilidad(String indiceViaje, int asientos) {
        Nodo p = this.raiz;
        while (p != null) {
            if (p.getViaje().getIndiceViaje().equals(indiceViaje)) {
                p.getViaje().bajarDisponibilidad(asientos);
                return true;
            } else {
                p = p.getEnlace();
            }
        }
        return false;
    }
    
    public int contarViajes() {
    	Nodo p = this.raiz;
    	int contador = 0;
    	while (p != null) {
    		contador+=1;
            p = p.getEnlace();
        }
    	System.out.println("el numero de viajes es "+contador);
    	return contador;
    	
    }

    public LinkedList<Viaje> listadoViajes() {
        LinkedList<Viaje> aux = new LinkedList<>();
        Nodo p = this.raiz;
        while (p != null) {
            aux.add(p.getViaje());
            p = p.getEnlace();
        }
        return aux;
    }

    public String generarIDNuevoViaje() {
        int num1 = 65;
        int num2 = 90;

        int numAleatorio1 = (int) Math.floor(Math.random() * (num2 - num1) + num1);
        int numAleatorio2 = (int) Math.floor(Math.random() * (num2 - num1) + num1);
        int numA = (int) (Math.random() * 99) + 1;

        return String.valueOf((char) numAleatorio1) + String.valueOf((char) numAleatorio2) + numA;
    }

    @Override
    public String toString() {
        String result = "";
        Nodo aux = this.raiz;
        while (aux != null) {
            Viaje t = aux.getViaje();
            result += t.toString() + "\n";
            aux = aux.getEnlace();
        }
        return result;
    }

}
