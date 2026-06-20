package controller;

import model.Animal;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador principal do sistema.
 * Guarda a lista de animais e o animal em edicao no momento.
 */
public class VetController {

    private List<Animal> animais     = new ArrayList<>();
    private Animal       animalAtual = new Animal();

    // Retorna todos os animais cadastrados
    public List<Animal> getAnimais()     { return animais; }

    // Retorna o animal sendo editado
    public Animal getAnimalAtual()       { return animalAtual; }

    // Define qual animal esta sendo editado
    public void setAnimalAtual(Animal a) { this.animalAtual = a; }

    /** Prepara uma ficha nova em branco */
    public void novoAnimal() {
        animalAtual = new Animal();
    }

    /**
     * Salva o animal atual na lista.
     * Se ja estiver na lista (mesmo objeto), nao duplica.
     */
    public void salvarAnimal() {
        if (!animais.contains(animalAtual)) {
            animais.add(animalAtual);
        }
    }

    /** Remove um animal da lista */
    public void removerAnimal(Animal a) {
        animais.remove(a);
    }

    /** Busca animais pelo nome (suporta busca parcial) */
    public List<Animal> buscarPorNome(String nome) {
        List<Animal> resultado = new ArrayList<>();
        for (Animal a : animais) {
            if (a.getNome() != null &&
                a.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(a);
            }
        }
        return resultado;
    }
}
