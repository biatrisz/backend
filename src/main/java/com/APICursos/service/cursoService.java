package com.APICursos.service;




	import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APICursos.entities.cursos;
import com.APICursos.repository.cursoRepository;

@Service
	public class cursoService {
		private final cursoRepository cursoRepository; 
		@Autowired
		 public cursoService(cursoRepository cursoRepository) {
	       this.cursoRepository = cursoRepository;
	   }

	   public List<cursos> getAllcursos (){
	       return cursoRepository.findAll();
	   }

	   public cursos getCursosById(Long id) {
	       Optional<cursos> Cursos = cursoRepository.findById(id);
	       return Cursos.orElse(null);
	   }

	   public cursos salvarCursos(cursos cursos) {
	       return cursoRepository.save(cursos);
	   }

	   public cursos updateCurso(Long id, cursos updatedcurso) {
	       Optional<cursos> existingCurso = cursoRepository.findById(id);
	       if (existingCurso.isPresent()) {
	           updatedcurso.setId(id);
	           return cursoRepository.save(updatedcurso);
	       }
	       return null;
	   }

	   public boolean deletecurso(Long id) {
	       Optional<cursos> existingCurso = cursoRepository.findById(id);
	       if (existingCurso.isPresent()) {
	           cursoRepository.deleteById(id);
	           return true;
	       }
	       return false;
	   }
	}


