import java.time.LocalDate;

public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private LocalDate dataNascimento;


    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return    "Nome='" + nome + '\'' +
                ", DataNascimento=" + dataNascimento;
    }
    
    //implementa comparable compareTo
    @Override
    public int compareTo(Pessoa outra) {
        return this.nome.compareTo(outra.nome);
    }


    @Override
    public int hashCode() {
        return nome.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass() || this == obj)
            return false;
        Pessoa other = (Pessoa) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }


    
}
