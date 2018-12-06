package com.projeto.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.brewer.model.Estilo;
import com.projeto.brewer.repositry.Estilos;
import com.projeto.brewer.service.exception.NomeEstiloJaCadastradoException;

@Service
public class CadastroEstiloService {
	
	@Autowired
	private Estilos estilos;
	
	@Transactional
	public Estilo salvar(Estilo estilo){
		Optional<Estilo> estiloOptional = estilos.findByNomeIgnoreCase(estilo.getNome());
		if (estiloOptional.isPresent()){
		throw new NomeEstiloJaCadastradoException("Nome do estilo ja cadastrado");
		}
		return estilos.saveAndFlush(estilo);
	}


}
