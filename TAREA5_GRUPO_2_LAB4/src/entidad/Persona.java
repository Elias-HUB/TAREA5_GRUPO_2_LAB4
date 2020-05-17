package entidad;

public class Persona {
	private String dni;
	private String nombre;
	private String apellido;
	
	
	public Persona()
	{
		
	}			
			
	public Persona(String Dni, String nombre, String Apellido)
	{
		this.dni = Dni;
		this.nombre = nombre;
		this.apellido = Apellido;
	}
		
	@Override
	public String toString() {
		return "Dni=" + dni + ", Nombre=" + nombre + ", Apellido=" + apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
