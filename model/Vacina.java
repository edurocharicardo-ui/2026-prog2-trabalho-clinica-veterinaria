package model;

/**
 * Representa uma vacina do animal com controle de datas.
 */
public class Vacina {
    private String  nome;
    private String  ultimaDose;
    private String  proximaDose;
    private boolean aplicada;

    public Vacina(String nome) {
        this.nome    = nome;
        this.aplicada = false;
    }

    public String  getNome()            { return nome; }

    public String  getUltimaDose()      { return ultimaDose; }
    public void    setUltimaDose(String v) { this.ultimaDose = v; }

    public String  getProximaDose()     { return proximaDose; }
    public void    setProximaDose(String v) { this.proximaDose = v; }

    public boolean isAplicada()         { return aplicada; }
    public void    setAplicada(boolean v) { this.aplicada = v; }
}
