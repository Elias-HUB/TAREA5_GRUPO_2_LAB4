package negocioImpl;

import java.util.List;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio{
	
	PersonaDao pdao = new PersonaDaoImpl();
	
	@Override
	public boolean insert(Persona persona) {
		
		boolean estado=false;
		if(persona.getNombre().trim().length()>0 && persona.getApellido().trim().length()>0)
		{
			estado=pdao.insert(persona);
		}
		return estado;
	}

	
	@Override
	public boolean delete(Persona persona_a_eliminar) {
		boolean estado=false;
		if(persona_a_eliminar.getDni().trim().length() >0 )//Tambi�n se puede preguntar si existe ese ID 
		{
			estado=pdao.delete(persona_a_eliminar);
		}
		return estado;
	}

	
	@Override
	public List<Persona> readAll() {
		return pdao.readAll();
	}

	
	@Override
	public boolean update(Persona persona_a_modificar) {
		// TODO Auto-generated method stub
		return false;
	}

}
