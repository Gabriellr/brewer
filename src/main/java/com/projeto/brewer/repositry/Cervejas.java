package com.projeto.brewer.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.brewer.model.Cerveja;

@Repository
public interface Cervejas  extends JpaRepository<Cerveja, Long>{
	

}
