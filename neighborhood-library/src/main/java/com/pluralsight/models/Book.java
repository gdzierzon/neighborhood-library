package com.pluralsight.models;

public class Book
{
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title)
    {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public boolean isCheckedOut()
    {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut)
    {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo()
    {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo)
    {
        this.checkedOutTo = checkedOutTo;
    }

    // methods
    public boolean checkOut(String name)
    {
        // book is already checked out
        // return false to state that we can't check it out
        if(isCheckedOut) return false;

        // the book is not checked out
        // check it out to the name and return true
        isCheckedOut = true;
        checkedOutTo = name;
        return true;
    }

    public void checkIn()
    {
        checkedOutTo = "";
        isCheckedOut = false;
    }
}
