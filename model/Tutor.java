package model;

/**
 * Representa o tutor (responsavel) pelo animal.
 */
public class Tutor {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;

    public Tutor() {}

    public String getNome()           { return nome; }
    public void   setNome(String v)   { this.nome = v; }

    public String getCpf()            { return cpf; }
    public void   setCpf(String v)    { this.cpf = v; }

    public String getTelefone()       { return telefone; }
    public void   setTelefone(String v) { this.telefone = v; }

    public String getEmail()          { return email; }
    public void   setEmail(String v)  { this.email = v; }

    public String getEndereco()       { return endereco; }
    public void   setEndereco(String v) { this.endereco = v; }
}
