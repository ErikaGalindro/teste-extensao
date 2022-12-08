package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pessoas;
import com.example.demo.repository.PessoasRepository;

@Service
public class PessoasService {

	@Autowired
	PessoasRepository pessoasRepository;

	public Pessoas save(Pessoas Pessoas) {
		return pessoasRepository.save(Pessoas);

	}

	public List<Pessoas> getAll() {
		return pessoasRepository.findAll();

	}

	public ResponseEntity<?> deleteById(Integer id) {
		try {
			pessoasRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Pessoas> updatePessoa(Integer id, Pessoas pessoas) {
		try {
			pessoas.setId(id);
			return new ResponseEntity<>(pessoasRepository.save(pessoas), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
