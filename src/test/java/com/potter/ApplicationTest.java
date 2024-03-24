package com.potter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class ApplicationTest {
    double delta = 0.0001;
    double resultOutput;
    double expectedResult;
    double priceBook=8;
    double twoBooksDiscount=0.05;
    double threeBooksDiscount=0.1;
    double fourBooksDiscount=0.2;
    double fiveBooksDiscount=0.25;
    double priceTwoBooks= priceBook*2;
    double priceThreeBooks= priceBook*3;
    double priceFourBooks= priceBook*4;
    double priceFiveBooks= priceBook*5;
    double discount=0;;
    double priceWithDiscount=0;
    Book bookOne = new Book("First",8.0);
    Book bookTwo = new Book("Second",8.0);
    Book bookThree = new Book("Third",8.0);
    Book bookFour = new Book("Fourth",8.0);
    Book bookFive = new Book("Fifth",8.0);

    @Test
    public void emptyCart() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        resultOutput = Application.calculateCart(booksInTheCart);
        expectedResult = 0;
        assertEquals(resultOutput, expectedResult, delta);
    }

    @Test
    public void oneBookInTheCart() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        resultOutput = Application.calculateCart(booksInTheCart);
        expectedResult = priceBook;
        assertEquals(resultOutput, expectedResult, delta);
    }


    @Test
    public void checkBookRepeated() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookTwo);
        booksInTheCart.add(bookOne);
        Book bookExpected=bookOne;
        Book bookOutput = Application.bookRepeated(booksInTheCart);
        assertEquals(bookOutput, bookExpected);

    }

    @Test
    public void checkGetDiferentBooks() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookTwo);
        booksInTheCart.add(bookOne);
        ArrayList<Book> booksExpected = new ArrayList<>();
        booksExpected.add(bookOne);
        booksExpected.add(bookTwo);
        ArrayList<Book> booksOutput = Application.getDiferentBooks(booksInTheCart);
        assertEquals(booksOutput, booksExpected);
    }

    @Test
    public void checkCountForBook() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookTwo);
        booksInTheCart.add(bookOne);
        HashMap<Book, Integer> countedBooks = new HashMap<>();
        countedBooks.put(bookOne, 2);
        countedBooks.put(bookTwo, 1);
        HashMap<Book, Integer> resultOutput = countedBooks;
        HashMap<Book, Integer> expectedResult = Application.countForBook(booksInTheCart);
        assertEquals(resultOutput, expectedResult);
    }


    @Test
    public void twoEqualBooksInTheCart() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookOne);
        resultOutput = Application.calculateCart(booksInTheCart);
        expectedResult = priceTwoBooks;
        assertEquals(resultOutput, expectedResult, delta);
    }

    @Test
    public void twoDiferentBooksInTheCart() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookTwo);
        resultOutput = Application.calculateCart(booksInTheCart);
        discount= priceTwoBooks*twoBooksDiscount;
        priceWithDiscount=priceTwoBooks-discount;
        expectedResult = priceWithDiscount;
        assertEquals(resultOutput, expectedResult, delta);
    }

    @Test
    public void ThreeEqualBooksInTheCart() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookOne);
        resultOutput = Application.calculateCart(booksInTheCart);
        expectedResult = priceThreeBooks;
        assertEquals(resultOutput, expectedResult, delta);
    }

    @Test
    public void ThreeDiferentBooksInTheCart() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookTwo);
        booksInTheCart.add(bookThree);
        resultOutput = Application.calculateCart(booksInTheCart);
        discount= priceThreeBooks*threeBooksDiscount;
        priceWithDiscount=priceThreeBooks-discount;
        expectedResult = priceWithDiscount;
        assertEquals(resultOutput, expectedResult, delta);
    }

    @Test
    public void TwoDiferentBooksAndOneRepeatedInTheCart() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookTwo);
        booksInTheCart.add(bookOne);
        resultOutput = Application.calculateCart(booksInTheCart);
        discount= priceTwoBooks*twoBooksDiscount;
        priceWithDiscount=priceTwoBooks-discount;
        expectedResult = priceWithDiscount+priceBook;
        assertEquals(resultOutput, expectedResult, delta);
    }

    @Test
    public void FourEqualBooksInTheCart() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookOne);
        resultOutput = Application.calculateCart(booksInTheCart);
        expectedResult = priceFourBooks;
        assertEquals(resultOutput, expectedResult, delta);
    }

    @Test
    public void FourDiferentBooksInTheCart() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookTwo);
        booksInTheCart.add(bookThree);
        booksInTheCart.add(bookFour);
        resultOutput = Application.calculateCart(booksInTheCart);
        discount= priceFourBooks*fourBooksDiscount;
        priceWithDiscount=priceFourBooks-discount;
        expectedResult = priceWithDiscount;
        assertEquals(resultOutput, expectedResult, delta);
    }

    @Test
    public void ThreeDiferentBooksAndOneRepeatedInTheCart() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookTwo);
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookFour);
        resultOutput = Application.calculateCart(booksInTheCart);
        discount= priceThreeBooks*threeBooksDiscount;
        priceWithDiscount=priceThreeBooks-discount;
        expectedResult = priceWithDiscount+priceBook;
        assertEquals(resultOutput, expectedResult, delta);
    }

    @Test
    public void TwoDiferentBooksAndTwoRepeatedInTheCart() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookTwo);
        resultOutput = Application.calculateCart(booksInTheCart);
        discount= priceTwoBooks*twoBooksDiscount;
        priceWithDiscount=priceTwoBooks-discount;
        expectedResult = priceWithDiscount+priceTwoBooks;
        assertEquals(resultOutput, expectedResult, delta);
    }

    @Test
    public void TwoDiferentBooksAndTwoDiferentInTheCart() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookTwo);
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookTwo);
        resultOutput = Application.calculateCart(booksInTheCart);
        discount= priceTwoBooks*twoBooksDiscount;
        priceWithDiscount=priceTwoBooks-discount;
        expectedResult = priceWithDiscount+priceWithDiscount;
        assertEquals(resultOutput, expectedResult, delta);
    }

    @Test
    public void FiveEqualBooksInTheCart() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookOne);
        resultOutput = Application.calculateCart(booksInTheCart);
        expectedResult = priceFiveBooks;
        assertEquals(resultOutput, expectedResult, delta);
    }

    @Test
    public void FiveDiferentBooksInTheCart() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookTwo);
        booksInTheCart.add(bookThree);
        booksInTheCart.add(bookFour);
        booksInTheCart.add(bookFive);
        resultOutput = Application.calculateCart(booksInTheCart);
        discount= priceFiveBooks*fiveBooksDiscount;
        priceWithDiscount=priceFiveBooks-discount;
        expectedResult = priceWithDiscount;
        assertEquals(resultOutput, expectedResult, delta);
    }

    @Test
    public void TwoDiferentBooksAndThreeEqualInTheCart() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookTwo);
        resultOutput = Application.calculateCart(booksInTheCart);
        discount= priceTwoBooks*twoBooksDiscount;
        priceWithDiscount=priceTwoBooks-discount;
        expectedResult = priceWithDiscount+(priceBook*3);
        assertEquals(resultOutput, expectedResult, delta);
    }

    @Test
    public void TwoOfTwoDiferentBooksAndOneEqualInTheCart() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookTwo);
        booksInTheCart.add(bookTwo);
        resultOutput = Application.calculateCart(booksInTheCart);
        discount= priceTwoBooks*twoBooksDiscount;
        priceWithDiscount=priceTwoBooks-discount;
        expectedResult = priceWithDiscount+priceWithDiscount+priceBook;
        assertEquals(resultOutput, expectedResult, delta);
    }

    @Test
    public void FourDiferentBooksAndOneEqualInTheCart() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookTwo);
        booksInTheCart.add(bookThree);
        booksInTheCart.add(bookFour);
        booksInTheCart.add(bookFour);
        resultOutput = Application.calculateCart(booksInTheCart);
        discount= priceFourBooks*fourBooksDiscount;
        priceWithDiscount=priceFourBooks-discount;
        expectedResult = priceWithDiscount+priceBook;
        assertEquals(resultOutput, expectedResult, delta);
    }

    @Test
    public void ThreeDiferentBooksAndTwoDiferentInTheCart() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookThree);
        booksInTheCart.add(bookFour);
        booksInTheCart.add(bookFour);
        resultOutput = Application.calculateCart(booksInTheCart);
        discount= priceThreeBooks*threeBooksDiscount;
        priceWithDiscount=priceThreeBooks-discount;
        double discountTwo = priceTwoBooks*twoBooksDiscount;
        double priceWithDiscountTwo= priceTwoBooks-discountTwo;
        expectedResult = priceWithDiscount+priceWithDiscountTwo;
        assertEquals(resultOutput, expectedResult, delta);
    }

    @Test
    public void ThreeDiferentBooksAndTwoEqualInTheCart() {
        ArrayList<Book> booksInTheCart = new ArrayList<>();
        booksInTheCart.add(bookOne);
        booksInTheCart.add(bookTwo);
        booksInTheCart.add(bookThree);
        booksInTheCart.add(bookThree);
        booksInTheCart.add(bookThree);
        resultOutput = Application.calculateCart(booksInTheCart);
        discount= priceThreeBooks*threeBooksDiscount;
        priceWithDiscount=priceThreeBooks-discount;
        expectedResult = priceWithDiscount+(priceBook*2);
        assertEquals(resultOutput, expectedResult, delta);
    }











}
