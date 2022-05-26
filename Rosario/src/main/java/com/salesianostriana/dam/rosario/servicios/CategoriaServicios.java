package com.salesianostriana.dam.rosario.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.rosario.model.Categoria;
import com.salesianostriana.dam.rosario.repository.CategoriaRepository;

@Service
public class CategoriaServicios {

	@Autowired
	private CategoriaRepository categorias;

	public CategoriaServicios(CategoriaRepository categorias) {
		super();
		this.categorias = categorias;
	}
	
	public List<Categoria> findAll(){
		
		return categorias.findAll();
	}
	
	public Categoria save(Categoria c) {
		
		return categorias.save(c);
	}
	
	public Optional<Categoria> findByCategoriaId(Long id) {
		
		return categorias.findById(id);
	}
	
	public void delete(Long id) {
		
		categorias.deleteById(id);
	}
}
