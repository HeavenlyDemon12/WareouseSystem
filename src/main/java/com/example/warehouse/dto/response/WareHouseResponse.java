package com.example.warehouse.dto.response;

public record WareHouseResponse(
    String warehouseId,
    String name,
    String city,
    String address,
    String landmark
) {
}
