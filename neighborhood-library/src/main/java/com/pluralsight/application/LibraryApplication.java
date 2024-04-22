package com.pluralsight.application;

import com.pluralsight.models.Book;
import com.pluralsight.ui.UserInterface;

public class LibraryApplication
{
    private Book[] books= {
            new Book(1, "ISBN9780301", "The Great Gatsby"),
            new Book(2, "ISBN9780302", "War and Peace"),
            new Book(3, "ISBN9780303", "1984"),
            new Book(4, "ISBN9780304", "The Catcher in the Rye"),
            new Book(5, "ISBN9780305", "To Kill a Mockingbird"),
            new Book(6, "ISBN9780306", "Moby Dick"),
            new Book(7, "ISBN9780307", "The Lord of the Rings"),
            new Book(8, "ISBN9780308", "Pride and Prejudice"),
            new Book(9, "ISBN9780309", "The Grapes of Wrath"),
            new Book(10, "ISBN9780310", "The Chronicles of Narnia"),
            new Book(11, "ISBN9780311", "Ulysses"),
            new Book(12, "ISBN9780312", "The Odyssey"),
            new Book(13, "ISBN9780313", "Hamlet"),
            new Book(14, "ISBN9780314", "The Divine Comedy"),
            new Book(15, "ISBN9780315", "Alice's Adventures in Wonderland"),
            new Book(16, "ISBN9780316", "The Hobbit"),
            new Book(17, "ISBN9780317", "Don Quixote"),
            new Book(18, "ISBN9780318", "Animal Farm"),
            new Book(19, "ISBN9780319", "Brave New World"),
            new Book(20, "ISBN9780320", "The Iliad")
    };

    private UserInterface ui = new UserInterface();

    public void run()
    {
        ui.displayMessage("Welcome to the Neighborhood Library");

        while(true)
        {
            int choice = ui.promptHomeScreenSelection();

            switch(choice)
            {
                case 1: // available books
                    showAvailableBooks();
                    break;
                case 2: // checked out books
                    showCheckedOutBooks();
                    break;
                case 3: // exit
                    ui.displayMessage("Thank You! Come again.");
                    return;
                default: // invalid selection
                    ui.displayMessage("That was an invalid selection.");
                    break;
            }

        }
    }

    private void showAvailableBooks()
    {
        ui.displayAvailableBooks(books);
        int bookId = ui.promptAvailableBookCheckout();
        if(bookId > 0)
        {
            for(Book book : books)
            {
                if(book.getId() == bookId)
                {
                    String name = ui.promptForName();
                    book.checkOut(name);
                    ui.displayMessage(book.getTitle() + " has been checked out to " + name);
                    return;
                }
            }
            ui.displayMessage("The selected book id was not found.");
        }
    }

    private void showCheckedOutBooks()
    {
        ui.displayCheckedOutBooks(books);
        int bookId = ui.promptBookCheckin();
        if(bookId > 0)
        {
            for(Book book : books)
            {
                if(book.getId() == bookId)
                {
                    book.checkIn();
                    return;
                }
            }
            ui.displayMessage("The selected book id was not found.");
        }
    }
}
