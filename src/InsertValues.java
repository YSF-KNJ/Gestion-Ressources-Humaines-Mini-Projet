import java.sql.Connection;
import java.sql.Statement;

public class InsertValues {
    public static void insert() {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conct = MySQLConnector.getConnection();
            Statement stmt = conct.createStatement();

            String insertToPosteTable = "INSERT INTO poste (titre_poste) VALUES ('Software Engineer'), ('HR Manager'), ('Marketing Specialist'), ('Financial Analyst'), ('Sales Associate');";
            stmt.executeUpdate(insertToPosteTable);

            String insertToLocalisationTable = "INSERT INTO localisation (adresse, ville) VALUES ('123 Rue Mohammed V', 'Casablanca'), ('456 Avenue Hassan II', 'Rabat'), ('789 Rue Mohammed VI', 'Marrakech'), ('101 Avenue Mohammed V', 'Fes'), ('202 Boulevard Mohammed VI', 'Tangier');";
            stmt.executeUpdate(insertToLocalisationTable);


            String insertToDepartementTable = "INSERT INTO departement (nom_departement, id_localisation) VALUES ('IT Department', 4), ('Human Resources', 1), ('Marketing Department', 3), ('Finance Department', 2), ('Sales Department', 5);";
            stmt.executeUpdate(insertToDepartementTable);

            String insertToEmployesTable = "INSERT INTO employes (prenom, nom, email, telephone, salaire, id_poste, id_departement, id_manager) VALUES ('Kanjaa', 'Youssef', 'ysfknj@example.com', '+212637767890', 75000.00, 4, 2, NULL), ('Chairi Zrermi', 'Ouassima', 'ouassimazrermi@example.com', '+212567333332', 60000.00, 1, 4, 1), ('Bentaouyt', 'Nada', 'Bentaouytn@gmail.com', '+212687315555', 55000.00, 4, 3, 1), ('Baghouss', 'Ferdaouss', 'Ferdaouss@gmail.com', '+212711222333', 60000.00, 5, 4, 1), ('Ainouz', 'Mohamed', 'aiz.Mohamed@example.com', '+212698887777', 50000.00, 3, 5, 1);";
            stmt.executeUpdate(insertToEmployesTable);
            conct.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
