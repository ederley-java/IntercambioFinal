package model;

public class Cadastro {

    private String nome;
    private String email;
    private String categoria;

    public Cadastro(String nome, String email, String categoria) {
        this.nome = nome;
        this.email = email;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Cadastro [nome=" + nome
                + ", email=" + email + ", categoria" + categoria + "]";
    }

    public Cadastro() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
     

}