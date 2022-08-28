package com.youtube_robedwards.linkedlist;

public class EmptyListException extends Exception{
    public EmptyListException(){
        super();
    }
    public EmptyListException(String s){
        super(s);
    }
}
