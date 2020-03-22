package com.winner.evb2.models;

public class EvbAntragsteller {

    private String vorname;
    private String nachname;
    private String geburtsdatum;
    private String wohnort;

    public EvbAntragsteller(String vorname, String nachname, String geburtsdatum, String wohnort) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
        this.wohnort = wohnort;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public String getWohnort() {
        return wohnort;
    }


    public boolean eingabeKorrekt() {
        String a = "^[a-zA-Z]{2,20}+$";
        String b = "^\\s*(3[01]|[12][0-9]|0?[1-9])\\.(1[012]|0?[1-9])\\.((?:19|20)\\d{2})\\s*$";
        String c = "^\\s*(3[01]|[12][0-9]|0?[1-9])\\.(1[012]|0?[1-9])\\.(19\\d{2}|20[0][0-2])\\s*$";

        return (this.vorname.matches(a) && this.nachname.matches(a) && this.geburtsdatum.matches(c));
    }



    public boolean equals(Object o) {
        if (!(o instanceof EvbAntragsteller)) return false;
        EvbAntragsteller evbAntragsteller = (EvbAntragsteller) o;
        return this.vorname.equals(evbAntragsteller.vorname)
                && this.nachname.equals(evbAntragsteller.nachname)
                && this.geburtsdatum.equals(evbAntragsteller.geburtsdatum)
                && this.wohnort.equals(evbAntragsteller.wohnort);

    }

    public boolean isValid() {
        boolean ta = (vorname != null);
        boolean tb = (nachname != null);
        boolean tc = (geburtsdatum != null);
        boolean td = eingabeKorrekt();
        return ta && tb && tc && td;
    }
}
