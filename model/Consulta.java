package model;

/**
 * Representa uma consulta medica veterinaria.
 */
public class Consulta {
    private String data;
    private String veterinario;
    private String motivo;
    private String observacoes;

    public Consulta(String data, String veterinario, String motivo, String observacoes) {
        this.data         = data;
        this.veterinario  = veterinario;
        this.motivo       = motivo;
        this.observacoes  = observacoes;
    }

    public String getData()        { return data; }
    public String getVeterinario() { return veterinario; }
    public String getMotivo()      { return motivo; }
    public String getObservacoes() { return observacoes; }
}
