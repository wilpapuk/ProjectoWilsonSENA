package com.proyectosena.controller.rol;

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


import com.proyectosena.service.rol.RolService;
import com.proyectosena.repository.rol.Rol;

@Controller
@RequestMapping("/Rol")
public class CRol {

	@Autowired
	private RolService rolService;
	
	public CRol() {
		super();
	}
			
	@RequestMapping("/")
	public String index() {
		return "proyectosena/rol/Rol";
	}
	
	@RequestMapping(value = "/{idrol}.json", method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String list(@PathVariable("idrol") Long idrol){
		
		return this.rolService.list(idrol);
	}
	
	@RequestMapping(value = "/listAll.json", params = {"page","pageSize"},  method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String listAll(@RequestParam("pageSize") int pageSize, @RequestParam("page") int page){
	
		return this.rolService.listAll(pageSize, page);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces={"application/json"})
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public String update(@RequestBody Rol rol, HttpServletRequest request){
	
		return this.rolService.update(rol);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces={"application/json"})
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public String delete(@RequestBody Rol rol, HttpServletRequest request){
	
		//rol.setesta("B");
		return this.rolService.update(rol);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces={"application/json"})
	@ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
	public String insert(@RequestBody Rol rol, HttpServletRequest request){
		
		return this.rolService.insert(rol);		
	}
}
