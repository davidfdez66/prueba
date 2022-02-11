package com.example.prueba.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import com.example.prueba.model.UserTest;
import com.example.prueba.services.ServiceEjemplo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@Api("Ejemplo api")
@RestController
@Validated
public class RESTController {
	
	@Autowired
	private ServiceEjemplo service;
	
	//CAPTURA DE EXCEPCIÓN
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e){
		return new ResponseEntity<>("Ha habido un error de validacion: "+e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
	
    // MUESTRA HELLO WORLD!
	@RequestMapping(method=RequestMethod.GET, value="/hello")
	@ResponseBody
	public String mensaje() {
		return service.muestraString();
	}
	
	
	// GET CONSULTA USUARIOS
	@ApiOperation(value = "Delete a role binding")
	@ApiResponses({
		@ApiResponse(code = 200, message = "ok"),
		@ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal server error")
	})	
	@RequestMapping(method=RequestMethod.GET, value="/users")
	@ResponseBody
	public List<UserTest> getUser() {
		
		return service.consultaTabla();
	}
	
	// DELETE USUARIO POR ID
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	@ResponseBody
	public UserTest borrar(@PathVariable int id) {
		return service.borrarId(id);
	}
	
	// INSERT NUEVO USUARIO
	@RequestMapping(method=RequestMethod.POST, value="/users")
	@ResponseBody
	public UserTest agregarCampo(@RequestBody UserTest ut){
		return service.agregarCampo(ut);
	}
	
	// UPDATE USUARIO
	@RequestMapping(method=RequestMethod.POST, value="/update")
	@ResponseBody
	public UserTest update(@RequestBody UserTest ut) {
		return service.agregarCampo(ut);
	}
	
	
	
}
