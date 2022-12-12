package com.codegym.be.service;

import com.codegym.be.model.Lego;

import java.util.List;

public interface ILegoService {

    List<Lego> getAllLego(String nameLego);

    void createLego(Lego lego);

    void updateLego(Lego lego);

    void deleteLego(Integer id);

}
