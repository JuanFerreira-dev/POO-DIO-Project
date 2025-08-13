package org.caioferreira.entities;

public class Nurse extends Person{
    private String coren;
    private String shift;

    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "name='" + getName() + '\'' +
                ", CPF='" + getCPF() + '\'' +
                ", coren='" + coren + '\'' +
                ", shift='" + shift + '\'' +
                '}';
    }
}
