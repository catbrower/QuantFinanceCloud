package com.brower.quantfinance.data;

import org.ta4j.core.Bar;
import org.ta4j.core.BaseBar;
import org.ta4j.core.num.DecimalNum;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class PolygonBar {
    private double o;
    private double h;
    private double l;
    private double c;
    private int v;
    private double vw;
    private double a;
    private long t;
    private int n;

    public double getO() {
        return o;
    }

    public void setO(double o) {
        this.o = o;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getL() {
        return l;
    }

    public void setL(double l) {
        this.l = l;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public double getVw() {
        return vw;
    }

    public void setVw(double vw) {
        this.vw = vw;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public long getT() {
        return t;
    }

    public void setT(long t) {
        this.t = t;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Bar toBar() {
        return BaseBar.builder(DecimalNum::valueOf, Number.class)
                .timePeriod(Duration.ofMinutes(1))
                .endTime(ZonedDateTime.ofInstant(Instant.ofEpochMilli(this.t), ZoneId.systemDefault()))
                .openPrice(this.o)
                .highPrice(this.h)
                .lowPrice(this.l)
                .closePrice(this.c)
                .volume(this.v)
                .build();
    }
}
