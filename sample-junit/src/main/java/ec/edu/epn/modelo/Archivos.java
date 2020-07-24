package ec.edu.epn.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import ec.edu.epn.controlador.ListaViaje;
import ec.edu.epn.controlador.Nodo;
import ec.edu.epn.controlador.Viaje;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
// import modelo.Pasajero;

public class Archivos {

    public boolean guardarArchivo(ListaViaje lista) {
        new SimpleDateFormat("dd/MM/yyyy");
        File f = new File("BaseDatos.txt");
        BufferedWriter bfwriter;
        try {
            if (!f.exists()) {
                f.createNewFile();
                bfwriter = new BufferedWriter(new FileWriter(f, true));
            } else {
                f.delete();
                File n = new File("BaseDatos.txt");
                bfwriter = new BufferedWriter(new FileWriter(n, true));
            }

            Nodo aux = lista.getRaiz();

            while (aux != null) {
                Viaje t = aux.getViaje();
                bfwriter.write(t.toString() + "\n");
                aux = aux.getEnlace();
            }
            bfwriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ListaViaje leerArchivo() {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        File file = new File("BaseDatos.txt");
        if (file.exists() == false) {
            return new ListaViaje();
        }
        ListaViaje lista = new ListaViaje();
        Scanner sc;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                StringTokenizer tk = new StringTokenizer(linea, "++");
                String indiceViaje = tk.nextToken();
                String origen = tk.nextToken();
                String destino = tk.nextToken();
                Date fecha = sd.parse(tk.nextToken());
                int total_asientos = Integer.parseInt(tk.nextToken());
                int disponibles = Integer.parseInt(tk.nextToken());
                int precio = Integer.parseInt(tk.nextToken());
                String conductor = tk.nextToken();
                String auto = tk.nextToken();
                String placa = tk.nextToken();
                String horaSalida = tk.nextToken();
                String horaLlegada = tk.nextToken();
                //ColaPasajeros pasajeros = this.leerPasajeros(tk.nextToken(), total_asientos);
                
                Viaje aux = new Viaje(indiceViaje, origen, destino, fecha, total_asientos, disponibles, precio, conductor, auto, placa, horaSalida, horaLlegada); //pasajeros
                lista.agregarViaje(aux);
            }
            sc.close();
        } catch (FileNotFoundException e) {
//            JOptionPane.showMessageDialog(null, "No se encontró la Base de Datos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

 
}
