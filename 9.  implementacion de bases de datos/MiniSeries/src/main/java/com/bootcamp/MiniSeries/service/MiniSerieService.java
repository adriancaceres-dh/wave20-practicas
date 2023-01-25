package com.bootcamp.MiniSeries.service;

import com.bootcamp.MiniSeries.model.MiniSerie;
import com.bootcamp.MiniSeries.repository.IMiniSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MiniSerieService implements IMiniSerieService{

    @Autowired
    private IMiniSerieRepository miniSerieRepository;
    @Override
    @Transactional(readOnly = true)
    public List<MiniSerie> getMiniSeries() {
        return miniSerieRepository.findAll();
    }

    @Override
    @Transactional
    public void saveMiniSerie(MiniSerie miniserie) {
        this.miniSerieRepository.save(miniserie);
    }

    @Override
    @Transactional
    public void deleteMiniSerie(Long id) {
        this.miniSerieRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public MiniSerie findMiniSerie(Long id) {
        return this.miniSerieRepository.findById(id).orElse(null);
    }
}
