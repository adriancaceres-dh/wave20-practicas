package com.bootcamp.movies_hql.service.series;

import com.bootcamp.movies_hql.dto.SeriesDTO;
import com.bootcamp.movies_hql.repository.ISeriesRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeriesServiceImpl implements ISeriesService {

    private final ISeriesRepository seriesRepository;
    ModelMapper modelMapper = new ModelMapper();

    public SeriesServiceImpl(ISeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public Set<SeriesDTO> getSeriesBySeasonCountGreaterThan(Integer count) {
        return seriesRepository.findBySeasonCountGreaterThan(count).stream()
                .map(series -> modelMapper.map(series, SeriesDTO.class)).collect(Collectors.toSet());
    }
}
