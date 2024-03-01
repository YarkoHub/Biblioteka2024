package repository;

import model.Book;
import util.MyLinkedList;

import java.util.Arrays;
import java.util.Comparator;

public class BookRepository {
    private final MyLinkedList<Book> books;

    public BookRepository(MyLinkedList<Book> books) {
        this.books = books;
    }

    public void add(Book newBook) {books.add(newBook);}

    public MyLinkedList<Book> findAll() {return books;}

    public MyLinkedList<Book> findReservedBooks(){
        MyLinkedList<Book> reservedBooks = new MyLinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isBookStatus())
            {
                reservedBooks.add(books.get(i));
            }
        }
        return reservedBooks;
    }
    public MyLinkedList<Book> findfreeBooks() {
        MyLinkedList<Book> freeBooks = new MyLinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            if (!books.get(i).isBookStatus())
            {
                freeBooks.add(books.get(i));
            }
        }
        return freeBooks;
    }

    public Book findById(Integer bookId){
        for (int i = 0; i < books.size(); i++) {
            Book currentBook = books.get(i);
            if (currentBook.getBookId().equals(bookId)) {
                return currentBook;
            }
        }
        return null;
    }

    public MyLinkedList<Book> findByTitle(String title) {
        String lowercaseTitle = title.toLowerCase();
        MyLinkedList<Book> booksFindAllByTitle = new MyLinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book currentBook = books.get(i);
            String lowercaseBookTitle = currentBook.getBookTitle().toLowerCase();
            if (lowercaseBookTitle.contains(lowercaseTitle)) {
                booksFindAllByTitle.add(currentBook);
            }
        }

        return booksFindAllByTitle;
    }

    public MyLinkedList<Book> findByAuthor(String author) {
        String lowercaseTitle = author.toLowerCase();
        MyLinkedList<Book> booksFindAllByAuthor = new MyLinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book currentBook = books.get(i);
            String lowercaseAuthorTitle = currentBook.getBookAuthor().toLowerCase();
            if (lowercaseAuthorTitle.contains(lowercaseTitle)) {
                booksFindAllByAuthor.add(currentBook);
            }
        }

        return booksFindAllByAuthor;
    }



    public MyLinkedList<Book> sortBooksByTitle (){
        MyLinkedList<Book> sorterBooks = findAll();
        MyLinkedList<Book> sortedBooks = new MyLinkedList<>();
        String[] booksArray = new String[sorterBooks.size()];
        if (!sorterBooks.isEmpty() && sorterBooks.size()!=0) {
            for (int i = 0; i < sorterBooks.size(); i++) {
                booksArray[i] = sorterBooks.get(i).getBookTitle();
            }
            Arrays.sort(booksArray, Comparator.naturalOrder());

            for (int i = 0; i < booksArray.length; i++) {
                String bookTitle = booksArray[i];
                for (int j = 0; j < sorterBooks.size(); j++) {
                    Book book = sorterBooks.get(j);
                    if (book.getBookTitle().equals(bookTitle)) {
                        sortedBooks.add(book);
                        break;
                    }
                }
            }
            return sortedBooks;
        }
        else {
            System.out.println("Чет не то");
            return null;
        }
    }
    public MyLinkedList<Book> sortBooksByAuthor (){
        MyLinkedList<Book> sorterBooks = findAll();
        MyLinkedList<Book> sortedBooks = new MyLinkedList<>();
        String[] booksArray = new String[sorterBooks.size()];
        Book[] bookArray1 = sorterBooks.toArray();
        Arrays.sort(bookArray1, Comparator.comparing(Book::getBookAuthor));
        System.out.println(Arrays.toString(bookArray1));
       /* if (!sorterBooks.isEmpty() && sorterBooks.size()!=0) {
            for (int i = 0; i < sorterBooks.size(); i++) {
                booksArray[i] = sorterBooks.get(i).getBookAuthor();
            }
            Arrays.sort(booksArray, Comparator.naturalOrder());

            for (int i = 0; i < booksArray.length; i++) {
                String bookAuthor = booksArray[i];
                for (int j = 0; j < sorterBooks.size(); j++) {
                    Book book = sorterBooks.get(j);
                    if (book.getBookAuthor().equals(bookAuthor)) {
                        sortedBooks.add(book);
                        break;
                    }
                }
            }
            return sortedBooks;
        }
        else {
            System.out.println("Чет не то");
            return null;
        }*/
        //TODO ПЕРЕДЕЛАТЬ!!!!
        return null;
    }

}
