package com.salesianostriana.dam.rosario.servicios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.rosario.model.Eventos;
import com.salesianostriana.dam.rosario.repository.EventosRepository;

@Service
public class EventosServicios {

	@Autowired
	private EventosRepository eventos;

	public EventosServicios(EventosRepository eventos) {
		super();
		this.eventos = eventos;
	}
	
	
	public Eventos add(Eventos e) {
		
		return eventos.save(e);
	}
	
	public Eventos edit(Eventos e) {
		
		return eventos.save(e);
	}
	
	public void delete(Eventos e) {
		
		eventos.delete(e);
	}
	
	public void delete(long id) {
		
		eventos.deleteById(id);
	}
	
	public List<Eventos> findAll(){
		
		return eventos.findAll();
	}
	
	public Eventos findById(long id) {
		
		return eventos.findById(id).orElse(null);
	}
	
	/**
	 * Implementamos una lógica de negocio, la cual añadirá un eventos si la fecha
	 * que se implementa está libre, si no es así, no se añadirá.
	 * 
	 * @param fecha
	 * @return
	 */
	public boolean eventoFecha(LocalDate fecha) {
		
		boolean colapsarFechaEventos = false;
		
		for (Eventos eventos : eventos.findAll()) {
			
			if (eventos.getFecha().equals(fecha)) {
				
				return true;
			}
		}
		return false;
	}
}
