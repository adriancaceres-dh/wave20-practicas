package com.joyeria.lasperlas.service;


import com.joyeria.lasperlas.model.Joya;

import java.util.List;

public interface IJoyaService {

    String addJoya(Joya joya);
    List<Joya> getJoyas();
    Joya findJoya(Long id);
    String inactivateJoya(Long id);
    String editJoya(Long id, Joya joyaModificada);

}
