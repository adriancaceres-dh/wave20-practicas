package com.example.demo.elasticrepositories;

import com.example.demo.domain.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {

    @Query("{\"bool\": {\"filter\": [{\"term\": {\"edad\": \"?0\"}}]}}")
    List<Empleado> findByEdad(String edad);


}


