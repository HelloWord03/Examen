package Conexion;

public class ContenidoTablaBdeaver {
	create table Aplicacion_CRUD (
			ID_Jugador int primary key,
			Nombre varchar(255),
			Equipo varchar(255),
			NumeroCamiseta int(2),
			altura int(3,2)

		);

		INSERT INTO Aplicacion_CRUD  values(1,"Brandom","Eraklyon",03,1.85);
		INSERT INTO Aplicacion_CRUD  values(2,"Timmy","Zenith",05,1.75);
		INSERT INTO Aplicacion_CRUD  values(3,"Riven","Eraklyon",01,1.93);
		INSERT INTO Aplicacion_CRUD  values(4,"Thoren","Domino",02,1.89);
		INSERT INTO Aplicacion_CRUD  values(5,"Jin","Domino",04,1.80);
		INSERT INTO Aplicacion_CRUD  values(6,"Elias","Linphea",01,1.90);
		INSERT INTO Aplicacion_CRUD  values(7,"Ricky","Linphea",07,1.87);
		INSERT INTO Aplicacion_CRUD  values(8,"Liam","Solaria",10,1.77);
		INSERT INTO Aplicacion_CRUD  values(9,"Ethan","Solaria",09,1.83);
		INSERT INTO Aplicacion_CRUD  values(10,"Kay","Zenith",06,1.92);

		SELECT * FROM Aplicacion_CRUD ac;
}
