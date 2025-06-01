package com.example.warehouse.dto.request;

import com.example.warehouse.enums.BlockType;

public record BlockRequest(
        double height,
        double length,
        double breath,
        BlockType type
) {
}
