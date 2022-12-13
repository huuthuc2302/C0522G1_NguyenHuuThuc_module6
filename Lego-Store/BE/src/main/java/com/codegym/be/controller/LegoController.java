package com.codegym.be.controller;

import com.codegym.be.jwt.JwtTokenUtil;
import com.codegym.be.model.Lego;
import com.codegym.be.payload.request.LoginRequest;
import com.codegym.be.payload.request.LoginResponse;
import com.codegym.be.service.ICategoryService;
import com.codegym.be.service.ILegoService;
import com.codegym.be.service.decentralization.impl.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/public")
@CrossOrigin("*")
public class LegoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private ILegoService iLegoService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/categoryList")
    public ResponseEntity<?> getAllCategory() {
        return new ResponseEntity<>(iCategoryService.getAllCategory(), HttpStatus.OK);
    }

    @GetMapping("/legoList")
    public ResponseEntity<?> getAllLego(@RequestParam(name = "nameLego", defaultValue = "") String nameLego) {
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


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateJwtToken(loginRequest.getUsername());
        MyUserDetails myUserDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roles = myUserDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return ResponseEntity.ok(
                new LoginResponse(
                        jwt,
                        myUserDetails.getUsername(),
                        roles));
    }

}
