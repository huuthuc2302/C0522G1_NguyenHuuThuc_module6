package com.example.legomanagerbe.controller;

import com.example.legomanagerbe.model.Lego;
import com.example.legomanagerbe.service.ICategoryService;
import com.example.legomanagerbe.service.ILegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class LegoController {

    @Autowired
    private ILegoService iLegoService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/categoryList")
    public ResponseEntity<?> getAllCategory() {
        return new ResponseEntity<>(iCategoryService.getAllCategory(), HttpStatus.OK);
    }

    @GetMapping("/legoList")
    public ResponseEntity<?> getAllBenXe(@RequestParam(name = "nameLego", defaultValue = "") String nameLego) {
        return new ResponseEntity<>(iLegoService.getAllLego(nameLego), HttpStatus.OK);
    }

    @PostMapping("/legoList")
    public ResponseEntity<?> create(@RequestBody Lego lego) {
        iLegoService.createLego(lego);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/legoList")
    public ResponseEntity<?> update(@RequestBody Lego lego) {
        iLegoService.updateLego(lego);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/legoList/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        iLegoService.deleteLego(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
