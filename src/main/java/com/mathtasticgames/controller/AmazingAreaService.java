package com.mathtasticgames.controller;

import com.mathtasticgames.persistence.Users;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/services")
public class AmazingAreaService extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet classes = new HashSet<Class<?>>();
        classes.add(Users.class );
        return classes;
    }
}
