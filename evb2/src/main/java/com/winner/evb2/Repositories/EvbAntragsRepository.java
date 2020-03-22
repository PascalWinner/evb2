package com.winner.evb2.Repositories;

import com.winner.evb2.models.EvbAntrag;
import com.winner.evb2.models.EvbAntragsId;
import com.winner.evb2.models.EvbBetreuer;


public interface EvbAntragsRepository {


    void addEvbAntrag(EvbAntrag evbAntrag);

    EvbAntrag getEvbAntrag(EvbAntragsId evbAntragsId);

    void updateAntrag(EvbAntrag evbAntrag);
}
