package preparation;
import java.util.*;
import java.time.*;

public class LibraryManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Book> book = new HashMap<>();
    static LinkedList<Integer> key = new LinkedList<>();
    static int noOFBooks = 9;

    private static void addKeys() {
        for (int i = 1; i <= noOFBooks; i++) {
            key.add(1000 + i);
        }
    }

    private static void addBooks() {
        book.put(key.get(0), new Book("Head First Java", "B.J.Anderson", "Available!"));
        book.put(key.get(1), new Book("C++ Primer", "T.Morgan", "Available!"));
        book.put(key.get(2), new Book("Automate Using Python", "M.Root", "Available!"));
        book.put(key.get(3), new Book("Programming Approach Using JavaScript", "Tom Roy", "Available!"));
        book.put(key.get(4), new Book("Rust Programming Book", "M.D.Stuart", "Available!"));
        book.put(key.get(5), new Book("Machine Learning Using Python", "M.T.Baristow", "Available!"));
        book.put(key.get(6), new Book("Data Science Master", "H.Z.Buttler", "Available!"));
        book.put(key.get(7), new Book("Artificial Intelligence With Python", "D.Silva", "Issued!"));
        book.put(key.get(8), new Book("Robotics", "F.R.Henry", "Issued!"));
    }

    static class Book {
        String bookName, bookAuthor, bookStatus;

        Book(String bookName, String bookAuthor, String bookStatus) {
            this.bookName = bookName;
            this.bookAuthor = bookAuthor;
            this.bookStatus = bookStatus;
        }

        public String toString() {
            return "Book Name   : " + this.bookName + "\nBook Author : " + this.bookAuthor + "\nStatus      : " + this.bookStatus;
        }
    }

    public static void availableBooks() {
        for (int i = 0; i < noOFBooks; i++) {
            Book checkBook = book.get(key.get(i));
            if (checkBook.bookStatus.equals("Issued!")) {
                continue;
            } else {
                System.out.println("Book Key    : " + key.get(i));
                System.out.println(checkBook);
                System.out.println();
            }
        }
    }

    public static void issuedBooks() {
        for (int i = 0; i < noOFBooks; i++) {
            Book checkBook = book.get(key.get(i));
            if (checkBook.bookStatus.equals("Available!")) {
                continue;
            } else {
                System.out.println("Book Key    : " + key.get(i));
                System.out.println(checkBook);
                System.out.println();
            }
        }
    }

    public static void toissueBook() {
        System.out.println("\t*Enter your information first.");
        sc.nextLine();
        System.out.print("\t\t    Name     : ");
        String name = sc.nextLine();
        System.out.print("\t\t   E-Mail    : ");
        String email = sc.nextLine();
        System.out.print("\t\tPhone Number : ");
        String number = sc.nextLine();
        System.out.println();
        System.out.println("Following is the list of available books : ");
        availableBooks();
        System.out.println();
        System.out.print("Enter the key of book which you want to issue : ");
        int bookKey = sc.nextInt();
        while (!key.contains(bookKey) || book.get(bookKey).bookStatus.equals("Issued!")) {
            System.out.println("Oops ! You entered a wrong key !");
            System.out.print("Please enter a valid key of book again which you want to issue : ");
            bookKey = sc.nextInt();
        }
        System.out.println();
        Book bookDetails = book.get(bookKey);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("  Congratulations ! \n\tThis Book : " + bookDetails.bookName + "\n\tWritten By : " + bookDetails.bookAuthor + "\n\tIs issued To : " + name + "\n\tOn the date : " + LocalDate.now() + "\n\tAt Time : " + LocalTime.now() + "\n\tWith E-Mail Address : " + email + "\n\tNote : This is issued for 30 days and after 30 days you have to returnn this book.");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        bookDetails.bookStatus = "Issued!";
        System.out.println("  Now if you want to check following press : \n\t1 : Available Books List\n\t2 : Issued Books List\n\t3 : To Exit");
        byte num2 = sc.nextByte();
        if (num2 == 1) {
            availableBooks();
        } else if (num2 == 2) {
            issuedBooks();
        } else {
            System.out.println("\t ***Thanks For Coming !***");
            System.exit(0); // Exit the program
        }
    }

    public static void addBook() {
        sc.nextLine();
        System.out.print("\tEnter Book Name : ");
        String book1 = sc.nextLine();
        System.out.print("\tEnter Book Author Name : ");
        String author1 = sc.nextLine();
        noOFBooks++;
        int keyno1 = 1000 + noOFBooks;
        String status1 = "Available!";
        key.add(keyno1);
        book.put(key.get(noOFBooks - 1), new Book(book1, author1, status1));
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Successfully ! \n\t Your book is added to library.\n\t Thanks For Coming!.");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("  Now if you want to check following press : \n\t1 : Available Books List\n\t2 : Issued Books List\n\t3 : To Exit");
        byte num2 = sc.nextByte();
        if (num2 == 1) {
            availableBooks();
        } else if (num2 == 2) {
            issuedBooks();
        } else {
            System.out.println("\t ***Thanks For Coming !***");
            System.exit(0); // Exit the program
        }
    }

    public static void returnBook() {
        sc.nextLine();
        System.out.print("Enter book's key which you want to return : ");
        int returnkey = sc.nextInt();
        while (!key.contains(returnkey) || book.get(returnkey).bookStatus.equals("Available!")) {
            System.out.println("\tOops !\n\t  Your entered key doesn't match our library's issued books' keys.");
            System.out.print("Please enter a valid key of book again which you want to return : ");
            returnkey = sc.nextInt();
        }
        book.get(returnkey).bookStatus = "Available!";
        System.out.println();
        System.out.println("\t ***Thanks For Coming !***");
        System.out.println();
        System.out.println("  Now if you want to check following press : \n\t1 : Available Books List\n\t2 : Issued Books List\n\t3 : To Exit");
        byte num2 = sc.nextByte();
        if (num2 == 1) {
            availableBooks();
        } else if (num2 == 2) {
            issuedBooks();
        } else {
            System.out.println("\t ***Thanks For Coming !***");
            System.exit(0); // Exit the program
        }
    }

    public static void main(String[] args) {
        do {
            addKeys();
            addBooks();
            System.out.println("\t\t\t\t\t---------------------------------------");
            System.out.println("\t\t\t\t\t|      LIBRARY MANAGEMENT SYSTEM      |");
            System.out.println("\t\t\t\t\t---------------------------------------");
            System.out.println("\t\tPress:\n\t\t1 : Available Books List\n\t\t2 : Issued Books List\n\t\t3 : To Issue A Book\n\t\t4 : To Add A Book\n\t\t5 : To Return A Book\n\t\t6 : To Exit");
            byte select = sc.nextByte();
            switch (select) {
                case 1:
                    availableBooks();
                    break;
                case 2:
                    issuedBooks();
                    break;
                case 3:
                    toissueBook();
                    break;
                case 4:
                    addBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    System.out.println("\t ***Thanks For Coming !***");
                    System.exit(0); // Exit the program
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (true);
    }
}
