package com.devil.inventory.service.utils;

import java.util.UUID;

public class UUIDUtils {

    public static String generateId() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

}
