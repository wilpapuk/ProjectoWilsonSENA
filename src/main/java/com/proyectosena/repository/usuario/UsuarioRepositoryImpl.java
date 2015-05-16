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
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository{
	
	@Autowired
	private SessionFactory sessionFactory;  	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * Metodo de consulta para los registros de la tabla Usuario por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return Usuario = objeto de la case Usuario que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public Usuario list(Long id){
		try{
			String sql = "select "+Usuario.getColumnNames()
					   + "from Usuario "
					   + "where idusuario = :id ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(Usuario.class)					
					     .setParameter("id", id);
			return (Usuario)query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Metodo de consulta para los registros de la tabla Usuario
	 * @return Usuario = coleccion de objetos de la case Usuario que contiene los datos encontrados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public List<Usuario> listAll(int init, int limit){
		try{
			String sql = "select "+Usuario.getColumnNames()
					   + "from Usuario ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(Usuario.class);
						 
			if(init==0 && limit!=0){
				query.setFirstResult(init);			
				query.setMaxResults(limit);
			}
					     
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}	
	
	/**
	 * Metodo de consulta para el conteo de los registros de la tabla Usuario
	 * @return int = cantidad de registros encontrados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public int getCount(){
		try{
			String sql = "select count(*) "
					   + "from Usuario ";
						
			Query query = getSession().createQuery(sql);
	        
			Iterator it = query.list().iterator();
	        Long ret = new Long(0);
	        
	        if (it != null)
		        if (it.hasNext()){
		        	ret = (Long) it.next();
		        }
	        
			return ret.intValue();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Metodo para actualizar los datos de un registro de la tabla Usuario por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return Usuario = objeto de la case Usuario que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public Usuario update(Usuario usuario){
		getSession().update(usuario);
		return usuario;
	}
	
	/**
	 * Metodo para borrar un registro de la tabla Usuario por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return Usuario = objeto de la case Usuario que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public void delete(Usuario usuario){
		
	}
	
	/**
	 * Metodo para ingresar un registro de la tabla Usuario
	 * @value idusuario
	 * @value usuario
	 * @value correo
	 * @value password1
	 * @value estado
	 * @return Usuario = objeto de la case Usuario que contiene los datos ingresados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public Usuario insert(Usuario usuario){
		getSession().save(usuario);	
		return usuario;
	}
}
