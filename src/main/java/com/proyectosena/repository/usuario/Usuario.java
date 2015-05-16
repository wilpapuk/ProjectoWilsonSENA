package com.proyectosena.repository.usuario;

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
@Table(name = "usuario")
public class Usuario {
	@Id 
	// Habilite este codigo para generar automaticamente la llave primaria esta depende de una tabla
	@TableGenerator(name = "usuario_GEN", //<= nombre de la tabla con el cual se va a identificar la llave
	                 table = "FRM_PKID",              //<= Este string define la tabla dond se almacenan el consecutivo
	                 pkColumnName="PKIDNOMB",         //<= NOMBRE DE LA LLAVE PRIMARIA DE LA TABLA    
	                 valueColumnName="PKIDVALU",      //<= Valor del consecutivo en el que va la llave primaria
	                 pkColumnValue="usuario_PK", 
	                 initialValue = 1,                //<= Valor inicial de la llave primario
	                 allocationSize = 1)              //<= Valor a buscar por medio de la llave primaria
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "usuario_GEN")  
	@Column(name = "idUSUARIO")
	protected Long idusuario; 
	 
	@Column(name = "USUARIO")
	protected String usuario; 
	 
	@Column(name = "CORREO")
	protected String correo; 
	 
	@Column(name = "PASSWORD1")
	protected String password1; 
	 
	@Column(name = "ESTADO")
	protected String estado; 

	public Usuario(){
	
	}

	public Long getIdusuario(){
		return idusuario;
	}
	
	public void setIdusuario(Long idusuario){
		this.idusuario = idusuario;
	}

	public String getUsuario(){
		return usuario;
	}
	
	public void setUsuario(String usuario){
		this.usuario = usuario;
	}

	public String getCorreo(){
		return correo;
	}
	
	public void setCorreo(String correo){
		this.correo = correo;
	}

	public String getPassword1(){
		return password1;
	}
	
	public void setPassword1(String password1){
		this.password1 = password1;
	}

	public String getEstado(){
		return estado;
	}
	
	public void setEstado(String estado){
		this.estado = estado;
	}


	static public String[] getNames(){
		return new String[]{ "idUSUARIO", "USUARIO", "CORREO", "PASSWORD1", "ESTADO" };
	}		
	
	static public String getColumnNames(){
		return " idUSUARIO, USUARIO, CORREO, PASSWORD1, ESTADO ";
	}
	
	public String toString(){
		return " idUSUARIO: "+ this.idusuario 
			+" USUARIO: "+ this.usuario 
			+" CORREO: "+ this.correo 
			+" PASSWORD1: "+ this.password1 
			+" ESTADO: "+ this.estado ;
	}
}
