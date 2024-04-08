public class Main {
    public static void main(String[] args) {
        Createdb.createdb();
        Createtables.createtables();

        if (Admin.CheckEmpty()) {
            SetupFrame setupframe = new SetupFrame();
            setupframe.setVisible(true);
        } else {
            LoginFrame loginframe = new LoginFrame();
            loginframe.setVisible(true);
        }


    }
}