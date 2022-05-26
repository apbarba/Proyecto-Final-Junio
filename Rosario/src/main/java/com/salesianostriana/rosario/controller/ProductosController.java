package com.salesianostriana.rosario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.rosario.model.Categoria;
import com.salesianostriana.dam.rosario.model.Productos;
import com.salesianostriana.dam.rosario.servicios.CategoriaServicios;
import com.salesianostriana.dam.rosario.servicios.ProductosServicios;

@Controller
public class ProductosController {

	@Autowired
	private ProductosServicios productos;
	
	@Autowired
	private CategoriaServicios categorias;
	
	@GetMapping("/lista")
	public String mostrarProductos(Model model) {
		
		model.addAttribute("lista", productos.findAll());
		
		return "productos";
	}
	
//	@GetMapping("/buscar")
//	public String buscarPorNombreOCategoria(Model model, @RequestParam String nombre) {
//		
//		model.addAttribute("productos", productos.buscarPorCategoriaONombre(nombre));
//		
//		return "productos";
//	}
	
	@GetMapping("/nuevoProducto")
	public String productoNuevo(Model model) {
		
		model.addAttribute("productos", new Productos());
	//	model.addAttribute("categorias", categorias.findAll());
		
		return "formularioProductos";
	}
	
	@PostMapping("/productoNuevo/submit")
	public String procesarFormulario(@ModelAttribute("productos") Productos p) {
		
		productos.add(p);
		
		return "redirect:/lista";
	}
	
	@GetMapping("/editarProducto/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {		 
		
		Productos aEditar = productos.findById(id);
		
		if (aEditar != null) {
			
			model.addAttribute("productos", aEditar);
			
		//	model.addAttribute("categorias", categorias.findAll());
			
			return "formularioProductos";
			
		} else {
			
			return "redirect:/lista";
		}
		
		
	}
	
	@PostMapping("/editarProducto/submit")
	public String procesarFormularioEdicion(@ModelAttribute("productos") Productos p) {
		
		productos.edit(p);
		
		return "redirect:/lista";
	}
	
	@GetMapping("/borrarProducto/{id}")
	public String borrar(@PathVariable("id") long id) {
		
		productos.delete(id);
		
		return "redirect:/lista";
	}
	
//	@ModelAttribute("categorias")
//	public List<Categoria> categorias() {
//		
//		return categorias.findAll();
//	}
}
