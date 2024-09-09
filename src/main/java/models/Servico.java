package models;

public class Servico {
    private int codServico;
    private String nomeServico;
    private double valorServico;
    
    public Servico() {
    }
    
    public int getCodServico() { return codServico; }
    public void setCodServico(int codServico) { this.codServico = codServico; }

    public String getNomeServico() { return nomeServico; }
    public void setNomeServico(String nomeServico) { this.nomeServico = nomeServico; }

    public double getValorServico() { return valorServico; }
    public void setValorServico(double valorServico) { this.valorServico = valorServico; }
}

