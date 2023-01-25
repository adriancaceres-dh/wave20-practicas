package com.bootcamp.MiniSeries.service;

import com.bootcamp.MiniSeries.model.MiniSerie;

import java.util.List;

public interface IMiniSerieService {
    public List<MiniSerie> getMiniSeries();
    public void saveMiniSerie(MiniSerie miniserie);
    public void deleteMiniSerie(Long id);
    public MiniSerie findMiniSerie(Long id);
}
