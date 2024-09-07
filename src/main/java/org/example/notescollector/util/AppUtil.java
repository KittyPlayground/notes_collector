package org.example.notescollector.util;

import java.util.UUID;

public class AppUtil {
    public static String generateNoteId() {
        return "NOTE-" + UUID.randomUUID();
    }
}
