package models;

import java.sql.Date;

public class Hospedagem_Servico {
    private int codHospedagem;
    private Date dataServico;
    private int codServico;
    private double valorServico;

    public Hospedagem_Servico(int codHospedagem, Date dataServico, int codServico, double valorServico) {
        this.codHospedagem = codHospedagem;
        this.dataServico = dataServico;
        this.codServico = codServico;
        this.valorServico = valorServico;
    }

    public int getCodHospedagem() { return codHospedagem; }
    public void setCodHospedagem(int codHospedagem) { this.codHospedagem = codHospedagem; }

    public Date getDataServico() { return dataServico; }
    public void setDataServico(Date dataServico) { this.dataServico = dataServico; }

    public int getCodServico() { return codServico; }
    public void setCodServico(int codServico) { this.codServico = codServico; }

    public double getValorServico() { return valorServico; }
    public void setValorServico(double valorServico) { this.valorServico = valorServico; }

    @Override
    public String toString() {
        return "Hospedagem_Servico [codHospedagem=" + codHospedagem + ", dataServico=" + dataServico + ", codServico=" + codServico + ", valorServico=" + valorServico + "]";
    }
}
