package com.pending;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class Controller {
	
	@Autowired
	PendingInterface pendInterface;
	
	@GetMapping
	public List<Pending> getPending() {
		System.out.println("Peticion Get ");
		List<Pending> Pendings = new ArrayList();
		return Pendings = pendInterface.findAll();
	}
	
	@PostMapping
	public void addPending(@RequestBody Pending pending) {
		System.out.println("Peticion Post "+ pending);
		pendInterface.save(pending);	
	}
	
	@DeleteMapping("/{id}")
	public void deletePending(@PathVariable String id) {
		System.out.println("Peticion Delete "+ id);
		pendInterface.deleteById(id);
	}

}
