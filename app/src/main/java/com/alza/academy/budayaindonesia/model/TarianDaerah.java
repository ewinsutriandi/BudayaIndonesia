package com.alza.academy.budayaindonesia.model;

/**
 * Created by ewin on 15/12/17.
 */

public class TarianDaerah {
    private String judulTarian;
    private String daerahAsal;
    private String deskripsiTarian;

    public TarianDaerah(String judulTarian, String daerahAsal, String deskripsiTarian) {
        this.judulTarian = judulTarian;
        this.daerahAsal = daerahAsal;
        this.deskripsiTarian = deskripsiTarian;
    }

    public String getJudulTarian() {
        return judulTarian;
    }

    public void setJudulTarian(String judulTarian) {
        this.judulTarian = judulTarian;
    }

    public String getDaerahAsal() {
        return daerahAsal;
    }

    public void setDaerahAsal(String daerahAsal) {
        this.daerahAsal = daerahAsal;
    }

    public String getDeskripsiTarian() {
        return deskripsiTarian;
    }

    public void setDeskripsiTarian(String deskripsiTarian) {
        this.deskripsiTarian = deskripsiTarian;
    }
}
