package com.empleados.EmpleadosElastic.elasticrepositories;

import com.empleados.EmpleadosElastic.domain.Empleado;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, Integer> {

    //@Query("{\"bool\": {\"filter\": [{\"term\": {\"edad\": \"?0\"}}]}}")
    List<Empleado> findByEdad(String edad);

    List<Empleado> findByNombreContains(String nombre);

    @Query("{\n" +
            "    \"bool\": {\n" +
            "      \"must\": [ \n" +
            "        {\n" +
            "          \"term\": {\n" +
            "            \"nombre\": {\n" +
            "              \"value\": \"?0\"\n" +
            "            }\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"term\": {\n" +
            "            \"edad\": {\n" +
            "              \"value\": \"?1\"\n" +
            "            }\n" +
            "          }\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  }")
    List<Empleado> findbyloqueseaesto(String nombre, String edad);

    @Query("{\"bool\": {\"must\": [{\"match_phrase\": {\"nombre\": {\"query\": \"?0\",\"options\": \"lowercase_expanded_terms\"}}}, {\"match_phrase\": {\"edad\": {\"query\": \"?1\",\"options\": \"lowercase_expanded_terms\"}}}]}}")
    List<Empleado> findByNombreEqualsAndEdadEquals(String nombre, String edad);
}


