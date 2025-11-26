package com.example.javagyakorlat;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "gp")
public class gp {
    @Id
    private Date datum;
    @Column(name = "nev")
    private String nev;
    @Column(name = "helyszin")
    private String helyszin;

    @OneToOne
    @JoinColumn(name = "datum", insertable = false, updatable = false)
    private eredmeny eredmeny;

    public String getHelyszin() {
        return helyszin;
    }

    public void setHelyszin(String helyszin) {
        this.helyszin = helyszin;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
