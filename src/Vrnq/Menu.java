package Vrnq;

import java.util.Scanner;

public class Menu {

    public void start(){

        Liste medlemsListe = new Liste();

        loop1:
        while (true) {

            System.out.println("Menu");
            System.out.println("1. Formand");
            System.out.println("2. Kassér");
            System.out.println("3. Træner");
            System.out.println("4. Exit");
            try {
                Scanner mMain = new Scanner(System.in);
                int mMenu = mMain.nextInt();
                switch (mMenu) {
                    case 1:
                        // Formand Login
                        System.out.println("Kode: ");
                        Scanner pin = new Scanner(System.in);
                        String kode = pin.next();
                        if (kode.equals("1234")) {
                            loop2:
                            while (true) {
                                System.out.println("Formand Menu");
                                System.out.println("1. Se Medlemsliste");
                                System.out.println("2. Opret Medlem");
                                System.out.println("3. Redigere Medlem");
                                System.out.println("4. Slet Medlem");
                                System.out.println("5. Se Kontingent Pris");
                                System.out.println("6. Find Medlem");
                                System.out.println("7. Exit");

                                try {
                                    Scanner formandMain = new Scanner(System.in);
                                    int formandMenu = formandMain.nextInt();
                                    switch (formandMenu) {
                                        case 1:
                                            medlemsListe.seMedlemsliste();
                                            break;
                                        case 2:
                                            medlemsListe.opretMedlem();
                                            break;
                                        case 3:
                                            medlemsListe.redigerMedlem();
                                            break;
                                        case 4:
                                            medlemsListe.sletMedlem();
                                            break;
                                        case 5:
                                            medlemsListe.seKontingent();
                                            break;
                                        case 6:
                                            System.out.println(" kommerSnart");
                                            System.out.println("");
                                            break;
                                        case 7:
                                            break loop2;
                                        default:
                                            System.out.println(" fejl");
                                            break;
                                    }

                                } catch (Exception i) {
                                    System.out.println(i);
                                }
                            }
                        } else {
                            System.out.println("Forkert kode");

                        }
                        break;

                    case 2:
                        //Kassér Login
                        System.out.println("Kode: ");
                        Scanner pIN = new Scanner(System.in);
                        String kOde = pIN.next();
                        if (kOde.equals("1234")) {
                            while (true) {
                                System.out.println("Kassér Menu");
                                System.out.println("1. Se restance");
                                System.out.println("2. Set restence");
                                System.out.println("3. Se kontingent");
                                System.out.println("4. Exit");
                                try {
                                    Scanner formandMain = new Scanner(System.in);
                                    int formandMenu = formandMain.nextInt();
                                    switch (formandMenu) {
                                        case 1:
                                            medlemsListe.seRestance();
                                            break;
                                        case 2:
                                            medlemsListe.retRestance();
                                            break;
                                        case 3:
                                            medlemsListe.seKontingent();
                                            break;
                                        case 4:
                                            break;
                                        default:
                                            System.out.println(" fejl");
                                            break;
                                    }
                                } catch (Exception i) {
                                    System.out.println(i);
                                }
                            }
                        } else {
                            System.out.println("Forkert kode");
                            break;

                        }
                    case 3:
                        System.out.println(" kommerSnart");
                        //træner login
                        break;
                    case 4:
                        break loop1;
                    default:
                        System.out.println("vælg menu");
                        break;


                }

            } catch (Exception i) {
                System.out.println(i);
            }

        }

    }
    }
