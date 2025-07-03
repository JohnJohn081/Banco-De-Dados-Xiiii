import dao.UsuarioDAO;
import entity.Usuario;
import entity.Aluno;
import java.util.Scanner;


public class App {
    public static void main(String[] args)  {
        boolean continuar = true;
        int resposta;
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

                    new UsuarioDAO().logarUsuario(u);

                    while(u.isAcesso()){
                        if (u.isAcesso()){

                        new UsuarioDAO().printarMensagemCadastroAdmin(u);
                        resposta = sc.nextInt();
                            switch (resposta){
                                case 1:
                                    sc.nextLine();
                                    new UsuarioDAO().cadastrarAluno(al, u);
                                    System.out.println("Aluno cadastrado!");
                                    break;
                                case 2:
                                    sc.nextLine();
                                    new UsuarioDAO().procurarAluno(al, u);
                                    if (u.isAlunoVerificacao()){
                                        new UsuarioDAO().cadastrarNota(al);
                                        break;
                                    }
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

                    new UsuarioDAO().cadastrarUsuario(u);

                    System.out.println("Usuario cadastrado com sucesso!");
                    break;
                case 3:
                    sc.nextLine();

                    new UsuarioDAO().logarAluno(al);
                    while(al.isAcesso()) {
                        if (al.isAcesso()) {
                            new UsuarioDAO().printarMensagemPainelAluno(al);
                            resposta = sc.nextInt();

                            switch (resposta) {
                                case 1:
                                    new UsuarioDAO().verificarPerfilAluno(al);
                                    break;
                                case 2:
                                    new UsuarioDAO().printarConogramaAluno(al);
                                     break;
                                case 3:
                                    System.out.println("Deslogando usuario...");
                                    al.setAcesso(false);
                                    System.out.println("Usuario Deslogado");
                                    break;
                                default:
                                    System.out.println("opção invalida");
                                    break;
                            }

                        } else {
                            System.out.println("Login ou senha incorreta");
                        }
                    }

                case 4:
                    System.out.print("Deseja voltar ao menu inicial? (1-sim/2-não): ");
                    resposta = sc.nextInt();
                    if (resposta == 2){
                    System.out.println("Até breve!");
                    continuar = false;}
                    else {
                        System.out.println("Retornando...");
                    }
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
    }
}
