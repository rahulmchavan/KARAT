package com.practice.chatgpt02;
import java.util.*;

class ReadingCollection {

    List<ReadingSession> sessions =
            new ArrayList<>();

    Book book;

    ReadingCollection(Book book) {

        this.book = book;
    }

    void addSession(
            ReadingSession session) {

        if (!session.book.equals(book)) {

            throw new IllegalArgumentException(
                    "Wrong Book");
        }

        sessions.add(session);
    }

    int totalPagesRead() {

        return sessions.stream()
                .mapToInt(
                    s -> s.pagesRead)
                .sum();
    }

    // TODO
    int mostPagesReadBook() {

        return 0;
    }
}