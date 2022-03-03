package com.manfredipiraino.SpringRestJPA;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser, Integer> {
	
	public Optional<List<MyUser>> findByName(String name);
	public List<MyUser> findByOrderByNameDesc();
}
