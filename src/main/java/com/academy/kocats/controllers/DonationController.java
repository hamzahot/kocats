package com.academy.kocats.controllers;


import com.academy.kocats.dto.donation.DonationDTO;
import com.academy.kocats.dto.product.command.ProductCreateDTO;
import com.academy.kocats.dto.product.query.ProductQueryDTO;
import com.academy.kocats.services.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donation")
public class DonationController {


    @Autowired
    private DonationService donationService;


    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody DonationDTO donationDTO){
        donationService.insert(donationDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<DonationDTO>> getAll(){
        List<DonationDTO> donationDTOS = donationService.getAll();
        return new ResponseEntity<>(donationDTOS, HttpStatus.OK);
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<DonationDTO> getById(@PathVariable("id") Integer id){
        DonationDTO donationDTO = donationService.getDonationById(id);
        return new ResponseEntity<>(donationDTO, HttpStatus.OK);
    }



    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id){
        donationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
