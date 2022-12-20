package com.bootcamp;

public class PdfBook implements ImpresoraInterface{
    private String title;
    private String author;
    private String genre;
    private int numberOfPages;

    public PdfBook(String title, String author, String genre, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public void print() {
        System.out.println("Book: " + title + " - " + genre + " pages: " + numberOfPages);
        System.out.println("Author: " + author);
    }
}
