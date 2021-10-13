package com.company;
import java.security.spec.RSAOtherPrimeInfo;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej maximalni povolenou rychlost v km: ");
        double maximalniRychlost = sc.nextDouble();
        System.out.println("Zadej delku useku v km");
        double delkaUseku = sc.nextDouble() * 1000;
        boolean prekrocil = false;

        //LocalTime time;
        System.out.println("Zadej zacatek useku v hh:mm:sec::set: ");

        String startString = sc.next();
        String[] startParts = startString.split(":");
        String Shours = startParts[0];
        String Sminutes = startParts[1];
        String Sseconds = startParts[2];
        String Smilis = startParts[3];

        System.out.println("Zadej konec useku v hh:mm:sec::set: ");

        String endString = sc.next();
        String[] endParts = endString.split(":");
        String Ehours = endParts[0];
        String Eminutes = endParts[1];
        String Eseconds = endParts[2];
        String Emilis = endParts[3];

        LocalTime start = LocalTime.of(Integer.valueOf(Shours), Integer.valueOf(Sminutes), Integer.valueOf(Sseconds), Integer.valueOf(Smilis));
        LocalTime end = LocalTime.of(Integer.valueOf(Ehours), Integer.valueOf(Eminutes), Integer.valueOf(Eseconds), Integer.valueOf(Emilis));
        Duration duration = Duration.between(start, end);
        double fintime = duration.toSeconds();
        double prumernaRychlost = (delkaUseku / fintime) * 3.6;
        System.out.println(prumernaRychlost);
        //System.out.println(fintime);
        double prekrocenaRychlost = prumernaRychlost - maximalniRychlost;
        if (prumernaRychlost > maximalniRychlost) {
            System.out.println("Prekrocil jsi rychlost o: " + prekrocenaRychlost);
            prekrocil = true;



        } else {
            System.out.println("Neprekrocil jsi rychlost");
        }
        System.out.println(prekrocil?"Dostane pokutu":"Nedostane pokutu");


    }

}