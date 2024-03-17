class Main {
    public static void main(String[] args) {
        if (Poste.checkID(3) || Employe.checkID(2)) {
            System.out.println("Done");
        } else if (!Poste.checkID(3)) {
            System.out.println("poste makynchi");
        } else if (!Employe.checkID(2)) {
            System.out.println("employe makynchi");
        }
    }
}