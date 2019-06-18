package com.planner.firstoptaplanner;

public class Audiencia {
    private int id;
    private int num_periods;
    private Juez juez;

    public Audiencia(int id, int num_periods, Juez juez){
        this.id = id;
        this.num_periods = num_periods;
        this.juez = juez;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum_periods() {
        return num_periods;
    }

    public void setNum_periods(int num_periods) {
        this.num_periods = num_periods;
    }

    public Juez getJuez() {
        return juez;
    }

    public void setJuez(Juez juez) {
        this.juez = juez;
    }
}
