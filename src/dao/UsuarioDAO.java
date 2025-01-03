package dao;
import conexoes.Conexao;
import entity.Usuario;
import entity.Aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {


    public void cadastrarUsuario(Usuario usuario){


        String sql = "INSERT INTO USUARIO (NOME, LOGIN, SENHA, EMAIL) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

            try {
                ps = Conexao.getConexao().prepareStatement(sql);
                ps.setString(1, usuario.getNome());
                ps.setString(2, usuario.getLogin());
                ps.setString(3, usuario.getSenha());
                ps.setString(4, usuario.getEmail());
                ps.execute();
                ps.close();



            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public void logarUsuario(Usuario usuario) {

        String sql = "SELECT login, senha FROM usuario WHERE login = ? AND senha = ?";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getLogin());  // Nome do usuário
            ps.setString(2, usuario.getSenha()); // Senha do usuário

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                System.out.println("Logado com sucesso. Seja bem-vindo");
                usuario.setAcesso(true);
            }
            else{
                System.out.println("Credenciais de login incorreta!");
                usuario.setAcesso(false);
            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarAluno(Aluno aluno, Usuario usuario){

        String sql = "INSERT INTO ALUNOS (ALUNONOME, ALUNOLOGIN, ALUNOSENHA, ALUNODATAAGE, DIRETORRESPONSAVEL) VALUES(?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getAlunoLogin());
            ps.setString(3, aluno.getAlunoSenha());
            ps.setString(4, aluno.getDataAge());
            ps.setString(5, usuario.getLogin());
            ps.execute();
            ps.close();


        } catch (SQLException e) {
        e.printStackTrace();
        }
    }

    public void cadastrarNota(Aluno aluno){

        String sql = "UPDATE ALUNOS SET NOTA1 = ?, NOTA2 = ?, NOTA3 = ?, NOTA4 = ? WHERE alunoLogin = ?";

        PreparedStatement ps = null;


        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setDouble(1, aluno.getNota1());
            ps.setDouble(2, aluno.getNota2());
            ps.setDouble(3, aluno.getNota3());
            ps.setDouble(4, aluno.getNota4());
            ps.setString(5, aluno.getAlunoLogin());
            int result = ps.executeUpdate();
            System.out.println("Procurando Aluno...");
            if(result > 0){
                System.out.println("Aluno encontrado");
                System.out.println("notas cadastradas!");
            }
            else{
                System.out.println("O Aluno não existe");
            }

            ps.close();


        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void logarAluno(Aluno aluno){

        String sql = "SELECT alunoLogin, alunoSenha FROM alunos WHERE alunoLogin = ? AND alunoSenha = ?";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, aluno.getAlunoLogin());
            ps.setString(2, aluno.getAlunoSenha());

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                System.out.println("SEJA BEM-VINDO");
                aluno.setAcesso(true);
            } else {
                System.out.println("CREDENCIAIS INCORRETA");
                aluno.setAcesso(false);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

    }


    public void verificarPerfilAluno(Aluno aluno){

        String sql = "SELECT alunoNome, alunoLogin, alunoSenha, alunoDataAge, nota1, nota2, nota3, nota4 FROM alunos WHERE alunoLogin = ?";

        PreparedStatement ps = null;

        try{

            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, aluno.getAlunoLogin());

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                aluno.setNome(rs.getString(1));
                aluno.setAlunoLogin(rs.getString(2));
                aluno.setAlunoSenha(rs.getString(3));
                aluno.setDataAge(rs.getString(4));
                aluno.setNota1(rs.getDouble(5));
                aluno.setNota2(rs.getDouble(6));
                aluno.setNota3(rs.getDouble(7));
                aluno.setNota4(rs.getDouble(8));
            }else{
                System.out.println("Aluno não encontrado!");
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        // exibir perfil do aluno
        int statusAluno = 4;
        System.out.println("---------------------------------");
        System.out.println("          PERFIL ALUNO           ");
        System.out.println("---------------------------------");
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Data de nascimento: " + aluno.getDataAge());
        System.out.println("Login: " + aluno.getAlunoLogin());
        System.out.println("Senha: " + aluno.getAlunoSenha());
        System.out.println("Matemática: " + aluno.getNota1());
        System.out.println("Português: " + aluno.getNota2());
        System.out.println("Física: " + aluno.getNota3());
        System.out.println("Ciências: " + aluno.getNota4());


        // verificação de status de aluno
        if(aluno.getNota1() <= 6){statusAluno -= 1;}
        if(aluno.getNota2() <= 6){statusAluno -= 1;}
        if(aluno.getNota3() <= 6){statusAluno -= 1;}
        if(aluno.getNota4() <= 6){statusAluno -= 1;}
        if (statusAluno < 2){System.out.println("STATUS: REPROVADO");}
        else if (statusAluno == 2) {System.out.println("STATUS: RECUPERAÇÃO");}
        else{System.out.println("STATUS: APROVADO");}

    }
}
