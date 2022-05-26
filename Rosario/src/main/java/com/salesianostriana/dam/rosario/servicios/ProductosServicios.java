package com.salesianostriana.dam.rosario.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.rosario.model.Productos;
import com.salesianostriana.dam.rosario.repository.ProductosRepository;

@Service
public class ProductosServicios {

	@Autowired
	private ProductosRepository productos;

	public ProductosServicios(ProductosRepository productos) {
		super();
		this.productos = productos;
	}
	
	public Productos add(Productos p) {
		
		return productos.save(p);
	}
	
	public Productos edit(Productos p) {
		
		return productos.save(p);
	}
	
	public void delete(Productos p) {
		
		productos.delete(p);
	}
	
	public void delete(long id) {
		
		productos.deleteById(id);
	}
	
	public List<Productos> findAll(){
		
		return productos.findAll();
	}
	
	public Productos findById(long id) {
		
		return productos.findById(id).orElse(null);
	}
	
	/**
	 * Lógica de negocio que definimos en la clase servicios de productos
	 * @param nombre
	 * @return
	 */
//	public List<Productos> buscarPorCategoriaONombre(String nombre) {
//		
//		return productos.findByNombreContainsIgnoreCaseOrCategoriasNombreContainsIgnoreCase(nombre, nombre);
//	}
}
