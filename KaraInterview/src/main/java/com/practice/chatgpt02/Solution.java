package com.practice.chatgpt02;
public class Solution {

    public static void main(
            String[] args) {
    	 boolean enabled = false;
    	    assert enabled = true;

    	    System.out.println("Assertions enabled = " + enabled);

        testReadingCollection();
    }

    static ReadingCollection createCollection(
            Book book,
            int[] data) {

        ReadingCollection collection =
                new ReadingCollection(book);

        for (int pages : data) {

            collection.addSession(
                    new ReadingSession(
                            book,
                            pages));
        }

        return collection;
    }

    static void testReadingCollection() {

        Book book =
                new Book(
                        "Java",
                        500);

        int[] data = {
                50,
                100,
                75,
                120
        };

        ReadingCollection collection =
                createCollection(
                        book,
                        data);

        assert collection.totalPagesRead()
                == 345;

        assert collection
                .mostPagesReadBook()
                == 120;

        System.out.println(
                "Tests Passed");
    }
}