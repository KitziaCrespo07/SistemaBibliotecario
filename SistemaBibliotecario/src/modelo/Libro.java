package modelo;

import javax.swing.ImageIcon;

public class Libro {

	private int idLibro;
	private String titulo, genero, descripcion, autor, editorial, ISBN;
	private int cantidadDisponible;
	private static int cantidadTotal;
	private ImageIcon portada;
	
	public Libro(String tit, String gen, String desc, String aut, String edi, String isbn, int cantTotal, ImageIcon port){
		idLibro=generaId();
		titulo = tit;
		genero = gen;
		descripcion = desc;
		autor = aut;
		editorial = edi;
		ISBN = isbn;
		cantidadTotal = cantTotal;
		portada = port;
	}
	
	public Libro(){
		idLibro=generaId();
		titulo="Sin titulo";
		genero="Sin genero";
		descripcion="Sin descripcion";
		autor="Autor desconocido";
		editorial=" Sin editorial";
		ISBN = "Ninguna ISBN";
		cantidadTotal=20;
		portada = new ImageIcon("Imagenes/libro4.webp");
	}
	
	public int getId(){
		return idLibro;
	}
	public void setId(int id){
		idLibro=id;
	}
	
	public String getTitulo(){
		return titulo;
	}
	public void setTitulo(String tit){
		titulo=tit;
	}

	public String getGenero(){
		return genero;
	}
	public void setGenero(String gen){
		genero=gen;
	}
	
	public String getDescripcion(){
		return descripcion;
	}
	public void setDescripcion(String desc){
		descripcion=desc;
	}
	
	public boolean isdiponible(){
		return cantidadDisponible==0;
	}
	
	public int getCantidadTotal(){
		return cantidadTotal;
	}
	public void setCantidadTotal(int can){
		cantidadTotal=can;
	}

	public int getCantidadDisponible(){
		return cantidadDisponible;
	}
	public void setCantidadDisponible(int can){
		cantidadDisponible=can;
	}
	
	public ImageIcon getImageIcon(){
		return portada;
	}
	public void setImageIcon(ImageIcon e){
		portada=e;
	}
	
	public String getAutor(){
		return autor;
	}
	public void setAutor(String s){
		autor=s;
	}

	public String getEditorial(){
		return editorial;
	}
	public void setEditorial(String ed){
		editorial = ed;
	}
	
	public String getISBN(){
		return ISBN;
	}
	public void setISBN(String isbn){
		ISBN = isbn;
	}
	
	public int generaId(){
		return 1;
	}
	
	
}
