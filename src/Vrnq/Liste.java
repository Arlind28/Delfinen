package Vrnq;

import Vrnq.Entity.Medlem;
import Vrnq.MedlemType.Konkurrence;
import Vrnq.MedlemType.Motionist;
import Vrnq.MedlemType.Passiv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Liste {
    Scanner scanner = new Scanner(System.in);

private ArrayList<Medlem> medlemsliste = new ArrayList<>();


@Override
public String toString() {
        return "MedlemsListe{" +
        "medlemsliste=" + medlemsliste +
        '}';
        }

        SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy");

public void opretMedlem() throws ParseException, FileNotFoundException {

        boolean moreMembersToEnter = true;

        while (moreMembersToEnter) {

        int kontingent;


        int medlemsID = medlemsliste.size() + 1;

        String fornavn = indtastText("Fornavn: ");
        String efternavn = indtastText("Efternavn: ");
        String fodselsdato = indtastText("Fødselsdato: ");
        Date fozdato = dataFormat.parse(fodselsdato);
        String adresse = indtastText("Adresse: ");

        if (udregnAlder(fozdato) < 18) {
        kontingent = 1000;
        } else if (udregnAlder(fozdato) > 60) {
        kontingent = 1200;
        } else {
        kontingent = 1600;
        }

        String betalScan = indtastText("Betal nu? j/n (hvis passiv kontingent 500) \n" + kontingent);
        boolean betalingsstatus = false;

        if (betalScan.equalsIgnoreCase("j")) {
        betalingsstatus = true;
        } else {
        betalingsstatus = false;
        }
        System.out.println("Hvilken kategori tilhører medlemmet:");
        System.out.println("1. Konkurrencesvømmer");
        System.out.println("2. Motionist");
        System.out.println("3. Passiv");
        int svar;
        String medlemsType;
        switch (indtastTal()) {
        case 1:
        medlemsType = "Konkurrence";

        Konkurrence konkurrencesvoemmer =
        new Konkurrence(medlemsID, fornavn, efternavn, fodselsdato, adresse, kontingent, medlemsType, betalingsstatus);
        medlemsliste.add(konkurrencesvoemmer);
        break;

        case 2:
        medlemsType = "Motionist";
        Motionist motionist =
        new Motionist(medlemsID, fornavn, efternavn, fodselsdato, adresse, kontingent, medlemsType, betalingsstatus);
        medlemsliste.add(motionist);
        break;

        case 3:
        kontingent = 500;
        medlemsType = "Passiv";
        Passiv passiv =
        new Passiv(medlemsID, fornavn, efternavn, fodselsdato, adresse, kontingent, medlemsType, betalingsstatus);
        medlemsliste.add(passiv);
        break;

        }

        //String enTil = scanner.nextLine();

        System.out.println(medlemsliste + "\n");


        String enTil = indtastText("Tilføj flere? j/n ");

        if (!enTil.equalsIgnoreCase("j")) {
        moreMembersToEnter = false;

        }

        } // While loop

        gemMedlemsliste();


        }

private String indtastText(String ledetekst) {
        System.out.println(ledetekst);
        String textInput = scanner.nextLine();
        return textInput;
        }

private int indtastTal() {
        String textInput = scanner.nextLine();
        return Integer.parseInt(textInput);
        }

private void gemMedlemsliste() {
        try {
        PrintStream file = new PrintStream(new File("medlemsListe.text"));
        for (int i = 0; i < medlemsliste.size(); i++) {
        file.println("ID: " + medlemsliste.get(i).getMedlemsID() + ". Navn: " + medlemsliste.get(i).getFornavn() + " " + medlemsliste.get(i).getEfternavn() + ". Fødselsdato: " + medlemsliste.get(i).getFodselsdato()
        + ". Adresse: " + medlemsliste.get(i).getAdresse() + ". Holdtype: " + medlemsliste.get(i).isMedlemsType());
        }
        file.close();
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        }

        }


public static int udregnAlder(Date fozdag) {
        Calendar fozdato = Calendar.getInstance();
        fozdato.setTime(fozdag);
        Calendar iDag = Calendar.getInstance();

        int aarsForskel = iDag.get(Calendar.YEAR) - fozdato.get(Calendar.YEAR);

        if (iDag.get(Calendar.MONTH) < fozdato.get(Calendar.MONTH)) {
        aarsForskel--;
        } else {
        if (iDag.get(Calendar.MONTH) == fozdato.get(Calendar.MONTH) && iDag.get(Calendar.DAY_OF_MONTH) < fozdato.get(Calendar.DAY_OF_MONTH)) {
        aarsForskel--;
        }

        }
        return aarsForskel;
        }


public void redigerMedlem() {
        System.out.println("Indtast medlemdID:");
        boolean aktiv = true;
        boolean aktiv2 = true;
        while (aktiv) {
        int svar = indtastTal();
        for (int i = 0; i < medlemsliste.size(); i++) {
        if (medlemsliste.get(i).getMedlemsID() == svar) {
        System.out.println(medlemsliste.get(i));
        System.out.println("Ændre Menu");
        System.out.println("1. Medlemstype");
        System.out.println("2. Fornavn");
        System.out.println("3. Efternavn");
        System.out.println("4. Adresse");
        System.out.println("5. Exit");
        while (aktiv2) {
        aktiv2 = false;
        int svar2 = indtastTal();
        switch (svar2) {
        case 1:
        System.out.println("Vælg medlemstype:");
        System.out.println("1. Konkurrencesvømmer");
        System.out.println("2. Motionist");
        System.out.println("3. Passiv");
        switch (scanner.nextInt()) {
        case 1:
        medlemsliste.get(i).setMedlemsType("Konkurrencesvømmer");
        gemMedlemsliste();
        break;
        case 2:
        medlemsliste.get(i).setMedlemsType("Motionist");
        gemMedlemsliste();
        break;
        case 3:
        medlemsliste.get(i).setMedlemsType("Passiv");
        gemMedlemsliste();
        break;
        }
        break;
        case 2:
        String newFornavn = indtastText("Indtast nyt fornavn: ");
        medlemsliste.get(i).setFornavn(newFornavn);
        gemMedlemsliste();
        break;
        case 3:
        String newEfternavn = indtastText("Indtast nyt efternavn: ");
        medlemsliste.get(i).setEfternavn(newEfternavn);
        gemMedlemsliste();
        break;
        case 4:
        String newAdresse = indtastText("Indtast ny adresse :");
        medlemsliste.get(i).setAdresse(newAdresse);
        gemMedlemsliste();
        break;
default:
        System.out.println("Fejl! Vælg et tal.");
        aktiv = true;
        }
        }
        } else {
        System.out.println("???");
        }
        }
        }
        }

public void retRestance() {

        boolean aktiv = true;
        boolean aktiv2 = true;
        while (aktiv) {
        int svar = indtastTal();
        ;
        for (int i = 0; i < medlemsliste.size(); i++) {
        if (medlemsliste.get(i).getMedlemsID() == svar) {
        System.out.println(medlemsliste.get(i));
        System.out.println("Ændre Menu");
        System.out.println("1. Ændre betaling status");
        System.out.println("2. Exit");

        while (aktiv2) {
        aktiv2 = false;
        int svar2 = indtastTal();
        switch (svar2) {
        case 1:
        System.out.println("Vælg betalings status:");
        System.out.println("1. Betalt");
        System.out.println("2. Ikke betalt");
        switch (scanner.nextInt()) {
        case 1:
        medlemsliste.get(i).setBetalingStatus(true);
        gemMedlemsliste();
        break;
        case 2:
        medlemsliste.get(i).setBetalingStatus(false);
        gemMedlemsliste();
        break;

        }
        case 2:
        break;
        }

        }
        }

        }
        }
        }

public void seMedlemsliste() {
        System.out.println(medlemsliste);
        System.out.println("");
        }

public void seKontingent() {

        System.out.println("Kontingent priser");
        System.out.println("Under 18 år      =  1000 kr");
        System.out.println("Mellem 18-60 år  =  1600 kr");
        System.out.println("Over 60 år       =  1200 kr");
        System.out.println("Passiv medlem    =   500 kr");
        System.out.println("");

        }

public void seRestance() {

        boolean b = false;
        if (medlemsliste.contains(b)) {
        System.out.println(medlemsliste.contains(b));

        }
        }

public void sletMedlem() {
        boolean aktiv = false;
        boolean aktiv2 = false;
        System.out.println("Indtast ID:");
        while (!aktiv) {
        for (int i = 0; i < medlemsliste.size(); i++) {
        if (medlemsliste.get(i).getMedlemsID() == indtastTal()) {

        System.out.println("Vil du slette medlem \n" + medlemsliste.get(i));
        System.out.println(" j/n");
        while (!aktiv2) {
        String svar2 = scanner.nextLine();
        if (svar2.equalsIgnoreCase("j")) {
        medlemsliste.remove(i);
        System.out.println("Medlem Slettet");
        System.out.println("");
        aktiv2 = true;
        } else {
        System.out.println("Medlem ikke slettet.");
        System.out.println("");
        }
        }
        aktiv = true;
        } else {
        System.out.println("Indtast korrekt ID");
        }
        }
        }

        }




        }


