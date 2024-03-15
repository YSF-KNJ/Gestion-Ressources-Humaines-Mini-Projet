import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Enter an employee");
            System.out.println("2. Enter a department");
            System.out.println("3. Enter a poste ");
            System.out.println("4. Enter a location ");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    addDepartment();
                    break;
                case 3:
                    addPost();
                    break;
                case 4:
                    addLocation();
                    break;
                case 5:
                    System.out.println("exit");
                    return;
                default:
                    System.out.println("invalid choice. ");
            }
        }
    }

    public static void addEmployee() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter telephone: ");
        String telephone = scanner.nextLine();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        String query = String.format("INSERT INTO employes (prenom, nom, email, telephone, salaire) VALUES ('%s', '%s', '%s', '%s', %f);",
                firstName, lastName, email, telephone, salary);
        DBConnector.insertQuery(query);
        System.out.println("employee added successfully.");
    }
   public static void addDepartment() {
    System.out.print("Enter department name: ");
    String departmentName = scanner.nextLine();

    String query = String.format("INSERT INTO departement (nom_departement) VALUES ('%s');", departmentName);
    DBConnector.insertQuery(query);
    System.out.println("Department added successfully.");
   }
    public static void addPost() {
      System.out.print("Enter post title: ");
      String postTitle = scanner.nextLine();
      String query = String.format("INSERT INTO poste (titre_poste) VALUES ('%s');", postTitle);
      DBConnector.insertQuery(query);
      System.out.println("Post added successfully.");
   }
    public static void addLocation() {
    System.out.print("Enter address: ");
    String address = scanner.nextLine();
    System.out.print("Enter city: ");
    String city = scanner.nextLine();
    String query = String.format("INSERT INTO localisation (adresse, ville) VALUES ('%s', '%s');", address, city);
    DBConnector.insertQuery(query);
    System.out.println("Location added successfully.");
  }
}

