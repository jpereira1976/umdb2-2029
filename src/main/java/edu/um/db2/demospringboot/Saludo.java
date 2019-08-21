package edu.um.db2.demospringboot;


public class Saludo {
    private String ingles;
    private String espanol;

    public Saludo(String ingles, String espanol) {
        this.ingles = ingles;
        this.espanol = espanol;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public String getEspanol() {
        return espanol;
    }

    public void setEspanol(String espanol) {
        this.espanol = espanol;
    }
}
