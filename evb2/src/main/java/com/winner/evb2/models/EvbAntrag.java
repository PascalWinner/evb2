package com.winner.evb2.models;


public class EvbAntrag {

    private EvbAntragsId evbAntragsId;
    private EvbAntragsteller evbAntragsteller;
    private EvbBetreuer evbBetreuer;
    private EvbKontaktDaten evbKontaktDaten;
    private EvbEweBonitaet evbEweBonitaet;
    private EvbAntragsErgebnis evbAntragsErgebnis;

    public EvbAntrag(EvbAntragsteller evbAntragsteller) {
        this.evbAntragsteller = evbAntragsteller;
    }


    public EvbAntrag(EvbAntrag antrag) {
        this.evbAntragsId = antrag.evbAntragsId;
        this.evbAntragsteller = antrag.evbAntragsteller;
        this.evbBetreuer = antrag.evbBetreuer;
        this.evbKontaktDaten = antrag.evbKontaktDaten;
        this.evbEweBonitaet = antrag.evbEweBonitaet;
        this.evbAntragsErgebnis = antrag.evbAntragsErgebnis;
    }

    public void betreuerZuordnen(EvbBetreuer evbBetreuer) {
        this.evbBetreuer = evbBetreuer;
    }

    public void kontaktDatenZuordnen(EvbKontaktDaten evbKontaktDaten) {
        this.evbKontaktDaten = evbKontaktDaten;
    }

    public void eweBonitaetZuordnen(EvbEweBonitaet evbEweBonitaet) {
        this.evbEweBonitaet = evbEweBonitaet;
    }

    public void evbAntragsErgebnisZuordnen(EvbAntragsErgebnis evbAntragsErgebnis) {
        this.evbAntragsErgebnis = evbAntragsErgebnis;
    }

    public EvbAntragsId getId() {
        return evbAntragsId;
    }


    public EvbAntragsteller getEvbAntragsteller() {
        return evbAntragsteller;
    }


    public EvbBetreuer getEvbBetreuer() {
        return evbBetreuer;
    }


    public EvbKontaktDaten getEvbKontaktDaten() {
        return evbKontaktDaten;
    }

    public EvbEweBonitaet getEvbEweBonitaet() {
        return evbEweBonitaet;
    }

    public EvbAntragsErgebnis getEvbAntragsErgebnis() {
        return evbAntragsErgebnis;
    }

    public boolean isValid() {
        boolean isValid;
        isValid = (evbAntragsteller != null);
        isValid = isValid && (evbBetreuer != null);
        isValid = isValid && (evbKontaktDaten != null);

        if (isValid == true) {
            isValid = evbAntragsteller.isValid() && evbBetreuer.isValid() && evbKontaktDaten.isValid();
        }

        return isValid;
    }

    public EvbAntragsErgebnis.EvbErgebnis evbBeantragenX(EvbEweBonitaet evbEweBonitaet) {
        if (evbEweBonitaet.getEweBestaetigt() == true && evbEweBonitaet.getBonitaetErlaubnis() == true) {
            return EvbAntragsErgebnis.EvbErgebnis.BONITAETGEGEBEN;
        } else if (evbEweBonitaet.getEweBestaetigt() == false) {
            return EvbAntragsErgebnis.EvbErgebnis.EWENICHTERTEILT;
        } else
            return EvbAntragsErgebnis.EvbErgebnis.BONITAETNICHTERLAUBT;
    }


}
