package com.example.lab12.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private double leftBorder;
    private double rightBorder;
    private double step;
    private int stepNumb;
    private double maxValue;
    private double xForMax;
    private int indexOfMax;
    private double minValue;
    private double xForMin;
    private int indexOfMin;
    private double summ;
    private double average;
}
