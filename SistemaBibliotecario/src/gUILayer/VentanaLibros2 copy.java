package gUILayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.border.Border;

public class VentanaLibros2 extends JFrame implements ActionListener {
	private JButton alta = new JButton("DAR DE ALTA UN LIBRO");
	private JButton baja = new JButton("DAR DE BAJA UN LIBRO");
	private JButton modificacion = new JButton("MODIFICAR UN LIBRO");
	private JToolBar barraHerramientas = new JToolBar();

	private JButton btnNuevoL, btnModL, btnEl;
	private JPanel panelCreacion, panelContenido, panelSubContenido;

	private JScrollPane scroll;
	
	private JButton btnBuscar;
	public VentanaLibros2(){
		super("Libros");
		setSize(900, 600);
		getContentPane().setBackground(Color.yellow);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		intComponents();
	}
	
	public void intComponents(){
		contenidoPrincipal();
		contenidoIzquierda();
		JFrame item = new JFrame();
		item.setBackground(Color.cyan);
	}
	

	private void contenidoIzquierda() {
		//JLabel tCreacion = new JLabel("AGREGAR LIBRO");
		panelCreacion = new JPanel(new GridBagLayout());
		panelCreacion.setBackground(Color.orange);
		panelCreacion.setLayout(new GridBagLayout());
		 
		GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx=0;
	        gbc.gridy=0;
	        gbc.gridwidth = 1;
	        gbc.gridheight = 1;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.insets = new Insets(5, 5, 5, 5);

		//panelCreacion.add(tCreacion);
		panelCreacion.add(new JLabel("Agrega un nuevo libro"), gbc);
        gbc.gridy++;		
		panelCreacion.add(new JLabel("Titulo:"), gbc);
        gbc.gridy++;		
		panelCreacion.add(new JLabel("Genero:"), gbc);
        gbc.gridy++;		
		panelCreacion.add(new JLabel("Descripcion:"), gbc);
        gbc.gridy++;		
		panelCreacion.add(new JLabel("Cantidad:"), gbc);
        gbc.gridx=1;
        gbc.gridy=1;     
		panelCreacion.add(new JTextField(5),gbc);
		gbc.gridy++;		
		panelCreacion.add(new JTextField(5), gbc);
		gbc.gridy++;		
		panelCreacion.add(new JTextField(5), gbc);
		gbc.gridy++;		
		panelCreacion.add(new JTextField(5), gbc);
		gbc.gridy++;
        gbc.gridx=0;

		JButton Guardar = new JButton("Guardar");
		panelCreacion.add(Guardar, gbc);
		add(panelCreacion, BorderLayout.WEST);
	}

	public void contenidoPrincipal(){
		panelContenido = new JPanel();
		panelContenido.setBackground(Color.red);
		panelContenido.setLayout(new BorderLayout());
		
		panelSubContenido = new JPanel();
		panelSubContenido.setLayout(new BoxLayout(panelSubContenido, BoxLayout.Y_AXIS));
		panelSubContenido.setBackground(Color.green);
		
		btnBuscar = new JButton();
		btnBuscar.setIcon(new ImageIcon("Imagenes/lupa4.png"));
		btnBuscar.setBackground(Color.white);
		btnBuscar.setBorder(null);
		
		JPanel superior = new JPanel();
		superior.setBackground(Color.white);
		superior.add(btnBuscar);
		superior.add(new JTextField(50));
		
		scroll=new JScrollPane(panelSubContenido);
		
		panelContenido.add(superior, BorderLayout.NORTH);		
		panelContenido.add(scroll, BorderLayout.CENTER);
				
		add(panelContenido, BorderLayout.CENTER);
		
		//Probando
		panelSubContenido.add(new JLabel("Titulos con los que contamos:"));

		panelSubContenido.add(new itemLibro());
	
		panelSubContenido.add(new itemLibro());
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
	
}
