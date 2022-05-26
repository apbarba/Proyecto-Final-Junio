package com.salesianostriana.dam.rosario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Productos {

	@Id
	@GeneratedValue
	private long id;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private String nombre;
	private int cantidad;
	private double precio;
	
	@Column(length = 1000)
	private  String img;
	
//	@ManyToOne
//	private Categoria categoria;

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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

//	public Categoria getCategoria() {
//		return categoria;
//	}
//
//	public void setCategoria(Categoria categoria) {
//		this.categoria = categoria;
//	}
}
