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
	@Column(name = "IDUSUARIO")
	protected Long idusuario; 
	 
	@Column(name = "NOMBRE")
	protected String nombre; 
	 
	@Column(name = "APELLIDO")
	protected String apellido; 
	 
	@Column(name = "TELEFONO")
	protected String telefono; 
	 
	@Column(name = "CEDULA")
	protected String cedula; 
	 
	@Column(name = "DIRECCION")
	protected String direccion; 
	 
	@Column(name = "USUARIO")
	protected String usuario; 
	 
	@Column(name = "CONTRASENA")
	protected String contrasena; 
	 
	@Column(name = "ENABLED")
	protected Integer enabled; 

	public Usuario(){
	
	}

	public Long getIdusuario(){
		return idusuario;
	}
	
	public void setIdusuario(Long idusuario){
		this.idusuario = idusuario;
	}

	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getApellido(){
		return apellido;
	}
	
	public void setApellido(String apellido){
		this.apellido = apellido;
	}

	public String getTelefono(){
		return telefono;
	}
	
	public void setTelefono(String telefono){
		this.telefono = telefono;
	}

	public String getCedula(){
		return cedula;
	}
	
	public void setCedula(String cedula){
		this.cedula = cedula;
	}

	public String getDireccion(){
		return direccion;
	}
	
	public void setDireccion(String direccion){
		this.direccion = direccion;
	}

	public String getUsuario(){
		return usuario;
	}
	
	public void setUsuario(String usuario){
		this.usuario = usuario;
	}

	public String getContrasena(){
		return contrasena;
	}
	
	public void setContrasena(String contrasena){
		this.contrasena = contrasena;
	}

	public Integer getEnabled(){
		return enabled;
	}
	
	public void setEnabled(Integer enabled){
		this.enabled = enabled;
	}


	static public String[] getNames(){
		return new String[]{ "IDUSUARIO", "NOMBRE", "APELLIDO", "TELEFONO", "CEDULA", "DIRECCION", "USUARIO", "CONTRASENA", "ENABLED" };
	}		
	
	static public String getColumnNames(){
		return " IDUSUARIO, NOMBRE, APELLIDO, TELEFONO, CEDULA, DIRECCION, USUARIO, CONTRASENA, ENABLED ";
	}
	
	public String toString(){
		return " IDUSUARIO: "+ this.idusuario 
			+" NOMBRE: "+ this.nombre 
			+" APELLIDO: "+ this.apellido 
			+" TELEFONO: "+ this.telefono 
			+" CEDULA: "+ this.cedula 
			+" DIRECCION: "+ this.direccion 
			+" USUARIO: "+ this.usuario 
			+" CONTRASENA: "+ this.contrasena 
			+" ENABLED: "+ this.enabled ;
	}
}
