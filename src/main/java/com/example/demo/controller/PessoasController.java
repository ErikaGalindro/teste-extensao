package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pessoas;
import com.example.demo.service.PessoasService;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

	@Autowired
	PessoasService PessoasService;

	@PostMapping
	public Pessoas save(@RequestBody Pessoas Pessoas) {
		return PessoasService.save(Pessoas);
	}

	@GetMapping
	public List<Pessoas> getAll() {
		return PessoasService.getAll();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePessoa(@PathVariable(value = "id") Integer id) {
		return PessoasService.deleteById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pessoas> updateAviso(@PathVariable(value = "id") Integer id, @RequestBody Pessoas pessoas) {

		return PessoasService.updatePessoa(id, pessoas);
	}
}
