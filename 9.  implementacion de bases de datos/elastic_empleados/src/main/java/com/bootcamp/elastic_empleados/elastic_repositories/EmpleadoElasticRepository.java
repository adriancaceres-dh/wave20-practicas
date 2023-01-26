package com.bootcamp.elastic_empleados.elastic_repositories;

import com.bootcamp.elastic_empleados.model.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EmpleadoElasticRepository extends ElasticsearchRepository<Empleado, String> {
    List<Empleado> findByNombreContains(String name);
}
