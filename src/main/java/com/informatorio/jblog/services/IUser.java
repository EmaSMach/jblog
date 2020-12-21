package com.informatorio.jblog.services;

import java.util.List;
import com.informatorio.jblog.models.User;


// defino la interfaz Usuario // uso Long en vez de long com tipo de dato.
public interface IUser {
    public abstract List<User> getAllUsers();
    public abstract User getUser(Long id);
    public abstract User createUser(User user);
    public abstract void deleteUser(Long id); 
}
