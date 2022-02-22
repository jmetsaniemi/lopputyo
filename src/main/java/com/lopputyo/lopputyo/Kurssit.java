package com.lopputyo.lopputyo;

public class Kurssit {

    private String kurssiNimi;

    private String kurssiId;

    public String getKurssiId() {
        return kurssiId;
    }

    public void setKurssiId(String kurssiId) {
        this.kurssiId = kurssiId;
    }

    public Kurssit(String kurssiId) {
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
