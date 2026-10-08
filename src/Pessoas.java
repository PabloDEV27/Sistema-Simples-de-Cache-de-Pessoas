public class Pessoas {

    //atributos
    private int id;
    private String nome;
    private int idade;

    //construtor
    public Pessoas(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    //metodos
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String toString() {
        return "ID: " + id + " - Nome: " + nome + "' - Idade: " + idade;
    }
}