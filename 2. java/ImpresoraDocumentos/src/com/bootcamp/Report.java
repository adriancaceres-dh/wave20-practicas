package com.bootcamp;

public class Report implements ImpresoraInterface {
    private String text;
    private String author;
    private String reviewer;
    private int numberOfPages;

    public Report(String text, String author, String reviewer, int numberOfPages) {
        this.text = text;
        this.author = author;
        this.reviewer = reviewer;
        this.numberOfPages = numberOfPages;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public void print() {
        System.out.println("Report");
        System.out.println("Written by: " + author + " Reviewed by: " + reviewer);
        System.out.println(text);
        System.out.println("Pages: " + numberOfPages);
    }
}
