package com.parse.service.util;

import java.util.*;

public class GenericUtil {

    public static boolean isNotEmptyList(List<?> list) {

        return Objects.nonNull(list) && !list.isEmpty();
    }

    public static boolean isObjectEmpty(Object object) {

        if (object == null) return true;

        else if (object instanceof String obj) return  (obj.trim().length() == 0);

         else if (object instanceof Collection<?> obj) return isCollectionEmpty(obj);

        return false;
    }

    private static boolean isCollectionEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());

    }
}
