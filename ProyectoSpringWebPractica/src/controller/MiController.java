package controller;


import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import clasesDTO.Persona;


 
@Controller
public class MiController {
 
	@RequestMapping("/bienvenido")
	public ModelAndView holaMundo() {
 
		String mensaje = "Vamos a darle caña al Spring";
		return new ModelAndView("bienvenido", "mensaje", mensaje);
	}
	
@RequestMapping("/bienvenido2")
public String holaMundo2(@RequestParam(value="name", required=false, defaultValue="Mundo") String name, 
		@RequestParam(value="apell", required=false, defaultValue="Insolito") String apell, Model model) 
    {
	//String devuelto ="";
	
        model.addAttribute("name", name);
        model.addAttribute("apell", apell);
    
    
    
        return "inicio";
    }

@RequestMapping(path = "/personaction", method = RequestMethod.POST)
public String formularioPersona (@ModelAttribute Persona persona, Model model)

    {
	//String devuelto ="";
	
	System.out.println("Edad = " + persona.getEdad());
	System.out.println("Nombre = " + persona.getNombre());
	System.out.println("Descripcion = " + persona.getDescripcion());
       
    model.addAttribute("personita", persona); //personita seria el nombre que utilizaremos en la vista
    					// para poder ver en el .jsp los datos del bean.
    return "datospersona"; //éste string representa el nombre de la vista. Como en el ViewRewolver
    				// tenemos puesto que añada prefijo y sufijo buscara el archivo .jsp asociado.
    
      
    }

	
}