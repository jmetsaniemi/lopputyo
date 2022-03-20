package com.lopputyo.lopputyo;

import java.util.ArrayList;
import java.util.List;

public class Oppilaat {

    private String oppilasFn;
    private String oppilasLn;
    private String oppilasLuokka;
    private int oppilasId;

    public Oppilaat(String oppilasFn, String oppilasLn, String oppilasLuokka, String kurssiId) {
        this.oppilasFn = oppilasFn;
        this.oppilasLn = oppilasLn;
        this.oppilasLuokka = oppilasLuokka;
        this.oppilasId = oppilasId;
    }

    public Oppilaat(int studentId) {
        this.oppilasId = studentId;
    }

    public int getStudentId() {
        return oppilasId;
    }

    public void setStudentId(int studentId) {
        this.oppilasId = studentId;
    }

    public String getOppilasFn() {
        return oppilasFn;
    }

    public void setOppilasFn(String oppilasFn) {
        this.oppilasFn = oppilasFn;
    }

    public String getOppilasLn() {
        return oppilasLn;
    }

    public void setOppilasLn(String oppilasLn) {
        this.oppilasLn = oppilasLn;
    }

    public String getOppilasLuokka() {
        return oppilasLuokka;
    }

    public void setOppilasLuokka(String oppilasLuokka) {
        this.oppilasLuokka = oppilasLuokka;
    }
}
