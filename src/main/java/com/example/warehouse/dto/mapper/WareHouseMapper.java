package com.example.warehouse.dto.mapper;

import com.example.warehouse.dto.request.UserRegistrationRequest;
import com.example.warehouse.dto.request.WareHouseRequest;
import com.example.warehouse.dto.response.WareHouseResponse;
import com.example.warehouse.entity.User;
import com.example.warehouse.entity.WareHouse;
import org.springframework.stereotype.Controller;

@Controller
public class WareHouseMapper {
    public WareHouse toEntity(WareHouseRequest source, WareHouse target){
        if (source == null) {
            return target;
        }
        if (target == null) {
            target = new WareHouse();
        }
        target.setName(source.name());
        target.setCity(source.city());
        target.setAddress(source.address());
        target.setLandmark(source.landmark());
        return target;
    }

    public WareHouseResponse toResponse(WareHouse wareHouse) {
        if (wareHouse==null)
            return null;
        return new WareHouseResponse(
                wareHouse.getWarehouseId(),
                wareHouse.getName(),
                wareHouse.getCity(),
                wareHouse.getAddress(),
                wareHouse.getLandmark()
        );
    }
}
