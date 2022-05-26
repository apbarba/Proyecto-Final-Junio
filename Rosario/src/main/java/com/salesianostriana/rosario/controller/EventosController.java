package com.salesianostriana.rosario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.rosario.model.Eventos;
import com.salesianostriana.dam.rosario.servicios.EventosServicios;

@Controller
public class EventosController {

	@Autowired
	private EventosServicios eventos;

	public EventosController(EventosServicios eventos) {
		super();
		this.eventos = eventos;
	}
	
	@GetMapping("/list")
	public String listarTodos (Model model) {
		
		model.addAttribute("lista", eventos.findAll());
		
		return "eventos";
	}
	
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		
		model.addAttribute("eventos", new Eventos());
		
		return "formularioEvento";
	}
	
	@PostMapping("/nuevo/submit")
	public String procesarFormulario(@ModelAttribute("eventos") Eventos e) {
		
		eventos.add(e);
		
		return "redirect:/list";
	}
	
	@GetMapping("/editar/{id}")
	public String editarEvento(@PathVariable("id") long id, Model model) {
		
		Eventos editar = eventos.findById(id);
		
		if(editar != null) {
			
			model.addAttribute("eventos", editar);
			
			return "formularioEvento";
			
		}else {
			
			return "redirect:/list";
		}
	}
	
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("eventos") Eventos e) {
		
		eventos.edit(e);
		
		return "redirect:/list";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrarEvento(@PathVariable("id") long id) {
		
		eventos.delete(id);
		
		return "redirect:/list";
	}
	
}
