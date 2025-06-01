package com.example.warehouse.controller;

import com.example.warehouse.dto.request.BlockRequest;
import com.example.warehouse.dto.response.BlockResponse;
import com.example.warehouse.dto.wrapper.ResponseStructure;
import com.example.warehouse.service.contract.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockController {

    @Autowired
    private BlockService blockService;

    @PostMapping("blocks/{userId}")
    public ResponseEntity<ResponseStructure<BlockResponse>> createBlock(@RequestBody BlockRequest request, @PathVariable String userId){
       BlockResponse blockResponse = blockService.createBlock(request,userId);
       ResponseStructure<BlockResponse> responseStructure = new ResponseStructure<>(HttpStatus.CREATED.value(), "Block Created Successfully!",blockResponse);
       return new ResponseEntity<ResponseStructure<BlockResponse>>(responseStructure,HttpStatus.CREATED);
    }
}
