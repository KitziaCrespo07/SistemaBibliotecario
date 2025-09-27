package gUILayer;
//venta que se genera a partir del boton verde
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

// import javax.activation.MimeTypeParameterList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import modelo.Libro;

public class modificarLibro extends JFrame implements ActionListener {

	private Libro miLibro;
	private JTextField tfTitulo, tfGenero, tfDescripcion, tfCantidadTotal, tfAutor, tfEditorial, tfISBN, tfCantidad;
	private ImageIcon portadaTemp;
	private JButton btnGuardarM;
	private JButton btnCargarImg;
	public modificarLibro(Libro libro) {
		super("Modificar un libro");
		miLibro = libro;
		setSize(400, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		intComponents();
		setVisible(true);

	}
	
	
	private void intComponents() {
		//setLayout(new GridLayout(1, 1));
		GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx=0;
	        gbc.gridy=0;
	        gbc.gridwidth = 1;
	        gbc.gridheight = 1;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.insets = new Insets(5, 5, 5, 5);

			tfTitulo = new JTextField(miLibro.getTitulo(), 10);
			tfGenero = new JTextField(miLibro.getGenero());
			tfDescripcion = new JTextField(miLibro.getDescripcion());
			tfCantidadTotal = new JTextField(miLibro.getCantidadTotal()+"");
			tfAutor = new JTextField(miLibro.getAutor());
			tfEditorial = new JTextField(miLibro.getEditorial());
			tfISBN = new JTextField(miLibro.getISBN());
			tfCantidad=tfCantidadTotal;
			
			btnCargarImg = new JButton("Cargar nueva imagen");
			btnCargarImg.addActionListener(this);
			
			btnGuardarM = new JButton("Guardar cambios");
			btnGuardarM.addActionListener(this);
			JPanel panel = new JPanel();
			panel.setBackground(Color.pink);
			panel.setLayout(new GridBagLayout());
			
			panel.add(new JLabel("Titulo:"), gbc);
	        gbc.gridy++;		
	        panel.add(new JLabel("Autor:"), gbc);
	        gbc.gridy++;	
	        panel.add(new JLabel("Genero:"), gbc);
	        gbc.gridy++;	
	        panel.add(new JLabel("Editorial:"), gbc);
	        gbc.gridy++;	
	        panel.add(new JLabel("ISBN:"), gbc);
	        gbc.gridy++;	
			panel.add(new JLabel("Descripcion:"), gbc);
	        gbc.gridy++;		
			panel.add(new JLabel("Cantidad Total:"), gbc);
	        gbc.gridy++;	
	        panel.add(btnCargarImg,gbc);
	        gbc.gridy++;	
			panel.add(btnGuardarM, gbc);
			
	        gbc.gridx=1;
	        gbc.gridy=0;   		
	        panel.add(tfTitulo, gbc);
			gbc.gridy++;		
			panel.add(tfAutor, gbc);
			gbc.gridy++;		
			panel.add(tfGenero, gbc);
			gbc.gridy++;		
			panel.add(tfEditorial, gbc);
			gbc.gridy++;
			panel.add(tfISBN, gbc);
			gbc.gridy++;			
			panel.add(tfDescripcion, gbc);
			gbc.gridy++;		
			panel.add(tfCantidadTotal, gbc);
			gbc.gridy++;
			add(panel);
			//Libro nuevoLibro = new Libro(tfTitulo.getText(), tfGenero.getText(), tfDescripcion.getText(), tfAutor.getText(), tfEditorial.getText(), tfISBN.getText(), Integer.parseInt(tfCantidad.getText()), portadaTemp);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCargarImg){
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
		if(e.getSource()==btnGuardarM){
			System.out.println("Cambios guardados");
			Libro nuevoLibro = new Libro(tfTitulo.getText(), tfGenero.getText(), tfDescripcion.getText(), tfAutor.getText(), tfEditorial.getText(), tfISBN.getText(), Integer.parseInt(tfCantidad.getText()), portadaTemp);
			itemLibro.actualizar(nuevoLibro);
		}
	}

	
}
