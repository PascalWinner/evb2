package com.winner.evb2;

import com.winner.evb2.models.EvbBetreuer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Probieren {


    public static void main (String[] args) {
        ArrayList<EvbBetreuer> vkbBetreuerliste = new ArrayList<>();


        vkbBetreuerliste.add(0, new EvbBetreuer("Peter","Mueller", "Muenchen"));




        System.out.println(vkbBetreuerliste.get(0).getWohnort());
    }
    }

