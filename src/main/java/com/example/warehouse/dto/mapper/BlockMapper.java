package com.example.warehouse.dto.mapper;

import com.example.warehouse.dto.request.BlockRequest;
import com.example.warehouse.dto.response.BlockResponse;
import com.example.warehouse.entity.Block;
import org.springframework.stereotype.Controller;

@Controller
public class BlockMapper {

    public Block toEntity(BlockRequest source, Block target){
        if (source == null) {
            return target;
        }
        if (target == null) {
            target = new Block();
        }
        target.setHeight(source.height());
        target.setLength(source.length());
        target.setBreath(source.breath());
        target.setType(source.type());
        return target;
    }

    public BlockResponse toResponse(Block block){
        if (block == null) {
            return null;
        }
        return new BlockResponse(
            block.getBlockId(),
            block.getHeight(),
            block.getLength(),
            block.getBreath(),
            block.getType()
        );
    }
}
