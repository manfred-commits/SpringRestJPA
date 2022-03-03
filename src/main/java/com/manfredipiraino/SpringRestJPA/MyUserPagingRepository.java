package com.manfredipiraino.SpringRestJPA;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MyUserPagingRepository extends PagingAndSortingRepository<MyUser, Integer>{
	
	/*Pageable*/
	/*Pageable pageable oggetto paginabile*/
	public Page<MyUser> findAll(Pageable pageable);
}
