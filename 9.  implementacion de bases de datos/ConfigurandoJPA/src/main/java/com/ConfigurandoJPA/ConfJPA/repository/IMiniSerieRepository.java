package com.ConfigurandoJPA.ConfJPA.repository;

import com.ConfigurandoJPA.ConfJPA.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie,Long> {
}
