package entity;

public class Aluno {

    private String nome;
    private String dataAge;
    private String alunoLogin;
    private String alunoSenha;
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;
    private boolean acesso;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlunoLogin() {
        return alunoLogin;
    }

    public void setAlunoLogin(String alunoLogin) {
        this.alunoLogin = alunoLogin;
    }

    public String getAlunoSenha() {
        return alunoSenha;
    }

    public void setAlunoSenha(String alunoSenha) {
        this.alunoSenha = alunoSenha;
    }

    public String getDataAge() {
        return dataAge;
    }

    public void setDataAge(String dataAge) {
        this.dataAge = dataAge;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getNota4() {
        return nota4;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    public boolean isAcesso() {
        return acesso;
    }

    public void setAcesso(boolean acesso) {
        this.acesso = acesso;
    }
}
