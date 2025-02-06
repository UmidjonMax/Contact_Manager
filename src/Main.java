import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static File filePath = new File("C:\\Users\\Admin\\Desktop\\file.txt");
    static Scanner scannerNum = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);
    static int generalId = 1;
    public static void main(String[] args) {
        while (true) {
            int n = menu();
            switch (n) {
                case 1 -> {
                    Contact contact = addContact();
                }
                case 2 -> showContact();
                case 3 -> deleteContact();
                case 4 -> editContact();
                case 5 -> searchContact();
                case 0 -> {
                    return;
                }
            }
        }
    }

    private static void deleteContact() {
        List<String> data = new LinkedList<>();
        read(data);
        listShow(data);
        System.out.print("Enter id : ");
        String id = scannerStr.nextLine();
        data.removeIf(s -> s.startsWith(id));
        write(data, false);
    }

    private static Contact addContact() {
        System.out.print("Enter name : ");
        String name = scannerStr.nextLine();
        System.out.print("Enter surname : ");
        String surname = scannerStr.nextLine();
        System.out.print("Enter phone : ");
        String phone = scannerStr.nextLine();
        Contact contact = new Contact(name, surname, phone);
        write(List.of(contact), true);
        return contact;
    }

    private static void write(List<Contact> list, boolean b) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, b), true)) {
                for (Contact contact : list) {
                    writer.println(contact);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void showContact() {
        List<String> list = new LinkedList<>();
        read(list);
        listShow(list);
    }

    private static void read(List<String> list) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listShow(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void searchContact() {
    }

    private static void editContact() {
    }

    
    public static int menu() {
        String menu = """
                *******CONTACT*******
                1.Add Contact
                2.Show Contact
                3.Delete Contact
                4.Edit Contact
                5.Search Contact
                0.Exit
                Enter option :""";
        System.out.print(menu);
        return scannerNum.nextInt();
    }
    }