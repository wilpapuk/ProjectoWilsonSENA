package com.proyectosena.service.rol;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		proyectosena  
  */                          

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.proyectosena.repository.rol.Rol;
import com.proyectosena.repository.rol.RolRepository;

@Service
public class RolServiceImpl implements RolService{
	
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	Gson gson;
	
	/**
	 * @return the rolRepository
	 */
	public RolRepository getRolRepository() {
		return rolRepository;
	}

	/**
	 * @param rolRepository the rolRepository to set
	 */
	public void setRolRepository(RolRepository rolRepository) {
		this.rolRepository = rolRepository;
	}
	
	@Override
	@RolesAllowed({"ADMINISTRATOR_ADMINISTRATOR", "APP_ROL__ALL", "APP_ROL__READ"})
	public String list(Long id){
		Rol listAll=rolRepository.list(id);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", listAll);
		result.put("count", this.getCount());
		
		return gson.toJson(result);	
	}
	
	@Override
	@RolesAllowed({"ADMINISTRATOR_ADMINISTRATOR", "APP_ROL__ALL", "APP_ROL__READ"})
	public String listAll(int pageSize, int page){
	
		int limit=pageSize*page;
		int init=limit-pageSize;
		
		List<Rol> listAll=rolRepository.listAll(init, limit);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", listAll);
		result.put("count", this.getCount());
		
		return gson.toJson(result);	
	}	
	
	@Override
	public int getCount(){
				
		return rolRepository.getCount();
	}
	
	@Override
	@RolesAllowed({"ADMINISTRATOR_ADMINISTRATOR", "APP_ROL__ALL", "APP_ROL__UPDATE"})
	public String update(Rol rol){
		return gson.toJson(rolRepository.update(rol));
	}
	
	@Override
	@RolesAllowed({"ADMINISTRATOR_ADMINISTRATOR", "APP_ROL__ALL", "APP_ROL__DELETE"})
	public void delete(Rol rol){
		rolRepository.delete(rol);
	}
	
	@Override
	@RolesAllowed({"ADMINISTRATOR_ADMINISTRATOR", "APP_ROL__ALL", "APP_ROL__CREATE"})
	public String insert(Rol rol){
		return gson.toJson(rolRepository.insert(rol));
	}
	
}
