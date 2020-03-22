package com.winner.evb2.mocks;

public class MockingPerson {

    String vorname;
    String nachname;
    String geburtstdatum;
    boolean bonitaet;

    public MockingPerson(String vorname, String nachname, String geburtstdatum, boolean bonitaet) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtstdatum = geburtstdatum;
        this.bonitaet = bonitaet;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getGeburtstdatum() {
        return geburtstdatum;
    }

    public boolean getBonitaet() {
        return bonitaet;
    }
}
