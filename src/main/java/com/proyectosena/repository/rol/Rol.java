package com.proyectosena.repository.rol;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		proyectosena  
  */                          

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name = "rol")
public class Rol {
	@Id 
	// Habilite este codigo para generar automaticamente la llave primaria esta depende de una tabla
	@TableGenerator(name = "rol_GEN", //<= nombre de la tabla con el cual se va a identificar la llave
	                 table = "FRM_PKID",              //<= Este string define la tabla dond se almacenan el consecutivo
	                 pkColumnName="PKIDNOMB",         //<= NOMBRE DE LA LLAVE PRIMARIA DE LA TABLA    
	                 valueColumnName="PKIDVALU",      //<= Valor del consecutivo en el que va la llave primaria
	                 pkColumnValue="rol_PK", 
	                 initialValue = 1,                //<= Valor inicial de la llave primario
	                 allocationSize = 1)              //<= Valor a buscar por medio de la llave primaria
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "rol_GEN")  
	@Column(name = "IDROL")
	protected Long idrol; 
	 
	@Column(name = "NOMBRE")
	protected String nombre; 

	public Rol(){
	
	}

	public Long getIdrol(){
		return idrol;
	}
	
	public void setIdrol(Long idrol){
		this.idrol = idrol;
	}

	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}


	static public String[] getNames(){
		return new String[]{ "IDROL", "NOMBRE" };
	}		
	
	static public String getColumnNames(){
		return " IDROL, NOMBRE ";
	}
	
	public String toString(){
		return " IDROL: "+ this.idrol 
			+" NOMBRE: "+ this.nombre ;
	}
}
