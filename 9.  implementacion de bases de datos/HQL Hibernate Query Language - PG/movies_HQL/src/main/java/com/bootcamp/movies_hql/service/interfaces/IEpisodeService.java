package com.bootcamp.movies_hql.service.interfaces;

import com.bootcamp.movies_hql.dto.response.EpisodeDTO;
import com.bootcamp.movies_hql.service.interfaces.generics.ICrudService;
import java.util.List;

public interface IEpisodeService extends ICrudService<EpisodeDTO, Long> {

    // Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
    List<EpisodeDTO> getEpisodesWithActorNameEqualsThan(String name);
}
