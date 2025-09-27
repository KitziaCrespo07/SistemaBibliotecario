package gUILayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import modelo.Libro;
//Esta clase imprime el rectangulo que contiene la foto, datos, boton de mas infromacion, agregar, eliminar

public class itemLibro extends JPanel implements ActionListener {
	private JButton btnDesc;
	private JLabel etiNombre;
	private JButton btnModificar = new JButton();
	private JButton btnEliminar = new JButton();
	private JButton btnDisponibilidad = new JButton();
	private JButton foto;
	
	private JPanel panelFoto;
	private JPanel panelContenido;
	private JPanel panelBotones; 
	
	private static Libro miLibro;	//Libro que representa
	private static int cantidadTotal;
	private ImageIcon portada;
	
	//Recibimos el libro que aplica
	public itemLibro(Libro b){
		miLibro=b;
		btnDesc = new JButton("Mas informacion");
		etiNombre = new JLabel(b.getTitulo());
		foto = new JButton(b.getImageIcon());
		initComponents();
	}

	public itemLibro(){
		miLibro = new Libro();
		btnDesc = new JButton("Mas informacion");
		btnDesc.setToolTipText("Haz click para conocer mas detalles");
		etiNombre = new JLabel("Sin titulo");
		foto = new JButton(new ImageIcon("Imagenes/libro4.webp"));
		initComponents();
	}
	
	
	public void initComponents(){
		setLayout(new BorderLayout());
		foto.setBackground(Color.white);
		foto.setBorder(null);
		
		panelFoto = new JPanel();
		panelContenido = new JPanel();
		panelBotones = new JPanel();

		setBackground(Color.white);
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
		panelContenido.setLayout(new GridBagLayout());
		
		setMaximumSize(new Dimension(800, 160)); // ancho y alto máximo
		setAlignmentX(Component.LEFT_ALIGNMENT); // importante para BoxLayout
		setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		//Izquierda
		panelFoto.add(foto);
		
		//Centro;
		panelContenido.add(new JLabel("ID: "+miLibro.getId()+"     "+miLibro.getTitulo()), gbc);
		gbc.gridx++;
		panelContenido.add(new JLabel("Autor: "+miLibro.getAutor()), gbc);
		gbc.gridy++;
		gbc.gridx=0;
		panelContenido.add(new JLabel("Disponibles: "+miLibro.getCantidadDisponible()+" de "+miLibro.getCantidadTotal()), gbc);
		gbc.gridy++;
		panelContenido.add(btnDesc, gbc);
		
		//Derecha
		btnEliminar.setBackground(Color.white);
		btnEliminar.addActionListener(this);
		btnModificar.setBackground(Color.white);
		btnModificar.addActionListener(this);
		btnModificar.setBorder(null);
		btnEliminar.setBorder(null);
		btnDesc.addActionListener(this);
			
		btnEliminar.setIcon(new ImageIcon("Imagenes/eliminar2.png"));
		btnEliminar.setToolTipText("Haz click para eliminar un libro del catalogo");
		btnModificar.setIcon(new ImageIcon("Imagenes/modificar1.png"));
		btnModificar.setToolTipText("Haz click para modificar un libro");
		
		panelBotones.add(btnModificar);	
		panelBotones.add(btnEliminar);
		
		add(panelFoto, BorderLayout.WEST);
		add(panelContenido, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.EAST);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnEliminar){
			JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres eliminar este libro?", "Confirmar eliminar?", JOptionPane.YES_NO_OPTION,
	                JOptionPane.WARNING_MESSAGE);
		}
		else if(e.getSource()==btnModificar){
			modificarLibro mL = new modificarLibro(miLibro);
		}
		else if(e.getSource()==btnDesc){
			detallesLibro dL = new detallesLibro(miLibro);
		}	
	}
	
	public static void actualizar(Libro nuevoLibro){
		miLibro = nuevoLibro;
	}

}
