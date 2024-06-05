package com.diting.ai.enums;

public enum ChatToolFunctionType {

    OBJECT("object"),
    ;

    private final String value;

    private ChatToolFunctionType(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

}
