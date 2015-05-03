package com.proyectosena.service.usuario;

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
import com.proyectosena.repository.usuario.Usuario;
import com.proyectosena.repository.usuario.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	Gson gson;
	
	/**
	 * @return the usuarioRepository
	 */
	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	/**
	 * @param usuarioRepository the usuarioRepository to set
	 */
	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	@RolesAllowed({"ADMINISTRATOR_ADMINISTRATOR", "APP_USUARIO__ALL", "APP_USUARIO__READ"})
	public String list(Long id){
		Usuario listAll=usuarioRepository.list(id);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", listAll);
		result.put("count", this.getCount());
		
		return gson.toJson(result);	
	}
	
	@Override
	@RolesAllowed({"ADMINISTRATOR_ADMINISTRATOR", "APP_USUARIO__ALL", "APP_USUARIO__READ"})
	public String listAll(int pageSize, int page){
	
		int limit=pageSize*page;
		int init=limit-pageSize;
		
		List<Usuario> listAll=usuarioRepository.listAll(init, limit);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", listAll);
		result.put("count", this.getCount());
		
		return gson.toJson(result);	
	}	
	
	@Override
	public int getCount(){
				
		return usuarioRepository.getCount();
	}
	
	@Override
	@RolesAllowed({"ADMINISTRATOR_ADMINISTRATOR", "APP_USUARIO__ALL", "APP_USUARIO__UPDATE"})
	public String update(Usuario usuario){
		return gson.toJson(usuarioRepository.update(usuario));
	}
	
	@Override
	@RolesAllowed({"ADMINISTRATOR_ADMINISTRATOR", "APP_USUARIO__ALL", "APP_USUARIO__DELETE"})
	public void delete(Usuario usuario){
		usuarioRepository.delete(usuario);
	}
	
	@Override
	@RolesAllowed({"ADMINISTRATOR_ADMINISTRATOR", "APP_USUARIO__ALL", "APP_USUARIO__CREATE"})
	public String insert(Usuario usuario){
		return gson.toJson(usuarioRepository.insert(usuario));
	}
	
}
