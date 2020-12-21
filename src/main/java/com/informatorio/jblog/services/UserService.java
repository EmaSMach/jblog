package com.informatorio.jblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.informatorio.jblog.repository.UserRepository;
import com.informatorio.jblog.models.User;


// Implemento el servicio, usando la Interfaz de usario IUser
@Service
public class UserService implements IUser{
    // para no crear múltiples instancias durante la vida de la aplicación
    @Autowired
    private UserRepository userRepository; 

    // sobreescribo e implemento los métodos de la interfaz
    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUser(Long id){
        // findById retorna un Optional, por lo tanto arrojamos un error en caso de no encontrar el objeto
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}