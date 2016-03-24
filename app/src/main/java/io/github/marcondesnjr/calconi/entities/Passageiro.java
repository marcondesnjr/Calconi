package io.github.marcondesnjr.calconi.entities;

/**
 * Created by Junior on 22/03/2016.
 */
public class Passageiro {

    private int id;
    private String nome;
    private int numDiasAndados;

    public Passageiro(int id, String nome, int numDiasAndados) {
        this.id = id;
        this.nome = nome;
        this.numDiasAndados = numDiasAndados;
    }

    public Passageiro(String nome, int numDiasAndados) {
        this.nome = nome;
        this.numDiasAndados = numDiasAndados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumDiasAndados() {
        return numDiasAndados;
    }

    public void setNumDiasAndados(int numDiasAndados) {
        this.numDiasAndados = numDiasAndados;
    }

    @Override
    public String toString() {
        return "Passageiro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numDiasAndados=" + numDiasAndados +
                '}';
    }
}
