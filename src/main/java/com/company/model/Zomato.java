package com.company.model;

public class Zomato {


    private String rest1N;
    private String rest1U;
    private String rest1L;
    private String rest1Cuis;
    private String rest1AvgCst;


    public Zomato() {

        rest1N = "";
        rest1U = "";
        rest1L = "";
        rest1Cuis = "";
        rest1AvgCst = "";

    }

    public Zomato(String rest1N, String rest1U, String rest1L, String rest1Cuis, String rest1AvgCst) {

        rest1N = rest1N;
        rest1U = rest1U;
        rest1L = rest1L;
        rest1Cuis = rest1Cuis;
        rest1AvgCst = rest1AvgCst;

    }

    public String getRest1N() {
        return rest1N;
    }

    public void setRest1N(String rest1N) {
        this.rest1N = rest1N;
    }

    public String getRest1U() {
        return rest1U;
    }

    public void setRest1U(String rest1U) {
        this.rest1U = rest1U;
    }

    public String getRest1L() {
        return rest1L;
    }

    public void setRest1L(String rest1L) {
        this.rest1L = rest1L;
    }

    public String getRest1Cuis() {
        return rest1Cuis;
    }

    public void setRest1Cuis(String rest1Cuis) {
        this.rest1Cuis = rest1Cuis;
    }

    public String getRest1AvgCst() {
        return rest1AvgCst;
    }

    public void setRest1AvgCst(String rest1AvgCst) {
        this.rest1AvgCst = rest1AvgCst;
    }

    public String toString() {

        String result = "";

        System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s", rest1N, rest1U, rest1L, rest1Cuis, rest1AvgCst);
        return result;
    }

}