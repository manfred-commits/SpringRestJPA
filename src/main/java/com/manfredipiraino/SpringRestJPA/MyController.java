package com.manfredipiraino.SpringRestJPA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyController {

	@Autowired 
	private MyService myService;
	
	@GetMapping(value="/mygetalluser")
	public List<MyUser> myGetAllUsers() {
		List<MyUser> myResult=myService.myFindAllUsers();
		return myResult;
	}
	/*SORTER ASC*/
	@GetMapping(value="/mygetallusersorted")
	public List<MyUser> myGetAllUsersSorted() {
		List<MyUser> myResult=myService.myFindAllUsersSorted();
		return myResult;
	}
	
	@GetMapping("/mygetuserbyid/{id}")
	public Optional<MyUser> myGetUserById(@PathVariable int id){
		Optional<MyUser> myResult= myService.myFindUserById(id);
		return myResult;
	}
	@GetMapping("/mygetuserbyname/{name}")
	public Optional<List<MyUser>> myGetUserByName(@PathVariable String name){
		Optional<List<MyUser>> myResult= myService.myFindUserByName(name);
		return myResult;
	}	
	@PostMapping(value = "/mypostinsertuser", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public void myPostParams(@RequestParam String nome, String cognome, int eta) {
		myService.myInsertUserParams(nome, cognome, eta);
	}
	@PostMapping(value = "/mypostinsertuserobj", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String myPostObj(@RequestBody MyUser myUser) {
		return myService.myInsertUserObj(myUser);
	}
	
	/*PAGINAZIONE*/
	@GetMapping(value="/mygetallpages")
	public Page<MyUser> myGetAllUsersPage(Pageable pageable){
		return myService.myFindAllUsersPageable(pageable);
	}
	/*paginazione con parametri size e page, con valori di default opzionali*/
	@GetMapping(value="/mygetalluserspagesize")
	public Page<MyUser> myGetAllUsersPageSize(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue="3") int size){
		Page<MyUser> usersPages= myService.myFindAllUsersPageSize(page, size);
		/*Map<String,Object> myResponse= new HashMap<>();
		 * myResponse.put("users",usersPages);
		 * myResponse.put("currentPage, usersPages.getNumber());
		 * myResponse.put("totalItems", usersPages.getTotalElements();
		 * myRespones.put*/
		return usersPages;
	}
	@GetMapping(value="/mygetalluserspagesizesort")
	public List<MyUser> myGetAllUsersPageSizeSort(
			@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="3") Integer size,
			@RequestParam(defaultValue="desc") String dir,
			@RequestParam(defaultValue="age") String sort){
		
		return myService.myFindAllUsersPageSizeSort(page,size,dir,sort);
	}
	

}
