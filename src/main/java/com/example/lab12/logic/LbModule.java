package com.example.lab12.logic;

import lombok.Data;
@Data
public class LbModule {
    private final double delta = 0.000001;

    public double leftBorder;
    public double rightBorder;
    public double step;
    private double[] x;
    private double[] y;

    public double getX(int index){return x[index];};
    public double getY(int index){return y[index];};
    public void setX(double value, int index){x[index]=value;};
    public void setY(double value, int index){y[index]=value;};

    public int iterateNumb() {
        int iterateNumb=1;
        double current;
        current = leftBorder;
        for(; current + step <= rightBorder+delta; current += step, iterateNumb++);
        return iterateNumb;
    }

    public double computeFunction(double x){
        double a = 2.3;
        double y;
        if(x<=0.3+delta){
            y=1.5*a*Math.pow(Math.cos(x),2);
        } else if (x>2.3-delta) {
            y=3*a*Math.tan(x);
        }else{
            y=Math.pow((x-2),2)+6*a;
        }
        return y;
    }

    public void createArrays(){
        int arrSize = iterateNumb();
        x = new double[arrSize];
        y = new double[arrSize];
        for(int i=0; i<arrSize; i++){
            x[i]=leftBorder+step*i;
            y[i]=computeFunction(x[i]);
        }
    }

    public int findIndexOfMaxY(){
        int index=0;
        for(int i=0; i<x.length; i++){
            if(y[i]>y[index]){
                index=i;
            }
        }
        return index;
    }
    public int findIndexOfMinY(){
        int index=0;
        for(int i=0; i<x.length; i++){
            if(y[i]<y[index]){
                index=i;
            }
        }
        return index;
    }

    public double summY(){
        double summ=0;
        for(int i=0; i<x.length; i++){
            summ+=y[i];
        }
        return summ;
    }

    public double middleY(){
        return summY()/y.length;
    }
}