package com.proyectosena.repository.rol;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		proyectosena  
  */                          

import java.util.List;

public interface RolRepository {
	
	public Rol list(Long id);
	
	public List<Rol> listAll(int init, int limit);	
	
	public Rol update(Rol rol);
	
	public void delete(Rol rol);
	
	public Rol insert(Rol rol);
	
	public int getCount();
}
