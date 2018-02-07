package com.company.Utility;

public class Pair<T>{
        T p1;
        T p2;
        
        public Pair(T p1, T p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
        
        public T getPairNumber1() {
            return p1;
        }
        
        public T getPairNumber2() {
            return p2;
        }
    
    @Override
    public String toString() {
        return "Row: " + p1 + "\r\nColumn: " + p2;
    }
    
    //Pair<Integer> pair = new Pair<Integer>(1,2);
}
