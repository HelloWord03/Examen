package DatosJugador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import modelo.Jugador;

public class DatosJugador {

	Conexion cx; 
	
	public DatosJugador() {
		cx = new Conexion();
	}
	
	public boolean insertarJugador(Jugador Nombre) {
		PreparedStatement ps = null;
		try {
			ps= cx.conectar().prepareStatement("Insert INTO Plataforma Jugadores VALUES (null,?,?,?,?)");
			ps.setString(1, Nombre.getNombre());
			ps.setString(2, Nombre.getEquipo());
			ps.setInt(3, Nombre.getNumeroCamiseta());
			ps.setFloat(4, Nombre.getAltura());
		    ps.executeUpdate();
		    cx.desconectar();
		    return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public ArrayList<Jugador> consultaJugador(){
		 ArrayList<Jugador> lista = new ArrayList<Jugador>();
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 try {
			 ps=cx.conectar().prepareStatement("SELECT * FROM Plataforma Jugadores");
			 rs=ps.executeQuery();
			 while (rs.next()) {
				 Jugador Nombre = new Jugador();
				 Nombre.setID_Jugador(rs.getInt("ID_Jugador"));
				 Nombre.setNombre(rs.getString("Nombre"));	 
				 Nombre.setEquipo(rs.getString("Equipo"));
				 Nombre.setNumeroCamiseta(rs.getInt("NumeroCamiseta"));
				 Nombre.setAltura(rs.getFloat("Altura"));
				 lista.add(Nombre);
			 }
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return lista;
	}
}
