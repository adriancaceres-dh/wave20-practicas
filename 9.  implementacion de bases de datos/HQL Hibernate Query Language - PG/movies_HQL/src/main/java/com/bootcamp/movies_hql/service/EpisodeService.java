package com.bootcamp.movies_hql.service;

import com.bootcamp.movies_hql.dto.response.EpisodeDTO;
import com.bootcamp.movies_hql.dto.response.MovieDTO;
import com.bootcamp.movies_hql.dto.response.SerieDTO;
import com.bootcamp.movies_hql.entity.Episode;
import com.bootcamp.movies_hql.exception.NotFoundException;
import com.bootcamp.movies_hql.repository.IEpisodeRepository;
import com.bootcamp.movies_hql.repository.ISeasonRepository;
import com.bootcamp.movies_hql.service.interfaces.IEpisodeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeService implements IEpisodeService {

    @Autowired
    IEpisodeRepository episodeRepository;

    @Autowired
    ISeasonRepository seasonRepository;

    private final ModelMapper mapper = new ModelMapper();

    public EpisodeService() {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true);
    }

    @Override
    public EpisodeDTO saveEntity(EpisodeDTO crudDTO) {
        var entity = mapper.map(crudDTO, Episode.class);

        var entityGenre = seasonRepository.findById(crudDTO.getSeason().getId()).get();

        entity.setSeason(entityGenre);

        entity = episodeRepository.save(entity);

        return mapper.map(entity, EpisodeDTO.class);
    }

    @Override
    public EpisodeDTO getEntityById(Long id) {
        if (!episodeRepository.existsById(id)) {
            throw new NotFoundException("Ese episodio no existe.");
        }
        Episode episode = episodeRepository.findById(id).get();
        return mapper.map(episode, EpisodeDTO.class);
    }

    @Override
    public List<EpisodeDTO> getAllEntities() {
        return episodeRepository.findAll().stream().map(m -> mapper.map(m, EpisodeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public String deleteEntity(Long id) {
        if (!episodeRepository.existsById(id)) {
            throw new NotFoundException("Ese episodio no existe.");
        }
        Episode episode = episodeRepository.findById(id).get();
        String title = episode.getTitle();
        episodeRepository.deleteById(id);
        return "Se ha eliminado el episodio: " + title;
    }


    // Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
    @Override
    public List<EpisodeDTO> getEpisodesWithActorNameEqualsThan(String name) {
        return episodeRepository.findEpisodeByActorsFirstNameEquals(name).stream().map(m -> mapper.map(m, EpisodeDTO.class))
                .collect(Collectors.toList());
    }
}
