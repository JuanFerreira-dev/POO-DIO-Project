package org.caioferreira.entities;

public class Doctor extends Person{
    private String crm;
    private String specialty;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    // Opcional: Adicionar um método toString() para facilitar a exibição
    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + getName() + '\'' +
                ", CPF='" + getCPF() + '\'' +
                ", crm='" + crm + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}
