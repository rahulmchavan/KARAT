package com.practice.chatgpt02;
class Book {

    String title;
    int pages;

    Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Book))
            return false;

        Book b = (Book) o;

        return title == b.title &&
               pages == b.pages;
    }

    @Override
    public int hashCode() {

        return title.hashCode() * pages;
    }
}