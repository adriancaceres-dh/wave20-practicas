package com.withHibernate.Burami.repository;

import com.withHibernate.Burami.entity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

public interface IJoyasRepository extends JpaRepository<Joya, Long> {

}
