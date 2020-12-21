package com.informatorio.jblog.services;

// implementamos una simple clase que es nuestra excepción
public class UserNotFoundException extends RuntimeException{
    UserNotFoundException(Long id){
        super("No se pudo encontrar el usuarion con id: " + id);
    }
}
