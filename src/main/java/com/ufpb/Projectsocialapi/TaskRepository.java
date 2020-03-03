package com.ufpb.Projectsocialapi;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository<T, ID extends Serializable> extends JpaRepository<Task, Integer> {

}
