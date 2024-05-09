package com.mundo.flink.java;

class ShareData {

    volatile int number = 0;

    public void setNumberTo100() {
        this.number = 100;
    }

}