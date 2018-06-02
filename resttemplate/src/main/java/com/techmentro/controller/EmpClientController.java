package com.techmentro.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.techmentro.entity.Emp;


@RestController
@RequestMapping("/empClient")
public class EmpClientController {

	private static final String uri="http://localhost:8080/emps/";
	
	@GetMapping("/{id}")
	public  Emp getEmp(@PathVariable int id) throws Exception
	{
		RestTemplate template=new RestTemplate();
		String url=uri+id;
        //Emp emp=template.getForObject(url, Emp.class);
		  ResponseEntity<Emp> entity=template.getForEntity(url, Emp.class);	
		  return entity.getBody();
		  		
	}
	@GetMapping("/")
	public  Emp[] allEmp() throws Exception
	{
		RestTemplate template=new RestTemplate();
		
        Emp[] arr=template.getForObject(uri, Emp[].class );
        return arr;
		 
		  
		
	}
	
	@PostMapping("/")
	public  String save(@RequestBody Emp e) throws Exception
	{
		RestTemplate template=new RestTemplate();
		
          ResponseEntity<String> entity=template.postForEntity(uri, e, String.class);	
		  return entity.getBody();
		  
		
	}
	
	@PutMapping("/")
	public  String update(@RequestBody Emp e) throws Exception
	{
		RestTemplate template=new RestTemplate();
		
          template.put(uri, e);	
          return "successfully updated.";
		 
		  
		
	}
	
	@DeleteMapping("/{id}")
	public  String Remove(
			@PathVariable int id) throws Exception
	{
		RestTemplate template=new RestTemplate();
		String url=uri+id;
         ResponseEntity<Emp> entity=template.getForEntity(url, Emp.class);	
		  if(entity.hasBody())
		  {
			  Emp e=entity.getBody();
			  System.out.println(e.getName()+" will be deleted.");
          template.delete(uri, e);	
          return "successfully delete.";
		  }
		  else
			 return "Invalid Id."; 
		 
		  
		
	}
}
