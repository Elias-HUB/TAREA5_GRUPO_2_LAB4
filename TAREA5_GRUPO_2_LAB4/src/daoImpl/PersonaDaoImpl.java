package daoImpl;

import java.sql.Connection;

public class PersonaDaoImpl implements PersonaDao{
	
	private static final String insert = "INSERT INTO personas(dni, nombre, apellido) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE dni = ?";
	private static final String readall = "SELECT * FROM personas";
}
