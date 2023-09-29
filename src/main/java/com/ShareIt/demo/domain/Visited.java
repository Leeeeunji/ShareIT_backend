package com.ShareIt.demo.domain;


public class Visited {
    private int count;
    private Visited(){
        count=0;
    }
    private static class HOLDER{
        public static final Visited INSTANCE = new Visited();
    }

    public static Visited getInstance(){
        return HOLDER.INSTANCE;
    }

    public void plus(){
        count++;
    }

    public int getCount(){
        return count;
    }

}
