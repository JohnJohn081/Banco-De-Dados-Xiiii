import dao.UsuarioDAO;
import entity.Usuario;
import entity.Aluno;
import java.util.Scanner;


public class App {
    public static void main(String[] args)  {
        boolean continuar = true;
        String senha;
        String login;
        int resposta;
        String loginAluno;
        String senhaAluno;
        Usuario u = new Usuario();
        Aluno al = new Aluno();
        Scanner sc = new Scanner(System.in);
        while (continuar){


            System.out.println("---------------------------------");
            System.out.println("-                                ");
            System.out.println("-   Banco De Dados Xiiii         ");
            System.out.println("-                                ");
            System.out.println("-  1- Logar                      ");
            System.out.println("-  2- Cadastrar                  ");
            System.out.println("-  3- Logar aluno                ");
            System.out.println("-  4- Exit                       ");
            System.out.println("-                                ");
            System.out.println("---------------------------------");
            System.out.print("Escolha uma opção: ");
            resposta = sc.nextInt();


            switch (resposta){
                case 1:
                    sc.nextLine();
                    System.out.print("Digite seu Login: ");
                    login = sc.nextLine();
                    System.out.print("Digite sua senha: ");
                    senha = sc.nextLine();
                    u.setLogin(login);
                    u.setSenha(senha);

                    new UsuarioDAO().logarUsuario(u);

                    while(u.isAcesso()){
                        if (u.isAcesso()){


                        System.out.println("---------------------------------");
                        System.out.println("        BEM-VINDO                ");
                        System.out.println("-                                ");
                        System.out.println("-  1- Cadastrar Aluno            ");
                        System.out.println("-  2- Editar aluno               ");
                        System.out.println("-  3- Voltar                     ");
                        System.out.println("-                                ");
                        System.out.println("---------------------------------");
                        System.out.print("Escolha uma opção: ");
                        resposta = sc.nextInt();
                            switch (resposta){
                                case 1:
                                    sc.nextLine();
                                    System.out.print("Digite o nome do aluno: ");
                                    String nomeAluno = sc.nextLine();
                                    System.out.print("Digite qual será o Login do aluno: ");
                                    loginAluno = sc.nextLine();
                                    System.out.print("Digite qual será a Senha do aluno: ");
                                    senhaAluno = sc.nextLine();
                                    System.out.print("Digite a data de nascimento do aluno(ex: 11/11/2011): ");
                                    String dataAgeAluno = sc.nextLine();

                                    al.setNome(nomeAluno);
                                    al.setAlunoLogin(loginAluno);
                                    al.setAlunoSenha(senhaAluno);
                                    al.setDataAge(dataAgeAluno);

                                    System.out.println("Cadastrando aluno...");
                                    new UsuarioDAO().cadastrarAluno(al);
                                    System.out.println("Aluno cadastrado!");
                                    break;
                                case 2:
                                    sc.nextLine();
                                    System.out.print("Digite o login do aluno: ");
                                    loginAluno = sc.nextLine();
                                    System.out.print("Digite a primeira nota do aluno: ");
                                    float nota1 = sc.nextFloat();
                                    System.out.print("Digite a segunda nota do aluno: ");
                                    float nota2 = sc.nextFloat();
                                    System.out.print("Digite a terceira nota do aluno: ");
                                    float nota3 = sc.nextFloat();
                                    System.out.print("Digite a quarta nota do aluno: ");
                                    float nota4 = sc.nextFloat();

                                    al.setAlunoLogin(loginAluno);
                                    al.setNota1(nota1);
                                    al.setNota2(nota2);
                                    al.setNota3(nota3);
                                    al.setNota4(nota4);
                                    new UsuarioDAO().cadastrarNota(al);

                                    break;
                                case 3:
                                    System.out.println("Deslogando usuario...");
                                    u.setAcesso(false);
                                    System.out.println("Usuario Deslogado");
                                    break;
                                default:
                                    System.out.println("OPÇÃO INCORRETA");
                                    break;
                            }
                        }
                        else {
                        System.out.println("Login ou senha incorreto!");
                        }
                    }

                    break;
                case 2:
                    sc.nextLine();
                    System.out.print("Digite seu nome completo: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite seu novo login: ");
                    login = sc.nextLine();
                    System.out.print("Digite sua nova senha: ");
                    senha = sc.nextLine();
                    System.out.println("Cadastrando usuario...");

                    u.setNome(nome);
                    u.setLogin(login);
                    u.setSenha(senha);
                    u.setEmail("null");

                    new UsuarioDAO().cadastrarUsuario(u);

                    System.out.println("Usuario cadastrado com sucesso!");
                    break;
                case 3:
                    sc.nextLine();
                    System.out.print("Digite seu login: ");
                    loginAluno = sc.nextLine();
                    System.out.print("Digite sua senha: ");
                    senhaAluno = sc.nextLine();

                    al.setAlunoLogin(loginAluno);
                    al.setAlunoSenha(senhaAluno);

                    new UsuarioDAO().logarAluno(al);

                    if (al.isAcesso()){
                        System.out.println("---------------------------------");
                        System.out.println("        BEM-VINDO                ");
                        System.out.println("-                                ");
                        System.out.println("-  1- Verificar perfil           ");
                        System.out.println("-  2- Cronograma                 ");
                        System.out.println("-                                ");
                        System.out.println("---------------------------------");
                        System.out.print("Digite uma opção: ");
                        resposta = sc.nextInt();

                        switch (resposta){
                            case 1:
                                new UsuarioDAO().verificarBoletimAluno(al);
                                System.out.println("Nome: " + al.getNome());
                                System.out.println("Data de nascimento: " + al.getDataAge());
                                System.out.println("Login: " + al.getAlunoLogin());
                                System.out.println("Senha: " + al.getAlunoSenha());
                                System.out.println("Nota 1: " + al.getNota1());
                                System.out.println("Nota 2: " + al.getNota2());
                                System.out.println("Nota 3: " + al.getNota3());
                                System.out.println("Nota 4: " + al.getNota4());



                                break;
                            case 2:
                                System.out.println("embreve");
                                break;
                            default:
                                System.out.println("opção invalida");
                                break;
                        }

                    }else {
                        System.out.println("Login ou senha incorreta");
                    }

                case 4:
                    System.out.print("voce realmente quer sair? (1-sim/2-não): ");
                    resposta = sc.nextInt();
                    if (resposta == 1){
                    System.out.println("Até breve!");
                    continuar = false;}
                    else {
                        System.out.println("voltando...");
                    }
                    break;
                default:

                    break;
            }
        }
    }
}
