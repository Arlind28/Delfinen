package Vrnq.Entity;

import Vrnq.MedlemType.Konkurrence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Medlem {
    protected int medlemsID;
    protected String fornavn;
    protected String efternavn;
    protected Date fodselsdato;
    protected String adresse;
    protected int kontingent;
    protected String medlemsType;
    protected boolean betalingStatus;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    ArrayList<Medlem> medlemsListe = new ArrayList<>();



    public Medlem(int medlemsID, String fornavn, String efternavn, String fodselsdato, String adresse, int kontingent, String medlemsStatus, boolean betalingStatus) throws ParseException, ParseException {
        this.medlemsID = medlemsID;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.fodselsdato = dateFormat.parse(fodselsdato);
        this.adresse = adresse;
        this.kontingent = kontingent;
        this.medlemsType = medlemsStatus;
        this.betalingStatus = betalingStatus;
    }

    public int getMedlemsID() {
        return medlemsID;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public Date getFodselsdato() {
        return fodselsdato;
    }

    public String getAdresse() {
        return adresse;
    }

    public String isMedlemsType() {
        return medlemsType;
    }


    @Override
    public String toString() {
        if( betalingStatus == true){
            return "ID: " + medlemsID +
                    ", Navn: " + fornavn + " " + efternavn +
                    ", Fødelsdag: " + fodselsdato.getDate() + "-" + fodselsdato.getMonth()+1 +"-"+ fodselsdato.getYear() +
                    ", Medlemsskab: Aktiv" +
                    ", Kontingent; " + "BETALT" +
                    ", Holdtype: " + ((this instanceof Konkurrence) ? "Konkurrence" : "Motionist");
        }else {
            return "ID: " + medlemsID +
                    ", Navn: " + fornavn + " " + efternavn +
                    ", Fødelsdag: " + fodselsdato.getDate() + "-" + fodselsdato.getMonth()+1 +"-"+ fodselsdato.getYear() +
                    ", Medlemsskab: Aktiv" +
                    ", Kontingent; " + "IKKE BETALT" +
                    ", Holdtype: " + ((this instanceof Konkurrence) ? "Konkurrence" : "Motionist");
        }


    }

    public void setBetalingStatus(boolean betalingStatus)
    {
        this.betalingStatus = betalingStatus;
    }


    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }


    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public void setMedlemsType(String medlemsType) {
        this.medlemsType = medlemsType;
    }


}
