package com.tbd.phoneadvice.mysql.models;

import javax.persistence.*;

@Entity
@Table(name = "data_sheet",schema = "phoneadvice")
public class DataSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_sheet_id", unique = true, nullable = false)
    private int data_sheet_id;

    @Column(name = "cpu", nullable = false, length = 100)
    private String cpu;

    @Column(name = "ram", nullable = false)
    private int ram;

    @Column(name = "operative_s", nullable = false, length = 100)
    private String operative_s;

    @Column(name = "dimensions", nullable = false, length = 100)
    private String dimensions;

    @Column(name = "front_cam", nullable = false, length = 100)
    private String weight;

    @Column(name = "screen", nullable = false, length = 100)
    private String screen;

    @Column(name = "back_cam", nullable = false, length = 100)
    private String back_cam;

    @Column(name = "storage", nullable = false, length = 100)
    private String storage;

    @Column(name = "batery", nullable = false, length = 100)
    private String batery;

    @OneToOne(mappedBy = "data_sheet")
    private Phone phone;

    public int getData_sheet_id() {
        return data_sheet_id;
    }

    public int getRam() {
        return ram;
    }

    public String getBack_cam() {
        return back_cam;
    }

    public String getBatery() {
        return batery;
    }

    public String getDimensions() {
        return dimensions;
    }

    public String getCpu() {
        return cpu;
    }

    public String getOperative_s() {
        return operative_s;
    }

    public String getScreen() {
        return screen;
    }

    public String getStorage() {
        return storage;
    }

    public String getWeight() {
        return weight;
    }

    public void setBack_cam(String back_cam) {
        this.back_cam = back_cam;
    }

    public void setBatery(String batery) {
        this.batery = batery;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setData_sheet_id(int data_sheet_id) {
        this.data_sheet_id = data_sheet_id;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public void setOperative_s(String operative_s) {
        this.operative_s = operative_s;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}


