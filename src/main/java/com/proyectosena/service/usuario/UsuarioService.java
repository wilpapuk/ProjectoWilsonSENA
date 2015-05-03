package com.proyectosena.service.usuario;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		proyectosena  
  */                          

import java.util.List;
import com.proyectosena.repository.usuario.Usuario;

public interface UsuarioService{
	
	public String list(Long id);
	
	public String listAll(int pageSize, int page);	
	
	public String insert(Usuario usuario);
	
	public String update(Usuario usuario);
	
	public void delete(Usuario usuario);	
	
	public int getCount();
	
}
