package com.ufpb.Projectsocialapi;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository<T, ID extends Serializable> extends JpaRepository<Action, Integer> {

}
