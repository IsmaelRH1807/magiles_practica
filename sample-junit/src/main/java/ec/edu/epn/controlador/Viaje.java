package ec.edu.epn.controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Viaje {

    private String indiceViaje, origen, destino, conductor, auto, placa, horaSalida, horaLlegada;
    private Date fecha;
    private int total_asientos, total_asientos_disponibles, precio;

    public String getConductor() {
        return conductor;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Viaje() {

    }

    public Viaje(String indiceViaje, String origen, String destino, Date fecha, int total_asientos, int total_asientos_disponibles, int precio, String conductor, String auto, String placa,String horaSalida, String horaLlegada) {
        this.indiceViaje = indiceViaje;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.total_asientos = total_asientos;
        this.total_asientos_disponibles = total_asientos_disponibles;
        this.precio = precio;
        this.conductor = conductor;
        this.auto = auto;
        this.placa = placa;
        this.horaLlegada  = horaLlegada;
        this.horaSalida = horaSalida;
    }

    public Viaje(String origen, String destino, String fecha, String hora, int total_asientos, int precio) {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        this.origen = origen;
        this.destino = destino;
        this.total_asientos = this.total_asientos_disponibles = total_asientos;
      
        this.precio = precio;
        try {
            this.fecha = sd.parse(fecha + " " + hora);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar la fecha!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getIndiceViaje() {
        return indiceViaje;
    }

    public void setIndiceViaje(String indiceViaje) {
        this.indiceViaje = indiceViaje;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date fechaClase() {
        return this.fecha;
    }

    public String getFecha() {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        return sd.format(this.fecha);
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTotal_asientos() {
        return total_asientos;
    }

    public void setTotal_asientos(int total_asientos) {
        this.total_asientos = total_asientos;
    }

    public int getTotal_asientos_disponibles() {
        return total_asientos_disponibles;
    }

    public void setTotal_asientos_disponibles(int total_asientos_disponibles) {
        this.total_asientos_disponibles = total_asientos_disponibles;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
    public void bajarDisponibilidad(int boletos){
        if (boletos <= this.total_asientos_disponibles) {
            for (int i = 1; i <= boletos; i++) {
                this.total_asientos_disponibles -= 1;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay suficientes asientos!");
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        return this.indiceViaje + "++" + this.origen + "++" + this.destino
                + "++" + sd.format(this.fecha) + "++" + this.total_asientos + "++"
                + this.total_asientos_disponibles + "++" + this.precio + "++"
                + this.conductor + "++" + this.auto + "++" + this.placa + "++" + this.horaSalida + "++" + this.horaLlegada + "++" + "{}";
    }

    
    

}
