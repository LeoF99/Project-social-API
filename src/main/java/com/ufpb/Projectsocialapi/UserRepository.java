package com.ufpb.Projectsocialapi;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository<T, ID extends Serializable> extends JpaRepository<User, Integer>{
	
}
