package com.bootcamp.imprimirdocs;

public class Informs {
    int pages;
    String autor;
    String title;
    String revisorName;

    public Informs(int pages, String autor, String title, String revisorName) {
        this.pages = pages;
        this.autor = autor;
        this.title = title;
        this.revisorName = revisorName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRevisorName() {
        return revisorName;
    }

    public void setRevisorName(String revisorName) {
        this.revisorName = revisorName;
    }

    @Override
    public String toString() {
        return "Informs{" +
                "pages=" + pages +
                ", autor='" + autor + '\'' +
                ", title='" + title + '\'' +
                ", revisorName='" + revisorName + '\'' +
                '}';
    }
}
