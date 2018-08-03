public class Main {
    public static void main(String [] args) {
        ContactsManager myContactsManager = new ContactsManager();

        Contact friendKatie = new Contact();
        friendKatie.name = "Katie";
        friendKatie.email = "katie123@gmail.com";
        friendKatie.phoneNumber = "111-111-1111";
        myContactsManager.addContact(friendKatie);

        Contact friendChalo = new Contact();
        friendChalo.name = "Chalo";
        friendChalo.email = "Chalo123@gmail.com";
        friendChalo.phoneNumber = "222-222-2222";
        myContactsManager.addContact(friendChalo);

        Contact friendJenn = new Contact();
        friendJenn.name = "Jenn";
        friendJenn.email = "Jenn123@gmail.com";
        friendJenn.phoneNumber = "333-333-3333";
        myContactsManager.addContact(friendJenn);

        Contact friendMiguelito = new Contact();
        friendMiguelito.name = "Miguelito";
        friendMiguelito.email = "Miguelito123@gmail.com";
        friendMiguelito.phoneNumber = "444-444-4444";
        myContactsManager.addContact(friendMiguelito);

        String katiesPhone = myContactsManager.searchContact("Katie").phoneNumber;
        System.out.println(katiesPhone);
    }

}
