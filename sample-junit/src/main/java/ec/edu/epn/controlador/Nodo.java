package ec.edu.epn.controlador;

public class Nodo {

    private Viaje viaje;
    private Nodo enlace;

    public Nodo() {
        this.viaje = new Viaje();
        this.enlace = new Nodo();
    }

    public Nodo(Viaje viaje) {
        this.viaje = viaje;
        this.enlace = null;
    }

    public Nodo(Viaje viaje, Nodo enlace) {
        this.viaje = viaje;
        this.enlace = enlace;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setVIaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }

}
