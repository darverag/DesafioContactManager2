package com.desafiolatam.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="contactos")
public class Contacto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=3, message = "Ingresar nombre minimo 3 caracteres")
	private String nombre;
	
	@NotNull
	@Size(min=3, message = "Ingresar apellido minimo 3 caracteres")
	private String apellidoPaterno;

	@NotNull
	@Size(min=3, message = "Ingresar apellido minimo 3 caracteres" )
	private String apellidoMaterno;
	
	@NotNull
	@Size(min=5, message = "Ingresar dirección minimo 10 caracteres" )
	private String direccion;
	
	@NotNull
	@Size(min=7, max=12, message = "Número telefónico entre 7 y 12 digitos" )
	private String telefono;
		

	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

	
	//constructores
	
	public Contacto() {
		super();
	} 
	
	public Contacto(@NotNull @Size(min = 3, message = "Ingresar nombre minimo 3 caracteres") String nombre,
			@NotNull @Size(min = 3, message = "Ingresar apellido minimo 3 caracteres") String apellidoPaterno,
			@NotNull @Size(min = 3, message = "Ingresar apellido minimo 3 caracteres") String apellidoMaterno,
			@NotNull @Size(min = 5, message = "Ingresar dirección minimo 10 caracteres") String direccion,
			@NotNull @Size(min = 7, max = 12, message = "Número telefónico entre 7 y 12 digitos") String telefono) {
		super();
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	//getters&setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	//PrePersist crea por nosotros antes de la persistencia
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
			
	//PreUpdate crea por nosotros la fecha antes de la persistencia
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}




	
	
	
}