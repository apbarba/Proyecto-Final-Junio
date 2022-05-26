package com.salesianostriana.dam.rosario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.rosario.model.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long>{

	/**
	 * Método para buscar por categoria en la barra de búsqueda además de cualquier producto
	 * @param nombre
	 * @param nombre2
	 * @return
	 */
//	List<Productos> findByNombreContainsIgnoreCaseOrCategoriasNombreContainsIgnoreCase(String nombre, String nombre2);

}
