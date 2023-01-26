package com.bootcamp.elastic_empleados.elastic_repositories;

import com.bootcamp.elastic_empleados.model.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmpleadoElasticRepository extends ElasticsearchRepository<Empleado, String> {
}
