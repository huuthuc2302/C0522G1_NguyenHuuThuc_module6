package com.example.legomanagerbe.service;

import com.example.legomanagerbe.model.Lego;

import java.util.List;

public interface ILegoService {

    List<Lego> getAllLego(String nameLego);

    void createLego(Lego lego);

    void updateLego(Lego lego);

    void deleteLego(Integer id);

}
