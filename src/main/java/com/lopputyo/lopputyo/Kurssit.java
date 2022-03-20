package com.lopputyo.lopputyo;

public class Kurssit {

    private String kurssiNimi;

    private int kurssiId;

    private String kurssiOpettaja;

    public String getKurssiOpettaja() {
        return kurssiOpettaja;
    }

    public void setKurssiOpettaja(String kurssiOpettaja) {
        this.kurssiOpettaja = kurssiOpettaja;
    }

    public int getKurssiId() {
        return kurssiId;
    }

    public void setKurssiId(int kurssiId) {
        this.kurssiId = kurssiId;
    }

    public Kurssit(int kurssiId) {
        this.kurssiId = kurssiId;
    }

    public Kurssit(String kurssiNimi, String kurssiOpettaja) {
        this.kurssiNimi = kurssiNimi;

    }

    public String getKurssiNimi() {
        return kurssiNimi;
    }

    public void setKurssiNimi(String kurssiNimi) {
        this.kurssiNimi = kurssiNimi;
    }

}
