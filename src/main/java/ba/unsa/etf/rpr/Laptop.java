package ba.unsa.etf.rpr;

import java.io.Serializable;

public class Laptop implements Serializable {
    private String brend, model, procesor, grafickaKartica;
    private Double cijena, velicinaEkrana;
    private int ram , hdd, ssd;

    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcesor() {
        return procesor;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public String getGrafickaKartica() {
        return grafickaKartica;
    }

    public void setGrafickaKartica(String grafickaKartica) {
        this.grafickaKartica = grafickaKartica;
    }

    public Double getCijena() {
        return cijena;
    }

    public void setCijena(Double cijena) {
        this.cijena = cijena;
    }

    public Double getVelicinaEkrana() {
        return velicinaEkrana;
    }

    public void setVelicinaEkrana(Double velicinaEkrana) {
        this.velicinaEkrana = velicinaEkrana;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }
    public void ispisiNaEkran() {
        System.out.println("CPU " + procesor + " GPU " + grafickaKartica
                        + " HDD" + hdd + " SSD " + ssd);
        System.out.println("Velicina ekrana " + velicinaEkrana);
        System.out.println("Brend " + brend + " Model " + model);
        System.out.println("Cijena " + cijena);;
    }
}
