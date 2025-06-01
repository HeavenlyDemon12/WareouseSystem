package com.example.warehouse.entity;

import com.example.warehouse.enums.BlockType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "block")
@Inheritance(strategy = InheritanceType.JOINED)
public class Block {

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "block_id",nullable = false,updatable = false)
    private String blockId;

    @Column(name = "height",nullable = false)
    private double height;

    @Column(name = "length",nullable = false)
    private double length;

    @Column(name = "breath",nullable = false)
    private double breath;

    @Column(name = "type",nullable = false)
    private BlockType type;
}
