package com.example.javagyakorlat;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "eredmeny")
public class eredmeny {
    @Id
    private int id;
    @Column(name = "datum")
    private Date datum;
    @Column(name = "pilotaaz")
    private int pilotaaz;
    @Column(name = "helyezes")
    private int helyezes;
    @Column(name = "hiba")
    private String hiba;
    @Column(name = "csapat")
    private String csapat;
    @Column(name = "tipus")
    private String tipus;
    @Column(name = "motor")
    private String motor;

    @OneToOne
    @JoinColumn(name = "pilotaaz", insertable = false, updatable = false)
    private pilota pilota;
    @OneToOne
    @JoinColumn(name = "datum", insertable = false, updatable = false)
    private gp gp;

    public pilota getPilota() {
        return pilota;
    }

    public void setPilota(pilota pilota) {
        this.pilota = pilota;
    }

    public gp getGp() {
        return gp;
    }

    public void setGp(gp gp) {
        this.gp = gp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getPilotaaz() {
        return pilotaaz;
    }

    public void setPilotaaz(int pilotaaz) {
        this.pilotaaz = pilotaaz;
    }

    public int getHelyezes() {
        return helyezes;
    }

    public void setHelyezes(int helyezes) {
        this.helyezes = helyezes;
    }

    public String getHiba() {
        return hiba;
    }

    public void setHiba(String hiba) {
        this.hiba = hiba;
    }

    public String getCsapat() {
        return csapat;
    }

    public void setCsapat(String csapat) {
        this.csapat = csapat;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }
}
