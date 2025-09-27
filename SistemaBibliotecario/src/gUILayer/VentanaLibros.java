package gUILayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Libro;
public class VentanaLibros extends JFrame implements ActionListener {
	private JPanel panelCreacion;	//PANEL DE CREACION DE UN USUARIO
	
	private JPanel panelContenido;	//PANEL GENERAL DE LA DERECHA(BUSCAR, PANEL VERDE)
	private JPanel panelSubContenido;	//PANEL VERDE
	
	private JPanel superior;	//PANEL SUPERIOR BLANCO, DONDE ESTA EL BUSCADOR
	
	private JButton btnNuevoL, btnModL, btnEl, btnCargarImg;
	private JTextField tfTitulo, tfAutor, tfGenero, tfEditorial, tfISBN, tfDescripcion, tfCantidad, tfBuscar;
	private JScrollPane scroll;
	
	private JButton btnBuscar, 	btnGuardar;
	private ImageIcon portadaTemp = new ImageIcon("Imagenes/PortadaDesconocida.jpg");	//PONE POR DEFECTO ESTA PORTADA
	
	public VentanaLibros(){
		super("Administracion de Libros");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initComponents();
		setVisible(true);
	}
	
	public void initComponents(){
		contenidoPrincipal();	//PARTE VERDE
		contenidoIzquierda();	//PARTE AMARILLA
	}
	

	private void contenidoIzquierda() {
		//CONFIUGRANDO PANEL NARANJA
		panelCreacion = new JPanel(new GridBagLayout());
		panelCreacion.setBackground(Color.orange);
		panelCreacion.setLayout(new GridBagLayout());
		
		//BOTON CARGAR PORTADA
		btnCargarImg = new JButton("Cargar Portada");
		btnCargarImg.addActionListener(this);
		//BOTON GUARDAR LIBRO
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		
		//TEXTFIELD NECESARIOS
		tfBuscar = new JTextField(5);
		tfTitulo = new JTextField(5);
		tfAutor = new JTextField(5);
		tfGenero = new JTextField(5);
		tfEditorial = new JTextField(5);
		tfISBN = new JTextField(5);
		tfDescripcion = new JTextField(5);
		tfCantidad = new JTextField(5);
		
		//GRIDBAGCONSTRAINT PARA ORDENAR LOS TEXTFIELD Y LABEL
		GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx=0;
	        gbc.gridy=0;
	        gbc.gridwidth = 1;
	        gbc.gridheight = 1;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.insets = new Insets(5, 5, 5, 5);

	    //AGREGANDO LABELS
		panelCreacion.add(new JLabel("Agrega un nuevo libro"), gbc);
        gbc.gridy++;		
		panelCreacion.add(new JLabel("Titulo:"), gbc);
        gbc.gridy++;
        panelCreacion.add(new JLabel("Autor"), gbc);
        gbc.gridy++;
		panelCreacion.add(new JLabel("Genero:"), gbc);
        gbc.gridy++;
    	panelCreacion.add(new JLabel("Editorial:"), gbc);
        gbc.gridy++;
        panelCreacion.add(new JLabel("ISBN:"), gbc);
        gbc.gridy++;
		panelCreacion.add(new JLabel("Descripcion:"), gbc);
        gbc.gridy++;		
		panelCreacion.add(new JLabel("Cantidad:"), gbc);
        gbc.gridy++;		
        
		//AGREGA BOTON CARGAR IMAGEN
		panelCreacion.add(btnCargarImg, gbc);
        gbc.gridy++;
        
        //AGREGA BOTON GUARDAR
		panelCreacion.add(btnGuardar, gbc);
        gbc.gridx=1;
        gbc.gridy=1;     
		
        //AGREGA TEXTFIELS
        panelCreacion.add(tfTitulo,gbc);
		gbc.gridy++;	
		panelCreacion.add(tfAutor,gbc);
		gbc.gridy++;	
		panelCreacion.add(tfGenero, gbc);
		gbc.gridy++;
		panelCreacion.add(tfEditorial, gbc);
		gbc.gridy++;	
		panelCreacion.add(tfISBN, gbc);
		gbc.gridy++;	
		panelCreacion.add(tfDescripcion, gbc);
		gbc.gridy++;		
		panelCreacion.add(tfCantidad, gbc);
		gbc.gridy++;
		add(panelCreacion, BorderLayout.WEST);
		
	}

	public void contenidoPrincipal(){
		//PANEL GENERAL DE LA DERECHA(BUSCAR, PANEL VERDE)
		panelContenido = new JPanel();
		panelContenido.setLayout(new BorderLayout());
		
		//PANEL VERDE
		panelSubContenido = new JPanel();
		panelSubContenido.setLayout(new BoxLayout(panelSubContenido, BoxLayout.Y_AXIS));
		panelSubContenido.setBackground(Color.green);
		
		//BOTON DE BUSCAR, LUPA
		btnBuscar = new JButton();
		btnBuscar.setIcon(new ImageIcon("Imagenes/lupa4.png"));
		btnBuscar.setBackground(Color.white);
		btnBuscar.setBorder(null);
		btnBuscar.setToolTipText("Haz click para buscar un libro");
		btnBuscar.addActionListener(this);
		tfBuscar = new JTextField(50);			//TEXTFIELD PARA ESCRIBIR EL TEXTO DE BUSQUEDA
		
		//PANEL SUPERIOR BLANCO, DONDE ESTA EL BUSCADOR
		superior = new JPanel();
		superior.setBackground(Color.white);
		superior.add(btnBuscar);
		superior.add(tfBuscar);					

		//SCROLL PARA LA PANTALLA VERDE
		scroll=new JScrollPane(panelSubContenido);
		panelContenido.add(superior, BorderLayout.NORTH);		
		panelContenido.add(scroll, BorderLayout.CENTER);			
		add(panelContenido, BorderLayout.CENTER);
		
		//AGREGE SOLO UNOS LIBROS PARA PRUEBA
		panelSubContenido.add(new JLabel("Titulos con los que contamos:"));
		panelSubContenido.add(new itemLibro());
		panelSubContenido.add(new itemLibro());
	}
	
	public void actionPerformed(ActionEvent e){
		//En caso de darle click a buscar
		if(e.getSource()==btnBuscar){
			//Falta por programar
			System.out.println("BUSCANDO...");
		}
		//En caso de darle click a cargar imagen
		else if(e.getSource()==btnCargarImg){
			//Ya esta bien programado
			JFileChooser jfcAbrir = new JFileChooser();
			jfcAbrir.setDialogTitle("Cargar una imagen");
			jfcAbrir.setFileSelectionMode(JFileChooser.FILES_ONLY);
			FileNameExtensionFilter filtroImg = new FileNameExtensionFilter("Imagenes", "png", "jpg", "webp");

			jfcAbrir.setFileFilter(filtroImg);	//Por defecto
			jfcAbrir.addChoosableFileFilter(filtroImg);

			
			if(jfcAbrir.showOpenDialog(this) !=JFileChooser.CANCEL_OPTION){
				File Archivo = jfcAbrir.getSelectedFile();
				System.out.println(Archivo.getName());
				
		        portadaTemp = new ImageIcon(Archivo.getAbsolutePath());
		        JOptionPane.showMessageDialog(null, "Imagen cargada con exito");
			}
		}
		//En caso de darle click a guardar
		else if(e.getSource()==btnGuardar){
			//Ya esta bien programado
			Libro nuevoLibro = new Libro(tfTitulo.getText(), tfGenero.getText(), tfDescripcion.getText(), tfAutor.getText(), tfEditorial.getText(), tfISBN.getText(), Integer.parseInt(tfCantidad.getText()), portadaTemp);
			portadaTemp = new ImageIcon("Imagenes/PortadaDesconocida.jpg");	//Esto es para poner la foto generica en el siguiente libro
			panelSubContenido.add(new itemLibro(nuevoLibro));
		}
	}
	
}
