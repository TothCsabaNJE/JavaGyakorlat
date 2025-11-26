package com.example.javagyakorlat;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "pilota")
public class pilota {
    @Id
    private int az;
    @Column(name = "nev")
    private String nev;
    @Column(name = "nem")
    private String nem;
    @Column(name = "szuldat")
    private Date szuldat;
    @Column(name = "nemzet")
    private String nemzet;

    public int getAz() {
        return az;
    }

    public void setAz(int az) {
        this.az = az;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
    }

    public Date getSzuldat() {
        return szuldat;
    }

    public void setSzuldat(Date szuldat) {
        this.szuldat = szuldat;
    }

    public String getNemzet() {
        return nemzet;
    }

    public void setNemzet(String nemzet) {
        this.nemzet = nemzet;
    }
}
