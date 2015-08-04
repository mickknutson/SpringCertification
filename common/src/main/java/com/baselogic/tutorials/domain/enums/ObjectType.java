package com.baselogic.tutorials.domain.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ObjectType {

    BUILDING,
    ANTENNA,
    SPAN,
    EARTH;

    private static final Logger logger = LoggerFactory.getLogger(ObjectType.class);

    public static ObjectType instance(String text) {
        if (text != null) {
            for (ObjectType entry : ObjectType.values()) {
                if (text.equalsIgnoreCase(entry.name())) {
                    return entry;
                }
            }
        }
        logger.warn("Invalid ObjectType: " + text);
        return null;
    }

}
