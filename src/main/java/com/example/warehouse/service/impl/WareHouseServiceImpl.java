package com.example.warehouse.service.impl;

import com.example.warehouse.dto.mapper.WareHouseMapper;
import com.example.warehouse.dto.request.WareHouseRequest;
import com.example.warehouse.dto.response.WareHouseResponse;
import com.example.warehouse.entity.Admin;
import com.example.warehouse.entity.User;
import com.example.warehouse.entity.WareHouse;
import com.example.warehouse.enums.UserRole;
import com.example.warehouse.exceptions.IllegalOperationException;
import com.example.warehouse.exceptions.UserNotFoundByIdException;
import com.example.warehouse.repository.UserRepository;
import com.example.warehouse.repository.WareHouseRepository;
import com.example.warehouse.service.contract.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WareHouseServiceImpl implements WareHouseService {
    @Autowired
    private WareHouseRepository wareHouseRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WareHouseMapper wareHouseMapper;

    @Override
    @Transactional
    public WareHouseResponse createWareHouse(WareHouseRequest wareHouseRequest, String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundByIdException("User Not Found By Id!!"));
        if (user instanceof Admin admin) {
            if (admin.getWarehouse() == null) {
                WareHouse wareHouse = wareHouseMapper.toEntity(wareHouseRequest, new WareHouse());
                admin.setWarehouse(wareHouse);
                wareHouseRepository.save(wareHouse);
                userRepository.save(admin);
                return wareHouseMapper.toResponse(wareHouse);
            }else throw new IllegalOperationException("Admin Already Has a Warehouse");
        }else
            throw new IllegalOperationException("User Not AN Admin!!");
    }
}
