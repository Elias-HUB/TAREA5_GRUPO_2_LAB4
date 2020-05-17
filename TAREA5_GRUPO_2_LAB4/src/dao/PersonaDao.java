package dao;

import java.util.List;

import entidad.Persona;


public interface PersonaDao 
{
	public boolean insert(Persona persona);
	public boolean delete(Persona persona_a_eliminar);
	public boolean update(Persona persona_a_modificar, String aux);
	public List<Persona> readAll();
}
