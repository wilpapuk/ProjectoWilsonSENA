package com.proyectosena.service.rol;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		proyectosena  
  */                          

import java.util.List;
import com.proyectosena.repository.rol.Rol;

public interface RolService{
	
	public String list(Long id);
	
	public String listAll(int pageSize, int page);	
	
	public String insert(Rol rol);
	
	public String update(Rol rol);
	
	public void delete(Rol rol);	
	
	public int getCount();
	
}
