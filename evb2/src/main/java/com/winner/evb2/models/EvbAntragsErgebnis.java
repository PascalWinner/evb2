package com.winner.evb2.models;

public class EvbAntragsErgebnis {

    private final String evbNummer;
    private final EvbErgebnis evbErgebnis;
    private final String meldung;

    public enum EvbErgebnis {
        EWENICHTERTEILT,
        BONITAETNICHTERLAUBT,
        BONITAETNICHTGEGEBEN,
        BONITAETGEGEBEN

    }

    public EvbAntragsErgebnis(String evbNummer, EvbErgebnis evbErgebnis, String meldung) {
        this.evbNummer = evbNummer;
        this.evbErgebnis = evbErgebnis;
        this.meldung = meldung;
    }

    public EvbErgebnis getEvbErgebnis() {
        return evbErgebnis;
    }

    public String getEvbNummer() {
        return evbNummer;
    }

    public boolean equals(Object o) {
        if (!(o instanceof EvbAntragsErgebnis)) return false;
        EvbAntragsErgebnis evbantragsergebnis = (EvbAntragsErgebnis) o;
        return this.evbNummer.equals(evbantragsergebnis.evbNummer)
                && this.evbErgebnis.equals(evbantragsergebnis.evbErgebnis)
                && this.meldung.equals(evbantragsergebnis.meldung);
    }
}
