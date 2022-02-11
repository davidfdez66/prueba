package com.example.prueba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.prueba.excepciones.RestResponseEntityExceptionHandler;
import com.example.prueba.model.UserTest;
import com.example.prueba.repository.TestRepository;



@Service
public class ServiceEjemplo {
	@Autowired
	private RestResponseEntityExceptionHandler res;
	
	@Autowired
	private TestRepository tr;
	
	@Value("${course.message}")
	private String hello;
	
	public String muestraString() {
		return hello;
	}

	public List<UserTest> consultaTabla() {
		return tr.findAll();
	}
	
	public UserTest borrarId(int id) {
		return tr.deleteById(id);
	}
	
	public UserTest agregarCampo(UserTest ut) throws IllegalStateException{
		
		return tr.save(ut);
	}

}
