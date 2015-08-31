package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import clasesDTO.Persona;

@Controller
public class MiWsPutController {
	
	
	@RequestMapping(path = "/personaJSONPUT", produces="application/json", method=RequestMethod.PUT, consumes="application/json")
	@ResponseBody
	public ResponseEntity<Persona> personaJSONPut(@RequestBody Persona p) {
		//con @RequestBody le digo que es lo que viaja en el cuerpo de la petición
		
 

		System.out.println(p.toString());
		return new ResponseEntity<Persona>(p, HttpStatus.OK);
	}
	

}
