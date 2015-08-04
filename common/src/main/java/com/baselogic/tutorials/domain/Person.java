package com.baselogic.tutorials.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Person {

    ESP,
    COMMERCIAL,
    TURNPIKE;

    private static final Logger logger = LoggerFactory.getLogger(Person.class);


    public static Person instance(String text) {
        if (text != null) {
            for (Person entry : Person.values()) {
                if (text.equalsIgnoreCase(entry.name())) {
                    return entry;
                }
            }
        }
        logger.warn("Invalid project: " + text);
        return null;
    }

}
