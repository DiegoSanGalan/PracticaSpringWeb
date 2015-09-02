package clasesDTO;

import java.awt.Image;
import java.io.File;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Persona {

	@Size (min=3)
	@NotEmpty
	private String nombre;
	
	@NotNull
	@Min (18)
	private Integer edad;
	
	@NotEmpty
	private String descripcion;
	//private Image foto;
	
	
	private MultipartFile foto;
	

	private String filename;
	
	@NotEmpty
	private String dni;
	
	/**
	 * 
	 */
	public Persona() {
		
	}





	



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad
				+ ", descripcion=" + descripcion + ", foto=" + foto
				+ ", filename=" + filename + ", dni=" + dni + "]";
	}









	/**
	 * @param nombre
	 * @param edad
	 * @param descripcion
	 * @param foto
	 * @param fotoname
	 * @param dni
	 */
	public Persona(String nombre, Integer edad, String descripcion,
			MultipartFile foto, String filename, String dni) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.descripcion = descripcion;
		this.foto = foto;
		this.filename = filename;
		this.dni = dni;
	}





	/**
	 * @return the edad
	 */
	public Integer getEdad() {
		return edad;
	}





	/**
	 * @param edad the edad to set
	 */
	public void setEdad(Integer edad) {
		this.edad = edad;
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
	 * @return the fotoname
	 */
	public String getFotoname() {
		return filename;
	}


	/**
	 * @param fotoname the fotoname to set
	 */
	public void setfilename(String filename) {
		this.filename = filename;
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
