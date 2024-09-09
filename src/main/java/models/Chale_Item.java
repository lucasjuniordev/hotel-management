package models;

public class Chale_Item {
    private int codChale;
    private String nomeItem;

    public Chale_Item(int codChale, String nomeItem) {
        this.codChale = codChale;
        this.nomeItem = nomeItem;
    }

    public int getCodChale() { return codChale; }
    public void setCodChale(int codChale) { this.codChale = codChale; }

    public String getNomeItem() { return nomeItem; }
    public void setNomeItem(String nomeItem) { this.nomeItem = nomeItem; }

    @Override
    public String toString() {
        return "Chale_Item [codChale=" + codChale + ", nomeItem=" + nomeItem + "]";
    }
}
