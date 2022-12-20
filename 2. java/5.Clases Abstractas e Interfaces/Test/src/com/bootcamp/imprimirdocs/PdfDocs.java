package com.bootcamp.imprimirdocs;

public class PdfDocs {
    int pages;
    String name;
    String title;
    String gender;

    public PdfDocs(int pages, String name, String title, String gender) {
        this.pages = pages;
        this.name = name;
        this.title = title;
        this.gender = gender;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "PdfDocs{" +
                "pages=" + pages +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
