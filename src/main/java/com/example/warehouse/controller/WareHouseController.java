package com.example.warehouse.controller;

import com.example.warehouse.dto.request.WareHouseRequest;
import com.example.warehouse.dto.response.WareHouseResponse;
import com.example.warehouse.dto.wrapper.ResponseStructure;
import com.example.warehouse.entity.WareHouse;
import com.example.warehouse.service.contract.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WareHouseController {

    @Autowired
    private WareHouseService wareHouseService;

    @PostMapping("/warehouses/{userId}")
    public ResponseEntity<ResponseStructure<WareHouseResponse>> createWareHouse(@RequestBody WareHouseRequest wareHouseRequest, @PathVariable String userId){

       WareHouseResponse wareHouseResponse = wareHouseService.createWareHouse(wareHouseRequest,userId);
       ResponseStructure<WareHouseResponse> responseStructure = new ResponseStructure<>(HttpStatus.CREATED.value(), "WareHouse Created Successfuly",wareHouseResponse);
       return new ResponseEntity<ResponseStructure<WareHouseResponse>>(responseStructure,HttpStatus.CREATED);
    }

}
