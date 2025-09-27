package gUILayer;

//Ventana que se genera a partir de mas informacion
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// import javax.activation.MimeTypeParameterList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Libro;

public class detallesLibro extends JFrame implements ActionListener {

	private Libro miLibro;
	private JButton foto;
	private JPanel panelFoto;
	private JPanel panelContenido;
	private JPanel borde;
	
	public detallesLibro(Libro libro) {
		super("Mas informacion");
		miLibro = libro;
		setSize(400, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		intComponents();
	}
	
	
	private void intComponents() {
		setLayout(new BorderLayout());
		panelFoto = new JPanel();
		panelContenido = new JPanel();
		borde = new JPanel();
		borde.setBackground(Color.pink);
		
		panelContenido.setLayout(new GridLayout());
		GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx=0;
	        gbc.gridy=0;
	        gbc.gridwidth = 1;
	        gbc.gridheight = 1;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.insets = new Insets(5, 5, 5, 5);
			
			foto = new JButton(miLibro.getImageIcon());
			foto.setBorder(null);
			foto.setBackground(Color.pink);
			panelContenido.setBackground(Color.pink);
			panelContenido.setLayout(new GridBagLayout());
			
			panelFoto.setLayout(new BorderLayout());
			panelFoto.add(borde, BorderLayout.WEST);
			panelFoto.add(foto, BorderLayout.CENTER);
			panelFoto.setBackground(Color.pink);
			gbc.gridx++;
			panelContenido.add(new JLabel("Descripcion: "+miLibro.getDescripcion()), gbc);
	        gbc.gridy++;
			panelContenido.add(new JLabel("Genero: "+miLibro.getGenero()), gbc);
	        gbc.gridy++;
			panelContenido.add(new JLabel("Editorial: "+miLibro.getEditorial()), gbc);
	        gbc.gridy++;	
	        panelContenido.add(new JLabel("ISBN: "+miLibro.getISBN()), gbc);
	        gbc.gridy++;
		    panelContenido.add(new JButton("Historial de prestamos"), gbc);
	        add(panelFoto, BorderLayout.WEST);
	        add(panelContenido, BorderLayout.CENTER);

	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
