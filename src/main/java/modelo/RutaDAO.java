
package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RutaDAO {
    /*
    RutaDAo va a leer los tres archios: origenes.txt; destinos.txt; rutas.txt
    
    -¿Qué se quiere lograr?
    
    Primero: esta clase debe contener los metedos para listar en los comboBox 
    de vistaMenu la información de las ciudades de origen y destino
    
    Segundo: en base a lo que se seleccione en vistaMenu habráun método que compare
    y determine si la ruta existe o no
    
    
    */
    private File fileOrigenes = new File("src/main/resources/origenes.txt");
    private File fileDestinos = new File("src/main/resources/destinos.txt");
    private File fileRutas = new File("src/main/resources/rutas.txt");
    
    // Método para leer listas (Ciudad-Pais)
    private ArrayList<String> leerArchivoCiudadPais(File archivo) {
        ArrayList<String> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea.trim());
            }
        } catch (IOException e) { e.printStackTrace(); }
        return lista;
    }
    
    //Metodo para obtener la lista de origenes
    public ArrayList<String> obtenerListaOrigenes() {
    ArrayList<String> listaOrigenes = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(fileOrigenes))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            listaOrigenes.add(linea.trim());
        }
    } catch (IOException e) { e.printStackTrace(); }
    
      return listaOrigenes;
    }
    
    //Metodo para obtener la lista de destinos
    public ArrayList<String> obtenerListaDestinos() {
    ArrayList<String> listaOrigenes = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(fileDestinos))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            listaOrigenes.add(linea.trim());
        }
    } catch (IOException e) { e.printStackTrace(); }
    
      return listaOrigenes;
    }


    
    //Metodo para buscar la ruta (comparar origen, destino y devolver la información completa de la ruta)
    public Ruta buscarRuta(String origenSeleccionado, String destinoSeleccionado) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileRutas))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(","); // Separar gracias al formato csv
            
            // Comparamos de destino y origen seleccionados
            if (datos[0].equalsIgnoreCase(origenSeleccionado) && 
                datos[1].equalsIgnoreCase(destinoSeleccionado)) {
                
                // Si coinciden, devolvemos el objeto Ruta con su ID y Precio
                return new Ruta(datos[0], datos[1], datos[2], Double.parseDouble(datos[3]));
            }
        }
    } catch (IOException e) { e.printStackTrace(); }
    
    return null; // Cuando no hay nimguna ruta entre las ciuidades seleccionadas
}

    
}



    

