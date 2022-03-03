package com.manfredipiraino.SpringRestJPA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	
	@Autowired MyUserRepository myUserRepository;
	@Autowired MyUserPagingRepository myUserPagingRepository;
	
	public List<MyUser> myFindAllUsers(){
		return myUserRepository.findAll();
	}
	public Optional<MyUser> myFindUserById(int id){
		return myUserRepository.findById(id);
	}
	public Optional<List<MyUser>> myFindUserByName(String name) {
		return myUserRepository.findByName(name);
	}
	public void myInsertUserParams(String nome, String cognome, int eta) {
		myUserRepository.save(new MyUser(nome, cognome, eta));
	}
	public String myInsertUserObj(MyUser myUser) {
		myUserRepository.save(myUser);
		MyUser myUserRet= myUserRepository.save(myUser);
		return "Complimenti: "+ myUserRet.getName()+ " è dei nostri!";
	}
	public Page<MyUser> myFindAllUsersPageable(Pageable pageable){
		return myUserPagingRepository.findAll(pageable);
	}
	public Page<MyUser> myFindAllUsersPageSize(Integer page, Integer size){
		Pageable pageable=PageRequest.of(page, size);
		//Page<MyUser> pagedResult = myUserPagingRepository.findAll(pageable);
		return myUserPagingRepository.findAll(pageable);
		
		/*if(pagedResult.hasContent()) {
			return pagedResult;
		}else {
			return null;
		}*/
	}
	
	public List<MyUser> myFindAllUsersSorted(){
		return myUserRepository.findByOrderByNameDesc();
	}
	public List<MyUser> myFindAllUsersPageSizeSort(Integer page, Integer size, String dir, String sort){
		Pageable pageable= PageRequest.of(page,size,Sort.Direction.fromString(dir),sort);
		Page<MyUser> pagedResult= myUserPagingRepository.findAll(pageable);
		if(pagedResult.hasContent()) {
			return pagedResult.getContent();
		}else {
			return new ArrayList<MyUser>();
		}
	}
}
