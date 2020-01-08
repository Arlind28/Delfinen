package Vrnq.MedlemType;

import Vrnq.Entity.Medlem;

import java.text.ParseException;

public class Konkurrence extends Medlem {


    public Konkurrence(int medlemsID, String fornavn, String efternavn, String fodselsdato, String adresse, int kontingent, String medlemsType, boolean betalingStatus) throws ParseException {
        super(medlemsID, fornavn, efternavn, fodselsdato, adresse, kontingent, medlemsType, betalingStatus);
    }


    @Override
    public String toString() {
        if (betalingStatus == true) {
            return "ID: " + medlemsID +
                    ", Navn: " + fornavn + " " + efternavn +
                    ", Fødelsdag: " + fodselsdato.getDate() + "-" + fodselsdato.getMonth()+1 + "-" + fodselsdato.getYear() +
                    ", Medlemsskab: Aktiv" +
                    ", Kontingent: " + "BETALT" +
                    ", Holdtype: " + medlemsType +"\n";
        } else {
            return "ID: " + medlemsID +
                    ", Navn: " + fornavn + " " + efternavn +
                    ", Fødelsdag: " + fodselsdato.getDate() + "-" + fodselsdato.getMonth()+1 + "-" + fodselsdato.getYear() +
                    ", Medlemsskab: Aktiv" +
                    ", Kontingent: " + "IKKE BETALT" +
                    ", Holdtype: " + medlemsType +"\n";
        }
    }

}