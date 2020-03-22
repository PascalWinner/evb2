package com.winner.evb2.mocks;

import com.winner.evb2.Repositories.VkbBetreuersuche;
import com.winner.evb2.models.EvbAntragsteller;
import com.winner.evb2.models.EvbBetreuer;

import java.util.ArrayList;

public class MockingVkbBetreuersuche implements VkbBetreuersuche {

    //Map<id, EvbBetreuer> vkbBetreuer = new HashMap<>();
    ArrayList<EvbBetreuer> vkbBetreuerliste = new ArrayList<>();

    private void setVkbBetreuerlisteFuellen() {
        vkbBetreuerliste.add(0, new EvbBetreuer("Peter", "Mueller", "Muenchen"));
        vkbBetreuerliste.add(1, new EvbBetreuer("Peter", "Mueller", "Berlin"));
    }

    @Override
    public ArrayList<EvbBetreuer> findeBetreuerMitWohnwort(EvbAntragsteller evbAntragsteller) {
        setVkbBetreuerlisteFuellen();
        String wohnort = evbAntragsteller.getWohnort();
        ArrayList<EvbBetreuer> relevanteBetreuer = new ArrayList<>();

        for (int i = 0; i < vkbBetreuerliste.size(); i++) {
            if (vkbBetreuerliste.get(i).getWohnort().equals(wohnort)) {
                relevanteBetreuer.add(vkbBetreuerliste.get(i));
            }
        }
        return relevanteBetreuer;
    }
}
