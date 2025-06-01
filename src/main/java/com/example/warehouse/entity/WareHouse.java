package com.example.warehouse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@Entity
@Table(name = "warehouse")
public class WareHouse {

    @OneToMany(mappedBy = "warehouse")
    private List<Staff> staff;

    @OneToMany(mappedBy = "warehouse")
    private List<Admin> admin;

    @OneToMany(mappedBy = "warehouse")
    private List<Room> room;

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "warehouse_id", nullable = false, updatable = false)
    private String warehouseId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "city",nullable = false, updatable = false)
    private String city;

    @Column(name = "address",nullable = false, updatable = false)
    private String address;//Co-ordinate also for use distance calculation

    @Column(name = "landmark",nullable = false, updatable = false)
    private String landmark;
}
