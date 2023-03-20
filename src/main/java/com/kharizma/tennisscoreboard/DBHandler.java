package com.kharizma.tennisscoreboard;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBHandler {
    private static EntityManager instance = null;

    private DBHandler() {
    }

    public static EntityManager getEntityManager() {
        if(instance == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tennis_Scoreboard");
            instance = emf.createEntityManager();
        }
        return instance;
    }
}
