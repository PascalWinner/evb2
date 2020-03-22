package com.winner.evb2.application;

import com.winner.evb2.Repositories.BonitaetPruefStelle;
import com.winner.evb2.Repositories.EvbAntragsRepository;
import com.winner.evb2.Repositories.KfzStelle;
import com.winner.evb2.Repositories.VkbBetreuersuche;
import com.winner.evb2.models.*;

import java.util.ArrayList;


public class EvbAnwendung {

    private EvbAntragsRepository evbAntragsRepository;
    private VkbBetreuersuche vkbBetreuersuche;
    private BonitaetPruefStelle bonitaetPruefStelle;
    private KfzStelle kfzStelle;

    public EvbAnwendung(EvbAntragsRepository evbAntragsRepository, VkbBetreuersuche vkbBetreuersuche,
                        BonitaetPruefStelle bonitaetPruefStelle, KfzStelle kfzStelle) {
        this.evbAntragsRepository = evbAntragsRepository;
        this.vkbBetreuersuche = vkbBetreuersuche;
        this.bonitaetPruefStelle = bonitaetPruefStelle;
        this.kfzStelle = kfzStelle;
    }


    public EvbAntragsId initalisiereEvbAntragFuer(EvbAntragsteller evbAntragsteller) {

        EvbAntrag evbAntrag = new EvbAntrag(evbAntragsteller);
        evbAntragsRepository.addEvbAntrag(evbAntrag);
        return evbAntrag.getId();
    }


    public EvbAntragsteller getEvbAntragsteller(EvbAntragsId evbAntragsId) {
        EvbAntrag antrag = evbAntragsRepository.getEvbAntrag(evbAntragsId);
        return antrag.getEvbAntragsteller();
    }

    public EvbBetreuer evbBetreuerSuche(EvbAntragsteller evbAntragsteller) {
        ArrayList<EvbBetreuer> betreuerliste;
        betreuerliste = vkbBetreuersuche.findeBetreuerMitWohnwort(evbAntragsteller);
        //Hier etwas machen 1.Null Objekt 2.null zurück
        EvbBetreuer betreuerDerWahl = betreuerliste.get(0);
        return betreuerDerWahl;
    }

    public void uebernehmeBetreuerFuerAntrag(EvbAntragsId evbAntragsId, EvbBetreuer evbBetreuer) {
        EvbAntrag evbAntrag = evbAntragsRepository.getEvbAntrag(evbAntragsId);
        evbAntrag.betreuerZuordnen(evbBetreuer);
        evbAntragsRepository.updateAntrag(evbAntrag);
    }

    public EvbBetreuer getEvbBetreuer(EvbAntragsId evbAntragsId) {
        EvbAntrag antrag = evbAntragsRepository.getEvbAntrag(evbAntragsId);
        return antrag.getEvbBetreuer();
    }

    public void uebernehmeKontaktDatenFuerAntrag(EvbAntragsId evbAntragsId, EvbKontaktDaten evbKontaktDaten) {
        EvbAntrag evbAntrag = evbAntragsRepository.getEvbAntrag(evbAntragsId);
        evbAntrag.kontaktDatenZuordnen(evbKontaktDaten);
        evbAntragsRepository.updateAntrag(evbAntrag);
    }

    public EvbKontaktDaten getEvbKontaktDaten(EvbAntragsId evbAntragsId) {
        EvbAntrag antrag = evbAntragsRepository.getEvbAntrag(evbAntragsId);
        return antrag.getEvbKontaktDaten();
    }

    public boolean pruefeAntragstellerAufBonitaet(EvbAntragsteller evbAntragsteller) {
        boolean bonitaetGegeben = bonitaetPruefStelle.eweBonitaetPruefen(evbAntragsteller);
        return bonitaetGegeben;
    }



    public EvbEweBonitaet getEvbEweBonitaet(EvbAntragsId evbAntragsId) {
        EvbAntrag antrag = evbAntragsRepository.getEvbAntrag(evbAntragsId);
        return antrag.getEvbEweBonitaet();
    }

    //soll ich in dieser Methode die AntragsId übergeben und mir damit den Antragsteller und EvbEweBonitaet holen?
    //Hier Methode aktualisieren, dass beide falls gleichzeitig geprüft werde. Ein Else if weniger
    public EvbAntragsErgebnis evbBeantragen(EvbEweBonitaet evbEweBonitaet, EvbAntragsteller evbAntragsteller) {
        if (evbEweBonitaet.getEweBestaetigt() && evbEweBonitaet.getBonitaetErlaubnis()) {
            if (pruefeAntragstellerAufBonitaet(evbAntragsteller)) {
                return new EvbAntragsErgebnis(kfzStelle.erhalteEvbNummer(),
                        EvbAntragsErgebnis.EvbErgebnis.BONITAETGEGEBEN,
                        "Hier ist Ihre eVB-Nummer");
            } else {
                return new EvbAntragsErgebnis("",
                        EvbAntragsErgebnis.EvbErgebnis.BONITAETNICHTGEGEBEN,
                        "Melden Sie sich bei einem Betreuer");
            }
        } else if (!evbEweBonitaet.getEweBestaetigt()) {
            return new EvbAntragsErgebnis("",
                    EvbAntragsErgebnis.EvbErgebnis.EWENICHTERTEILT,
                    "Sie müssen uns Ihre Einwilligungserklärung geben");
        } else
            return new EvbAntragsErgebnis("",
                    EvbAntragsErgebnis.EvbErgebnis.BONITAETNICHTERLAUBT,
                    "Sie müssen die Erlaubnis für die Bonitätsprüfung geben");
    }



    public void uebernehmeEweBonitaetFuerAntrag(EvbAntragsId evbAntragsId, EvbEweBonitaet evbEweBonitaet) {
        EvbAntrag evbAntrag = evbAntragsRepository.getEvbAntrag(evbAntragsId);
        evbAntrag.eweBonitaetZuordnen(evbEweBonitaet);
        evbAntragsRepository.updateAntrag(evbAntrag);
    }
    public void uebernehmeEvbAntragsErgebnisFuerAntrag(EvbAntragsId evbAntragsId, EvbAntragsErgebnis evbAntragsErgebnis) {
        EvbAntrag evbAntrag = evbAntragsRepository.getEvbAntrag(evbAntragsId);
        evbAntrag.evbAntragsErgebnisZuordnen(evbAntragsErgebnis);
        evbAntragsRepository.updateAntrag(evbAntrag);
    }

    public EvbAntragsErgebnis getEvbAntragsErgebnis(EvbAntragsId evbAntragsId) {
        EvbAntrag antrag = evbAntragsRepository.getEvbAntrag(evbAntragsId);
        return antrag.getEvbAntragsErgebnis();
    }
}


