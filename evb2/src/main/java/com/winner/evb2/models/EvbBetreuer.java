package com.winner.evb2.models;


public class EvbBetreuer {

    String vorname;
    String nachname;
    String wohnort;

    public EvbBetreuer(String vorname, String nachname, String wohnort) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.wohnort = wohnort;
    }

    public boolean isDummyBetreuer () {
        return false;
    }

    public String getWohnort() {
        return wohnort;
    }

    public boolean isValid() {
        boolean ab = (nachname != null);
        boolean bb = (vorname != null);
        return ab && bb;
    }

    public boolean equals(Object o) {
        if (!(o instanceof EvbBetreuer)) return false;
        EvbBetreuer evbBetreuer = (EvbBetreuer) o;
        return this.vorname.equals(evbBetreuer.vorname)
                && this.nachname.equals(evbBetreuer.nachname)
                && this.wohnort.equals(evbBetreuer.wohnort);
    }
}
