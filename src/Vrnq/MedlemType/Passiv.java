package Vrnq.MedlemType;

import Vrnq.Entity.Medlem;

import java.text.ParseException;

public class Passiv extends Medlem {



    public Passiv(int medlemsID, String fornavn, String efternavn, String fodselsdato, String adresse, int kontingent, String medlemsType, boolean betalingStatus) throws ParseException {
        super(medlemsID, fornavn, efternavn, fodselsdato, adresse, kontingent, medlemsType, betalingStatus);
    }

    @Override
    public String toString() {
        return "ID: " + medlemsID +
                ", Navn: " + fornavn + " " + efternavn +
                ", Fødelsdag: " + fodselsdato +
                ", Medlemsskab: " + medlemsType +
                ", Kontingent: "+ kontingent +
                ", BetalingStatus: " + betalingStatus + "\n";
    }
}