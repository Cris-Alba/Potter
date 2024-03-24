package com.potter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(new Book("First", 8.0));
        booksInTheCart.add(new Book("First", 8.0));
        booksInTheCart.add(new Book("Second", 8.0));
        booksInTheCart.add(new Book("Third", 8.0));
        booksInTheCart.add(new Book("Third", 8.0));

        calculateCart(booksInTheCart);
        //countForBook(booksInTheCart);

    }

    public static double calculateCart(ArrayList<Book> booksInTheCart) {
        double priceCart = 0;
        double twoBooksDiscount = 0.05;
        double threeBooksDiscount = 0.1;
        double fourBooksDiscount = 0.2;
        double fiveBooksDiscount = 0.25;
        double discount = 0;
        double priceWithDiscount = 0;
        Book bookRepeated;
        double priceBookRepeated = 0;
        double priceBooksDiferent = 0;

        if (booksInTheCart.isEmpty()) {
            priceCart = 0;
        }

        if (booksInTheCart.size() == 1) {
            double priceBook = booksInTheCart.get(0).getPrice();
            priceCart = priceBook;
        }

        if (booksInTheCart.size() == 2) {
            double priceTwoBooks = 0;
            for (Book book : booksInTheCart) {
                priceTwoBooks += book.getPrice();
            }
            if (getDiferentBooks(booksInTheCart).size() == 2) {
                discount = priceTwoBooks * twoBooksDiscount;
                priceWithDiscount = priceTwoBooks - discount;
                priceCart = priceWithDiscount;

            } else {
                priceCart = priceTwoBooks;

            }

        }

        if (booksInTheCart.size() == 3) {
            double priceThreeBooks = 0;
            for (Book book : booksInTheCart) {
                priceThreeBooks += book.getPrice();
            }

            switch (getDiferentBooks(booksInTheCart).size()) {
                case 3:
                    discount = priceThreeBooks * threeBooksDiscount;
                    priceWithDiscount = priceThreeBooks - discount;
                    priceCart = priceWithDiscount;
                    break;
                case 2:
                    bookRepeated = bookRepeated(booksInTheCart);
                    priceBookRepeated = bookRepeated.getPrice();
                    priceBooksDiferent = priceThreeBooks - priceBookRepeated;
                    discount = priceBooksDiferent * twoBooksDiscount;
                    priceWithDiscount = priceBooksDiferent - discount;
                    priceCart = priceWithDiscount + priceBookRepeated;
                    break;
                case 1:
                    priceCart = priceThreeBooks;
                    break;
            }

          
        }

        if (booksInTheCart.size() == 4) {
            double priceFourBooks = 0;
            for (Book book : booksInTheCart) {
                priceFourBooks += book.getPrice();
            }
            ArrayList<Book> diferentBooks = getDiferentBooks(booksInTheCart);
            switch (getDiferentBooks(booksInTheCart).size()) {
                case 4:
                    discount = priceFourBooks * fourBooksDiscount;
                    priceWithDiscount = priceFourBooks - discount;
                    priceCart = priceWithDiscount;
                    break;
                case 3:
                    bookRepeated = bookRepeated(booksInTheCart);
                    priceBookRepeated = bookRepeated.getPrice();
                    priceBooksDiferent = priceFourBooks - priceBookRepeated;
                    discount = priceBooksDiferent * threeBooksDiscount;
                    priceWithDiscount = priceBooksDiferent - discount;
                    priceCart = priceWithDiscount + priceBookRepeated;
                    break;
                case 2:
                    Book bookDiferentOne = diferentBooks.get(0);
                    Book bookDiferentTwo = diferentBooks.get(1);
                    HashMap<Book, Integer> numForBook =countForBook(booksInTheCart);
                    int repeadBookDiferentOne = numForBook.get(bookDiferentOne);
                    int repeadBookDiferentTwo = numForBook.get(bookDiferentTwo);
                    double priceGroupOfTwoBooks = bookDiferentOne.getPrice()+bookDiferentTwo.getPrice();
                    discount = priceGroupOfTwoBooks * twoBooksDiscount;
                    priceWithDiscount = priceGroupOfTwoBooks - discount;

                    if(repeadBookDiferentOne == 2 && repeadBookDiferentTwo ==2){
                        priceCart = priceWithDiscount + priceWithDiscount;

                    }else{
                        Book threeRepeatedBook=bookRepeated(booksInTheCart);
                        double priceTwoRepeatedBook= (threeRepeatedBook.getPrice())*2;
                        priceCart =priceWithDiscount + priceTwoRepeatedBook;
                    }
                    break;
                case 1:
                    priceCart = priceFourBooks;
                    break;
            }
        }
            


        if (booksInTheCart.size() == 5) {
            double priceFiveBooks = 0;
            for (Book book : booksInTheCart) {
                priceFiveBooks += book.getPrice();
            }
            ArrayList<Book> diferentBooks = getDiferentBooks(booksInTheCart);
            switch (getDiferentBooks(booksInTheCart).size()) {
                case 5:
                discount = priceFiveBooks * fiveBooksDiscount;
                priceWithDiscount = priceFiveBooks - discount;
                priceCart = priceWithDiscount;
                    break;
                case 4:
                    bookRepeated = bookRepeated(booksInTheCart);
                    priceBookRepeated = bookRepeated.getPrice();
                    priceBooksDiferent = priceFiveBooks - priceBookRepeated;
                    discount = priceBooksDiferent * fourBooksDiscount;
                    priceWithDiscount = priceBooksDiferent - discount;
                    priceCart = priceWithDiscount + priceBookRepeated;
                    break;
                case 3:
                    Book bookDiferentOne = diferentBooks.get(0);
                    Book bookDiferentTwo = diferentBooks.get(1);
                    Book bookDiferentThree = diferentBooks.get(2);

                    double priceGroupOfThreeBooks = bookDiferentOne.getPrice()+bookDiferentTwo.getPrice()+bookDiferentThree.getPrice();
                    discount = priceGroupOfThreeBooks * threeBooksDiscount;
                    double priceWithDiscountFirstGroup = priceGroupOfThreeBooks - discount;

                    HashMap<Book, Integer> numberOfBooks =countForBook(booksInTheCart);
                    ArrayList<Book> secondGroupOfBooks=new ArrayList<>();
                    for(Map.Entry<Book,Integer> entry: numberOfBooks.entrySet()){
                        if (entry.getValue()>1) {
                            secondGroupOfBooks.add(entry.getKey());
                        }
                    }
                    double priceSecondGroupOfBooks=0;

                    if (secondGroupOfBooks.size()==1) {
                        //Los dos libros son repetidos entre ellos y valen 8
                        double priceRepeatedBooks= (secondGroupOfBooks.get(0).getPrice())*2;
                        priceSecondGroupOfBooks = priceRepeatedBooks;
                        priceCart =priceWithDiscountFirstGroup + priceSecondGroupOfBooks;
                        
                    }else{
                        //Los dos libros son diferentes entre ellos y se les aplica dto de 2 libros
                        priceSecondGroupOfBooks = secondGroupOfBooks.get(0).getPrice()+secondGroupOfBooks.get(1).getPrice();
                        discount = priceSecondGroupOfBooks * twoBooksDiscount;
                        double priceWithDiscountSecondGroup = priceSecondGroupOfBooks -discount;
                        priceCart = priceWithDiscountFirstGroup + priceWithDiscountSecondGroup;
                    }
           
                    break;
                case 2:

                //FALTAN ESTAS OPCIONES:2 DE 2 DTO + 1 REPE Y 2DTO + 3 REPES
              
                    break;
                case 1:
                    priceCart = priceFiveBooks;
                    break;
            }
        }

        return priceCart;

    }

    public static Book bookRepeated(ArrayList<Book> booksInTheCart) {
        HashSet<Book> booksSeen = new HashSet<>();
        Book bookRepeated = null;
        for (Book book : booksInTheCart) {
            if (booksSeen.contains(book)) {
                bookRepeated = book;
                break;

            } else {
                booksSeen.add(book);
            }
        }
        return bookRepeated;
    }

    public static ArrayList<Book> getDiferentBooks(ArrayList<Book> booksInTheCart) {
        HashSet<Book> uniqueBooks = new HashSet<>(booksInTheCart);
        ArrayList<Book> diferentBooks = new ArrayList<>(uniqueBooks);

        return diferentBooks;
    }

    public static HashMap<Book, Integer> countForBook(ArrayList<Book> booksInTheCart) {
        HashMap<Book, Integer> countedBooks = new HashMap<>();
        for (Book book : booksInTheCart) {
            if (countedBooks.containsKey(book)) {
                int currentValue = countedBooks.get(book);
                countedBooks.put(book, currentValue+1);
            } else {
                countedBooks.put(book, 1);
            }
        }
        return countedBooks;
    }

}
