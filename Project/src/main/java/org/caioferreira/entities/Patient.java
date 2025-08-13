package org.caioferreira.entities;

public class Patient extends Person {
    private String idPaciente;
    private String planoSaude;
    private Doctor medicoResponsavel;
    private String problemaSaude;

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(String planoSaude) {
        this.planoSaude = planoSaude;
    }

    public Doctor getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(Doctor medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }

    public String getProblemaSaude() {
        return problemaSaude;
    }

    public void setProblemaSaude(String problemaSaude) {
        this.problemaSaude = problemaSaude;
    }

    // Suggested toString() method for better printing
    @Override
    public String toString() {
        return "Patient{" +
                "idPaciente='" + idPaciente + '\'' +
                ", planoSaude='" + planoSaude + '\'' +
                ", problemaSaude='" + problemaSaude + '\'' +
                ", medicoResponsavel=" + (medicoResponsavel != null ? medicoResponsavel.getName() : "None") +
                '}';
    }
}
