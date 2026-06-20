package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um animal paciente da clinica veterinaria.
 */
public class Animal {
    private String nome;
    private String especie;
    private String raca;
    private String dataNascimento;
    private double peso;
    private double altura;
    private String fotoPath;
    private Tutor tutor;
    private List<Consulta> consultas;
    private List<Vacina> vacinas;

    public Animal() {
        consultas = new ArrayList<>();
        vacinas  = new ArrayList<>();
    }

    // ---- Getters e Setters ----
    public String getNome()              { return nome; }
    public void   setNome(String v)      { this.nome = v; }

    public String getEspecie()           { return especie; }
    public void   setEspecie(String v)   { this.especie = v; }

    public String getRaca()              { return raca; }
    public void   setRaca(String v)      { this.raca = v; }

    public String getDataNascimento()    { return dataNascimento; }
    public void   setDataNascimento(String v) { this.dataNascimento = v; }

    public double getPeso()              { return peso; }
    public void   setPeso(double v)      { this.peso = v; }

    public double getAltura()            { return altura; }
    public void   setAltura(double v)    { this.altura = v; }

    public String getFotoPath()          { return fotoPath; }
    public void   setFotoPath(String v)  { this.fotoPath = v; }

    public Tutor getTutor()              { return tutor; }
    public void  setTutor(Tutor t)       { this.tutor = t; }

    public List<Consulta> getConsultas() { return consultas; }
    public List<Vacina>   getVacinas()   { return vacinas; }

    public void adicionarConsulta(Consulta c) { consultas.add(c); }
    public void adicionarVacina(Vacina v)     { vacinas.add(v); }

    @Override
    public String toString() {
        return nome != null ? nome : "Animal sem nome";
    }
}
