package com.codegym.be.service.impl;

import com.codegym.be.model.Lego;
import com.codegym.be.repository.ILegoRepository;
import com.codegym.be.service.ILegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegoService implements ILegoService {

    @Autowired
    private ILegoRepository iLegoRepository;

    @Override
    public List<Lego> getAllLego(String nameLego) {
        return iLegoRepository.findAllLego("%" + nameLego + "%");
    }

    @Override
    public void createLego(Lego lego) {
        iLegoRepository.save(lego);
    }

    @Override
    public void updateLego(Lego lego) {
        iLegoRepository.updateLego(lego.getName(), lego.getPrice(), lego.getReleaseYear(),
                lego.getNumberOfPieces(), lego.getQuantity(), lego.getCategory().getId(), lego.getId());
    }

    @Override
    public void deleteLego(Integer id) {
        iLegoRepository.deleteLego(id);
    }

}
