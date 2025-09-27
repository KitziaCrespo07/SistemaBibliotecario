package persistencia;

import modelo.Libro;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    private static final String ARCHIVO = "data/libros.txt";

    // Guardar lista de libros en texto plano
    public static void guardarLibros(List<Libro> listaLibros) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Libro libro : listaLibros) {
                // Guardamos cada libro en una línea: id;titulo;autor;disponible
                bw.write(libro.getId() + ";" 
                        + libro.getTitulo() + ";" 
                        + libro.getAutor() + ";" 
                        + libro.isDisponible());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar libros: " + e.getMessage());
        }
    }

    // Cargar lista de libros desde texto plano
    public static List<Libro> cargarLibros() {
        List<Libro> lista = new ArrayList<>();
        File f = new File(ARCHIVO);
        if (!f.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    String id = partes[0];
                    String titulo = partes[1];
                    String autor = partes[2];
                    boolean disponible = Boolean.parseBoolean(partes[3]);

                    Libro libro = new Libro(id, titulo, autor, disponible);
                    lista.add(libro);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar libros: " + e.getMessage());
        }

        return lista;
    }
}
