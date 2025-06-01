package com.example.warehouse.dto.mapper;

import com.example.warehouse.dto.request.RoomRequest;
import com.example.warehouse.dto.response.RoomResponse;
import com.example.warehouse.entity.Room;
import org.springframework.stereotype.Controller;

@Controller
public class RoomMapper {

    public Room toEntity(RoomRequest source, Room target){
        if (source == null) {
            return target;
        }
        if (target == null) {
            target = new Room();
        }
        target.setName(source.name());
        return target;
    }

    public RoomResponse toResponse(Room room){
        if (room == null) {
            return null;
        }
        return new RoomResponse(
            room.getRoomId(),
            room.getName()
        );
    }
}
