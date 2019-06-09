package com.tbd.phoneadvice.mysql.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "data_sheet",schema = "phoneadvice")
@Data
public class DataSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_sheet_id", unique = true, nullable = false)
    private Long dataSheetId;

    @Column(name = "cpu", nullable = false, length = 300)
    private String cpu;

    @Column(name = "ram", nullable = false)
    private String ram;

    @Column(name = "operative_s", nullable = false, length = 300)
    private String operative_s;

    @Column(name = "dimensions", nullable = false, length = 300)
    private String dimensions;

    @Column(name = "front_cam", nullable = false, length = 300)
    private String front_cam;

    @Column(name = "screen", nullable = false, length = 300)
    private String screen;

    @Column(name = "back_cam", nullable = false, length = 300)
    private String back_cam;

    @Column(name = "storage", nullable = false, length = 300)
    private String storage;

    @Column(name = "batery", nullable = false, length = 300)
    private String batery;

    @JsonIgnore
    @OneToOne(mappedBy = "data_sheet")
    private Phone phone;
}


