package com.qisibajie.katas.bdd.cucumber;

public class WillLogger {
    public static final int LEVEL_OFF = 0;
    public static final int LEVEL_ON = 1;
    private final int level;

    public WillLogger(int level) {
        this.level = level;
    }

    public static WillLogger getLogger(int level) {
        return new WillLogger(level);
    }

    public void info(String log) {
        if (this.level == LEVEL_ON) {
            System.out.println("===" + log);
        }
    }
}
