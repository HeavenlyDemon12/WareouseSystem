package com.example.warehouse.dto.response;

import com.example.warehouse.enums.BlockType;

public record BlockResponse(
    String blockId,
    double height,
    double length,
    double breath,
    BlockType type
) {
}
