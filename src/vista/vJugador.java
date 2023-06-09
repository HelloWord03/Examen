package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DatosJugador.DatosJugador;
import modelo.Jugador;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;

public class vJugador extends JFrame {

	private JPanel contentPane;
	private JComboBox<Object> cmbEquipo;
	private JSpinner spnNumeroCamiseta;
	private JTextField txtNombre;
	private JButton btnBuscar;
	private JButton btnLimpiar;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JButton btnModificar;
	DatosJugador Datos = new DatosJugador();
	private JTextField txtAltura;
	DefaultTableModel modelo = new DefaultTableModel();
    ArrayList<Jugador>lista;
    private JScrollPane scrollPane;
    int fila = -1;
    Jugador jugador = new Jugador();
    private JTable tblJugador;
   
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vJugador frame = new vJugador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void actualizarTabla() {
	
		while(modelo.getRowCount()>0) {
			modelo.removeRow(0);	
		}
		
		lista = Datos.consultaJugador();
		
		for(Jugador n:lista) {
			Object Jugador []= new Object[5];
			Jugador[0]= n.getID_Jugador();
			Jugador[1]= n.getNombre();
			Jugador[2]= n.getEquipo();
			Jugador[3]= n.getNumeroCamiseta();
			Jugador[4]= n.getAltura();
			modelo.addRow(Jugador);
		}	
	}
	
	public void Limpiar() {
		txtNombre.setText("");
		spnNumeroCamiseta.setValue("");
		txtAltura.setText("");
		cmbEquipo.setSelectedItem("");
	}
	
	public vJugador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setTitle("CRUD JUGADOR");
        setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Plataforma De Informacion De Jugadores");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(71, 11, 427, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblID_Jugador = new JLabel("ID_Jugador:");
		lblID_Jugador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblID_Jugador.setBounds(29, 62, 100, 20);
		contentPane.add(lblID_Jugador);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNombre.setBounds(29, 110, 68, 20);
		contentPane.add(lblNombre);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblEquipo.setBounds(29, 155, 63, 20);
		contentPane.add(lblEquipo);
		
		JLabel lblNumeroCamiseta = new JLabel("NumeroCamiseta");
		lblNumeroCamiseta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNumeroCamiseta.setBounds(24, 200, 135, 27);
		contentPane.add(lblNumeroCamiseta);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblAltura.setBounds(30, 250, 62, 20);
		contentPane.add(lblAltura);
		
		JLabel lblID = new JLabel("0");
		lblID.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblID.setBounds(154, 62, 46, 19);
		contentPane.add(lblID);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(106, 110, 94, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		cmbEquipo = new JComboBox<Object>();
		cmbEquipo.setModel(new DefaultComboBoxModel<Object>(new String[] {"Selecciona", "Eraklyom", "Solaria", "Linphea", "Andross", "Magix", "Domino", "Zenith"}));
		cmbEquipo.setBounds(106, 153, 94, 22);
		contentPane.add(cmbEquipo);
		
		spnNumeroCamiseta = new JSpinner();
		spnNumeroCamiseta.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spnNumeroCamiseta.setBounds(169, 205, 43, 20);
		contentPane.add(spnNumeroCamiseta);
		
		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		txtAltura.setBounds(91, 252, 94, 20);
		contentPane.add(txtAltura);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBounds(29, 295, 89, 23);
		contentPane.add(btnBuscar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(29, 350, 89, 23);
		contentPane.add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(153, 350, 89, 23);
		contentPane.add(btnModificar);
		
		btnLimpiar = new JButton("Limpiar ");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpiar();
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpiar.setBounds(153, 295, 89, 23);
		contentPane.add(btnLimpiar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(txtNombre.getText().equals("") || cmbEquipo.getSelectedItem().equals("") || spnNumeroCamiseta.getValue().equals("") || txtAltura.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "CAMPOS VACIOS Y SON REQUERIDOS");
						return;
					}
					
					Jugador Jugador1 = new Jugador();
					Jugador1.setNombre(txtNombre.getText());
					Jugador1.setEquipo(cmbEquipo.getSelectedItem().toString());
					Jugador1.setNumeroCamiseta(Integer.parseInt(spnNumeroCamiseta.getValue().toString()));
					Jugador1.setAltura(Double.parseDouble(txtAltura.getText()));
					System.out.print(txtAltura.getText());
					
					if(Datos.insertarJugador(Jugador1)) {
						actualizarTabla();
//						Limpiar();
						JOptionPane.showMessageDialog(null, "Se guardaron los datos correctamente!!!");
					} else {
						JOptionPane.showMessageDialog(null,"ERROR");
					}
					
				} catch(Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null,"ERROR IS ME"); 
				}
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBounds(96, 323, 89, 23);
		contentPane.add(btnGuardar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(292, 74, 301, 196);
		contentPane.add(scrollPane);
		
		tblJugador = new JTable();
		tblJugador.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setRowHeaderView(tblJugador);
		modelo.addColumn("ID");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("EQUIPO");
	    modelo.addColumn("NUMEROcAMISETA");
	    modelo.addColumn("ALTURA");
		actualizarTabla();	
	}
}
