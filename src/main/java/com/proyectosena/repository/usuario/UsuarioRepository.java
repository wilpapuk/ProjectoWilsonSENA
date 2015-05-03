package com.proyectosena.repository.usuario;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		proyectosena  
  */                          

import java.util.List;

public interface UsuarioRepository {
	
	public Usuario list(Long id);
	
	public List<Usuario> listAll(int init, int limit);	
	
	public Usuario update(Usuario usuario);
	
	public void delete(Usuario usuario);
	
	public Usuario insert(Usuario usuario);
	
	public int getCount();
}
