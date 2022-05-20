package com.desafiolatam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Contacto;
import com.desafiolatam.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	ContactRepository contactRepository;
	
	public Contacto save(Contacto contact) {
		return contactRepository.save(contact);
	}
	
	public void deleteById(Long id) {
		contactRepository.deleteById(id);
	}
	
	public List<Contacto>findAll(){
		return contactRepository.findAll();
	}
}
