package com.example.BookSystem;

public class BookMessage {
    private Integer BookID;
    private String BookName;
    private String WriterName;
    private String Publisher;
    private double Price;
    private Integer Number;
    public BookMessage(){
        super();
    }

    public BookMessage(Integer bookID, String bookName, String writerName, String publisher, double price, Integer number) {
        BookID = bookID;
        BookName = bookName;
        WriterName = writerName;
        Publisher = publisher;
        Price = price;
        Number = number;
    }

    public Integer getBookID() {
        return BookID;
    }

    public void setBookID(Integer bookID) {
        BookID = bookID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getWriterName() {
        return WriterName;
    }

    public void setWriterName(String writerName) {
        WriterName = writerName;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public Integer getNumber() {
        return Number;
    }

    public void setNumber(Integer number) {
        Number = number;
    }
}
