/*
package com.winner.evb2.ModelTester;

import com.winner.evb2.models.*;


import jdk.nashorn.internal.ir.annotations.Ignore;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;


import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EvbAntragStellenSimulationTest {

    EvbAntrag evbAntrag;

    @BeforeAll
    public void init() {

        evbAntrag = new EvbAntrag();

    }

    @Test
    public void erstelleIdFuerAntragTest() {
        //Given
        //Abfrage ob Antrag gestezt
        //When
        //Then
        assertNotNull(evbAntrag.getId());
    }




    @Test
    public void uebernehmePersonenDatenFuerEvbAntragstellerTest() {
        //Given
        EvbAntragsteller antragsteller = new EvbAntragsteller("Max", "Mustermann", "01.01.2000", "Muenchen");
        evbAntrag.setEvbAntragsteller(antragsteller);

        //Then
        assertNotNull(evbAntrag.getEvbAntragsteller().getVorname());
        assertNotNull(evbAntrag.getEvbAntragsteller().getNachname());
        assertNotNull(evbAntrag.getEvbAntragsteller().getGeburtsdatum());

    }
    @Test
    @Ignore
    public void uebernehmeBetreuerfuerAntragstellerTest() {
        //Given
        EvbBetreuer betreuer = new EvbBetreuer();
        evbAntrag.setEvbBetreuer(betreuer);
        betreuer.setVorname("Peter");
        betreuer.setName("Müller");

        //Then
        assertNotNull(evbAntrag.getEvbBetreuer().getName());
        assertNotNull(evbAntrag.getEvbBetreuer().getVorname());


    }

    @Test
    public void PersonenDatenEingebenTest() {}

    @Test
    public void betreuerauswaehlenTest() {
        //Given
        EvbAntragsteller antragsteller1 = new EvbAntragsteller("MAx", "Mustermann", "01.01.200", "Muenchen");

        //When
        EvbAnwendung evbAnwendung = new EvbAnwendung();
        List<EvbBetreuer> betreuerListe = evbAnwendung.betreuersuche(antragsteller1);

        EvbBetreuer betreuer1 = betreuerListe.get(0);

        EvbAntragsId antragsId1 = evbAnwendung.initalisiereEvbAntragFuer(antragsteller1, betreuer1);

        //Then



    }
    @Test
    public void uebernehmeKontaktDatenFuerEvbAntragstellerTest() {
        //Given
        EvbKontaktDaten kontaktDaten = new EvbKontaktDaten();
        evbAntrag.setEvbKontaktDaten(kontaktDaten);
        kontaktDaten.setEmail("max.mustermann@inverso.de");
        kontaktDaten.setHandynummer("0123456789");

        //Then
        assertNotNull(evbAntrag.getEvbKontaktDaten().getEmail());
        assertNotNull(evbAntrag.getEvbKontaktDaten().getHandynummer());

    }

    @Test
    public void hatEvbAntragstellerEweUndBonitätspruefungBestaetigt() {
        //Given
        EvbEweBonitaet eweUndBonitaet = new EvbEweBonitaet();
        evbAntrag.setEvbEweBonitaet(eweUndBonitaet);
        eweUndBonitaet.setBonitaet(true);
        eweUndBonitaet.setEwe(true);

        //Then
        assertTrue(evbAntrag.getEvbEweBonitaet().isBonitaet());
        assertTrue(evbAntrag.getEvbEweBonitaet().isEwe());

    }

    @Test
    public void antragIstRichtigAusgefuelltTest() {

        assertTrue(evbAntrag.isValid());
    }



}
*/
