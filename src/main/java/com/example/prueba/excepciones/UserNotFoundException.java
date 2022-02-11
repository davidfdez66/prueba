package com.example.prueba.excepciones;

public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(int id) {
		super(String.format("Usuario no encontrado"));
	}

}
