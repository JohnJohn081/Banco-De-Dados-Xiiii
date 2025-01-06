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
                            System.out.println("---------------------------------");
                            System.out.println("        BEM-VINDO                ");
                            System.out.println("-                                ");
                            System.out.println("-  1- Verificar perfil           ");
                            System.out.println("-  2- Cronograma                 ");
                            System.out.println("-  3- Exit                       ");
                            System.out.println("-                                ");
                            System.out.println("---------------------------------");
                            System.out.print("Digite uma opção: ");
                            resposta = sc.nextInt();

                            switch (resposta) {
                                case 1:
                                    new UsuarioDAO().verificarPerfilAluno(al);
                                    break;
                                case 2:
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

                    break;
            }
        }
    }
}
