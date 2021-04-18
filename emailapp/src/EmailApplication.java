public class EmailApplication {

    public static void main(String[] args) {
        Email em = new Email("John", "Cena");
        em.changePassword("asd123zxc123");
        System.out.println(em);
        System.out.println(em.printEmail());
    }
}
