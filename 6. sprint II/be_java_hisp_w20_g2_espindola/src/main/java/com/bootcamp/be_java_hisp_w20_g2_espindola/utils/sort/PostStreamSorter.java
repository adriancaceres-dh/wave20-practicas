package com.bootcamp.be_java_hisp_w20_g2_espindola.utils.sort;


import com.bootcamp.be_java_hisp_w20_g2_espindola.model.Post;

import java.util.Comparator;
import java.util.HashMap;

public class PostStreamSorter {
    private static final HashMap<String, Comparator<Post>> sortCriterias = new HashMap<>();
    private static final Comparator<Post> defaultCriteria = Comparator.comparing(Post::getDate).reversed();

    static {
        sortCriterias.put("date_asc", Comparator.comparing(Post::getDate));
        sortCriterias.put("date_desc", defaultCriteria);
        sortCriterias.put("price_asc", Comparator.comparing(Post::getPrice));
        sortCriterias.put("price_desc", Comparator.comparing(Post::getPrice).reversed());
    }

    public static Comparator<Post> getSortCriteria(String criteriaString) {
        return sortCriterias.getOrDefault(criteriaString, defaultCriteria);
    }

    public static boolean isValid(String sortCriteria) {
        return sortCriterias.containsKey(sortCriteria);
    }
}
