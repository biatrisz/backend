package com.APICursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.APICursos.entities.cursos;
import com.APICursos.service.cursoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping ("/cursos")
@CrossOrigin(origins = "*)
public class cursosController {
	private final cursoService cursoService;

	@Autowired
	public cursosController(cursoService cursoService) {
		this.cursoService = cursoService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<cursos> getProductById(@PathVariable Long id) {
		cursos cursos = cursoService.getCursosById(id);
		if (cursos != null) {
			return ResponseEntity.ok(cursos);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping
	public ResponseEntity<List<cursos>> getAllcursos() {
		List<cursos> cursos = cursoService.getAllcursos();
		return ResponseEntity.ok(cursos);
	}
	@PostMapping
	public ResponseEntity<cursos> criarcursos(@RequestBody @Valid cursos cursos){
		cursos criarcursos = cursoService.salvarCursos(cursos);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarcursos);
	}-
	@PutMapping("/{id}")
	public ResponseEntity<cursos> updateCurso(@PathVariable Long id, @RequestBody @Valid cursos cursos) {
		cursos updatedCurso = cursoService.updateCurso(id, cursos);
		if (updatedCurso != null) {
			return ResponseEntity.ok(updatedCurso);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")

	public ResponseEntity<String> deletecursos(@PathVariable Long id) {
		boolean deleted = cursoService.deletecurso(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}




