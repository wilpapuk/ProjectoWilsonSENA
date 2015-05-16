package com.proyectosena.controller.usuario;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


import com.proyectosena.repository.usuario.Usuario;
import com.proyectosena.service.usuario.UsuarioService;

@Controller
@RequestMapping("/Usuario")
public class CUsuario {

	@Autowired
	private UsuarioService usuarioService;
	
	public CUsuario() {
		super();
	}
			
	@RequestMapping("/")
	public String index() {
		return "proyectosena/usuario/Usuario";
	}
	
	@RequestMapping(value = "/{idusuario}.json", method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String list(@PathVariable("idusuario") Long idusuario){
		
		return this.usuarioService.list(idusuario);
	}
	
	@RequestMapping(value = "/listAll.json", params = {"page","pageSize"},  method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String listAll(@RequestParam("pageSize") int pageSize, @RequestParam("page") int page){
	
		return this.usuarioService.listAll(pageSize, page);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces={"application/json"})
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public String update(@RequestBody Usuario usuario, HttpServletRequest request){
	
		return this.usuarioService.update(usuario);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces={"application/json"})
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public String delete(@RequestBody Usuario usuario, HttpServletRequest request){
	
		//usuario.setesta("B");
		return this.usuarioService.update(usuario);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces={"application/json"})
	@ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
	public String insert(@RequestBody Usuario usuario, HttpServletRequest request){
		
		return this.usuarioService.insert(usuario);		
	}
}
