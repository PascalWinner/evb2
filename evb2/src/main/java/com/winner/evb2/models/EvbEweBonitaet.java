package com.winner.evb2.models;

public class EvbEweBonitaet {

    private final boolean eweBestaetigt;
    private final boolean bonitaetErlaubnis;

    public EvbEweBonitaet(boolean eweBestaetigt, boolean bonitaetErlaubnis) {
        this.eweBestaetigt = eweBestaetigt;
        this.bonitaetErlaubnis = bonitaetErlaubnis;
    }

    public boolean getEweBestaetigt() {
        return eweBestaetigt;
    }

    public boolean getBonitaetErlaubnis() {
        return bonitaetErlaubnis;
    }

    public boolean equals(Object o) {
        if (!(o instanceof EvbEweBonitaet)) return false;
        EvbEweBonitaet evbEweBonitaet = (EvbEweBonitaet) o;
        return this.eweBestaetigt == evbEweBonitaet.eweBestaetigt
                && this.bonitaetErlaubnis == evbEweBonitaet.bonitaetErlaubnis;
    }


}
