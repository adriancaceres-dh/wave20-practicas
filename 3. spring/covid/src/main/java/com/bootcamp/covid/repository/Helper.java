package com.bootcamp.covid.repository;

import com.bootcamp.covid.model.NivelDeGravedad;
import com.bootcamp.covid.model.Persona;
import com.bootcamp.covid.model.Sintoma;
import com.bootcamp.covid.repository.factory.RepositoryFactory;

public class Helper {

    public static void fillWithTestData() {
        Repository<Persona> personaRepository = RepositoryFactory.get(Persona.class);
        Repository<Sintoma> sintomaRepository = RepositoryFactory.get(Sintoma.class);

        personaRepository.add(new Persona(1L, "Juan", "Pérez", 14));
        personaRepository.add(new Persona(1L, "Tomás", "Gómez", 21));
        personaRepository.add(new Persona(1L, "Evaristo", "Buenavida", 86));

        sintomaRepository.add(new Sintoma("A1", "Tos", NivelDeGravedad.LEVE));
        sintomaRepository.add(new Sintoma("A13", "Vómitos", NivelDeGravedad.MEDIO));
        sintomaRepository.add(new Sintoma("DE21", "Pérdida de memoria", NivelDeGravedad.GRAVE));
    }

}
