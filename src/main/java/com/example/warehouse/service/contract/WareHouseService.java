package com.example.warehouse.service.contract;

import com.example.warehouse.dto.request.WareHouseRequest;
import com.example.warehouse.dto.response.WareHouseResponse;

public interface WareHouseService {
    WareHouseResponse createWareHouse(WareHouseRequest wareHouseRequest, String userId);
}
