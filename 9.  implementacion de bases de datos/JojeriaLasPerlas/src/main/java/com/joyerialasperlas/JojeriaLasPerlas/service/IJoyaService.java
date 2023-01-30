package com.joyerialasperlas.JojeriaLasPerlas.service;

import com.joyerialasperlas.JojeriaLasPerlas.model.Joya;

import java.util.List;

public interface IJoyaService {
    public void saveJoya(Joya joya);
    public void deleteJoya(Long id);
    public List<Joya> getJoyas();
    public Joya findJoya(Long id);
    public Joya updateJoya(Long id, Joya joyaNueva);

}
