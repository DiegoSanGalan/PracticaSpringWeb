package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import clasesDTO.Persona;

/**
 * Clase controller para subir ficheros
 */
@Controller
@RequestMapping(value = "/altaPersona")
public class MiControllerFicheros {
	
	@RequestMapping ( method=RequestMethod.GET)
	public String registrarPersona (ModelMap model)
	{
		Persona persona = new Persona();
		model.addAttribute("persona", persona);
		return "inicio";
	}

	/**
	 * 1.- MODIFICADO PARA QUE NO HAGA FALTA PONERLE UN NOMBRE Y UNA EXTENSIÓN
	 * SINO QUE LE PONGA EL MISMO NOMBRE QUE TIENE. 2.- MODIFICARLO PARA PODER
	 * SUBIR VARIOS FICHEROS A LA VEZ
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String guardarFichero(@RequestParam("file") File file, @RequestParam("nombre") String nombre,
			 @RequestParam("edad") int edad, @RequestParam("descripcion") String descripcion, 
			 @RequestParam("dni") String dni) {
		String mensaje = "";
		String fotoname = ""; //para almacenar el nombre del archivo de la foto
		Persona p = null;
		
		//int i = 0;

				

			if (!((MultipartFile) file).isEmpty()) {
				try {
					byte[] bytes = ((MultipartFile) file).getBytes();

					String rootPath = System.getProperty("catalina.home");
					File dir = new File(rootPath + File.separator + "tmpFiles");
					if (!dir.exists()) {
						dir.mkdirs();
					}

					File serverFile = new File(dir.getAbsolutePath()
							+ File.separator + ((MultipartFile) file).getOriginalFilename());
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();

					System.out.println(serverFile.getAbsolutePath());

					//mensaje = mensaje + " Fichero subido guay ="
					//		+ file.getOriginalFilename();
					
					fotoname = ((MultipartFile) file).getOriginalFilename();
					
					
				} catch (Exception e) {
					mensaje = "Se ha liado parda " + e.getMessage();
				}

			} else {

				mensaje = mensaje + "No me traigas ficheros vacíos gañan";
			}
			
			// construimos el objeto persona con los datos recibidos
			p = new Persona(nombre, edad, descripcion, file, fotoname, dni);
			
			
			
			

		return "inicio";
	}

	
}