package models;

public class Telefone {
    private int telefone;
    private int codCliente;
    private String tipoTelefone;
    
    public Telefone() {
    }
    
    public int getTelefone() { return telefone; }
    public void setTelefone(int telefone) { this.telefone = telefone; }

    public int getCodCliente() { return codCliente; }
    public void setCodCliente(int codCliente) { this.codCliente = codCliente; }

    public String getTipoTelefone() { return tipoTelefone; }
    public void setTipoTelefone(String tipoTelefone) { this.tipoTelefone = tipoTelefone; }
}
