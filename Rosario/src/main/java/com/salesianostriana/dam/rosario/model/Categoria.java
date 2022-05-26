package com.salesianostriana.dam.rosario.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categoria {

	@Id
	@GeneratedValue
	private long id;
	
	private String nombre;
	private String descripción;
	
//	@EqualsAndHashCode.Exclude
//	@ToString.Exclude
//	@OneToMany(mappedBy="categorias", fetch = FetchType.EAGER)
//	private List<Productos> productos = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

//	public List<Productos> getProductos() {
//		return productos;
//	}
//
//	public void setProductos(List<Productos> productos) {
//		this.productos = productos;
//	}

}
