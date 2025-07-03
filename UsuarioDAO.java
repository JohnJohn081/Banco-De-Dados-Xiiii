package dao;
import conexoes.Conexao;
import entity.Usuario;
import entity.Aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UsuarioDAO {
    String loginAluno;
    String senhaAluno;
    String login;
    String senha;
    Scanner sc = new Scanner(System.in);

    public void cadastrarUsuario(Usuario usuario){


        String sql = "INSERT INTO USUARIO (NOME, LOGIN, SENHA, EMAIL) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        System.out.print("Digite seu nome completo: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu novo login: ");
        login = sc.nextLine();
        System.out.print("Digite sua nova senha: ");
        senha = sc.nextLine();
        System.out.println("Cadastrando usuario...");

        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setEmail("null");

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

        System.out.print("Digite seu Login: ");
        login = sc.nextLine();
        System.out.print("Digite sua senha: ");
        senha = sc.nextLine();
        System.out.println("Aguarde...");
        usuario.setLogin(login);
        usuario.setSenha(senha);

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

        System.out.print("Digite o nome do aluno: ");
        String nomeAluno = sc.nextLine();
        System.out.print("Digite qual será o Login do aluno: ");
        loginAluno = sc.nextLine();
        System.out.print("Digite qual será a Senha do aluno: ");
        senhaAluno = sc.nextLine();
        System.out.print("Digite a data de nascimento do aluno(ex: 11/11/2011): ");
        String dataAgeAluno = sc.nextLine();

        aluno.setNome(nomeAluno);
        aluno.setAlunoLogin(loginAluno);
        aluno.setAlunoSenha(senhaAluno);
        aluno.setDataAge(dataAgeAluno);

        System.out.println("Cadastrando aluno...");
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

        System.out.print("Digite a nota de Matemática do aluno: ");
        float nota1 = sc.nextFloat();
        System.out.print("Digite a nota de Português do aluno: ");
        float nota2 = sc.nextFloat();
        System.out.print("Digite a nota de Física do aluno: ");
        float nota3 = sc.nextFloat();
        System.out.print("Digite a nota de Ciências do aluno: ");
        float nota4 = sc.nextFloat();

        aluno.setNota1(nota1);
        aluno.setNota2(nota2);
        aluno.setNota3(nota3);
        aluno.setNota4(nota4);

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

        System.out.print("Digite seu login: ");
        loginAluno = sc.nextLine();
        System.out.print("Digite sua senha: ");
        senhaAluno = sc.nextLine();
        System.out.println("Aguarde...");
        aluno.setAlunoLogin(loginAluno);
        aluno.setAlunoSenha(senhaAluno);


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

    public void procurarAluno(Aluno aluno, Usuario usuario){

        String sql = "SELECT alunoLogin FROM alunos WHERE alunoLogin = ?";

        PreparedStatement ps = null;
        System.out.print("Digite o login do aluno: ");
        loginAluno = sc.nextLine();
        aluno.setAlunoLogin(loginAluno);

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, aluno.getAlunoLogin());
            System.out.println("Procurando aluno...");
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                System.out.println("Aluno encontrado");
                usuario.setAlunoVerificacao(true);
            } else {
                System.out.println("Aluno não existe");
                usuario.setAlunoVerificacao(false);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void printarMensagemCadastroAdmin (Usuario usuario){
        System.out.println("---------------------------------");
        System.out.println("        BEM-VINDO                ");
        System.out.println("-                                ");
        System.out.println("-  1- Cadastrar Aluno            ");
        System.out.println("-  2- Editar aluno               ");
        System.out.println("-  3- Voltar                     ");
        System.out.println("-                                ");
        System.out.println("---------------------------------");
        System.out.print("Escolha uma opção: ");
    }

    public void printarMensagemPainelAluno(Aluno aluno){
        System.out.println("---------------------------------");
        System.out.println("        BEM-VINDO                ");
        System.out.println("-                                ");
        System.out.println("-  1- Verificar perfil           ");
        System.out.println("-  2- Cronograma                 ");
        System.out.println("-  3- Exit                       ");
        System.out.println("-                                ");
        System.out.println("---------------------------------");
        System.out.print("Digite uma opção: ");
    }

    public void printarConogramaAluno(Aluno aluno){
        System.out.println("+----------------+-----------+-----------+-----------+-----------+-----------+");
        System.out.println("|     Horário    |  Segunda  |   Terça   |  Quarta   |   Quinta  |   Sexta   |");
        System.out.println("+----------------+-----------+-----------+-----------+-----------+-----------+");
        System.out.println("|  7:30 - 8:20   | Matemática|   Inglês  |   Artes   |  História | Geografia |");
        System.out.println("|  8:20 - 9:10   | Matemática|   Química | Filosofia | Ed. Física| Português |");
        System.out.println("|  9:10 - 9:30   |    ------- Intervalo -------                              |");
        System.out.println("|  9:30 - 10:20  | Geografia | Matemática| Português |   Inglês  |  Química  |");
        System.out.println("| 10:20 - 11:10  |   Artes   |  História | Filosofia | Ed. Física| Matemática|");
        System.out.println("| 11:10 - 12:00  | Português |   Inglês  | Matemática|  História |  Química  |");
        System.out.println("+----------------+-----------+-----------+-----------+-----------+-----------+");
        System.out.println("| 12:00 - 13:00  |                 Almoço                                    |");
        System.out.println("+----------------+-----------+-----------+-----------+-----------+-----------+");
        System.out.println("| 13:00 - 13:50  |   Química | Português | Matemática| Filosofia | Geografia |");
        System.out.println("| 13:50 - 14:40  |  História | Ed. Física|   Inglês  | Português | Matemática|");
        System.out.println("| 14:40 - 15:00  |    ------- Intervalo -------                              |");
        System.out.println("| 15:00 - 15:50  | Matemática| Português |   Química |  História | Filosofia |");
        System.out.println("| 15:50 - 16:40  |   Inglês  |   Artes   | Geografia | Matemática| Ed. Física|");
        System.out.println("+----------------+-----------+-----------+-----------+-----------+-----------+");

    }
}

