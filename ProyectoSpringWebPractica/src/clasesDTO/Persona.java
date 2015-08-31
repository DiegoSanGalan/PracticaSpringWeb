package clasesDTO;

import java.awt.Image;

import org.springframework.web.multipart.MultipartFile;

public class Persona {

	private String nombre;
	private int edad;
	private String descripcion;
	//private Image foto;
	private MultipartFile foto;
	private String fotoname;
	private String dni;
	
	
	
	
	/**
	 * 
	 */
	public Persona() {
		
	}




	




	









	/**
	 * @param nombre
	 * @param edad
	 * @param descripcion
	 * @param foto
	 * @param fotoname
	 * @param dni
	 */
	public Persona(String nombre, int edad, String descripcion,
			MultipartFile foto, String fotoname, String dni) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.descripcion = descripcion;
		this.foto = foto;
		this.fotoname = fotoname;
		this.dni = dni;
	}



















	/**
	 * @return the fotoname
	 */
	public String getFotoname() {
		return fotoname;
	}









	/**
	 * @param fotoname the fotoname to set
	 */
	public void setFotoname(String fotoname) {
		this.fotoname = fotoname;
	}









	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}




	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}




	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}




	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}




	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	






	/**
	 * @return the foto
	 */
	public MultipartFile getFoto() {
		return foto;
	}



















	/**
	 * @param foto the foto to set
	 */
	public void setFoto(MultipartFile foto) {
		this.foto = foto;
	}



















	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}




	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
	
	
	
}
