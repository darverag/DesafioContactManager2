package com.desafiolatam.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desafiolatam.models.Contacto;
import com.desafiolatam.services.ContactService;

@Controller
@RequestMapping("/contactManager")
public class ContactoController {

	@Autowired
	ContactService contactService;

	@RequestMapping("") // http://localhost:9080/contactManager
	public String showContactManager(@ModelAttribute("contacto") Contacto contacto, 
			Model model) {
				model.addAttribute("listaContacto", contactService.findAll());
		return "contactManager";
	}
	
	

	//Se capturan datos desde JSP
	@PostMapping("") // http://localhost:9080/contactManager
	public String registrar(@Valid @ModelAttribute("contacto") Contacto contacto, BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes) {
		// validar
		if (!result.hasErrors()) {
			//Se guarda información en BD
			contactService.save(contacto);

			// Se envia mensaje
			redirectAttributes.addFlashAttribute("msgOk", "Contacto se crea correctamente!!!");
			return "redirect:/contactManager";
		} else {
			model.addAttribute("listaContacto", contactService.findAll());
			// En caso de error se envia mensaje
			redirectAttributes.addFlashAttribute("msgError", "Información incompleta, reintente de nuevo!!");
			// Se redirige a vista
			return "contactManager";
		}
	}
	
	

	// Metodo eliminar
	// http://localhost:9080/contactManager/deleteContact/${id}
	@RequestMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		contactService.deleteById(id);
		redirectAttributes.addFlashAttribute("msgOk", "Contacto correctamente eliminado");
		return "redirect:/contactManager";
	}
}

