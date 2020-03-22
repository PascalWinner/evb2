package com.winner.evb2.Repositories;

import com.winner.evb2.models.EvbAntragsteller;
import com.winner.evb2.models.EvbBetreuer;

import java.util.ArrayList;

public interface VkbBetreuersuche {

    ArrayList<EvbBetreuer> findeBetreuerMitWohnwort(EvbAntragsteller evbAntragsteller);

}
