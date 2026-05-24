import java.util.Scanner;

public class BookingManager {

    private final Scanner scan = new Scanner(System.in);
    private final FileService fileService = new FileService();
    private CinemaHall cinemaHall;

    public void start() {
        int[][] seats = fileService.loadHall("зал.txt");
        this.cinemaHall = new CinemaHall(seats);

        while (true){
            System.out.println("\n_____МЕСТА В ЗАЛЕ_____\n");

            cinemaHall.showScheme();

            System.out.println("\n_____МЕНЮ_____\n");
            System.out.println(" 1 - Забронировать место\n 2 - Войти как админ\n 3 - Закрыть программу");

            int choice = scan.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Введите ряд(1 - 10): ");
                    int row = scan.nextInt();
                    if (row < 1 || row > 10){
                        System.out.println("Неправильно введен ряд!");
                    } else {
                        System.out.print("\nВведите место(1 - 10): ");
                        int col = scan.nextInt();
                        if (col < 1 || col > 10){
                            System.out.println("Неправильно введено место!");
                        } else {
                            boolean success = cinemaHall.bookSeat(row, col);
                            if (success){
                                System.out.println("Место успешно забранировано!");
                                fileService.saveHall("зал.txt", seats);
                            } else {
                                System.out.println("Место занято!");
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Введите логин: ");
                    String login = scan.next();
                    System.out.println("\nВведите пароль: ");
                    String password = scan.next();

                    if (login.equals("admin") && password.equals("admin123")){
                        System.out.println("\n_____Меню Администратора_____\n");
                        System.out.println(" 1 - Выручка\n 2 - Выйти из меню админа\n 3 - Закрыть программу");
                        switch (scan.nextInt()){
                            case 1:
                                System.out.println("Выручка на сегодня: " + cinemaHall.calculateRevenue());
                                break;
                            case 2:
                                break;
                            case 3:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Нет данного пунка в меню!");
                        }
                    } else {
                        System.out.println("Неверный логин или пароль!");
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Нет данного пункта в меню!");
            }

        }
    }
}