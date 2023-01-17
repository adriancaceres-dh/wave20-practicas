package com.bootcamp.be_java_hisp_w20_g2.utils.sort;


import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserResponseDTO;

import java.util.Comparator;
import java.util.HashMap;

public class UserResponseDTOStreamSorter {
    private static final HashMap<String, Comparator<UserResponseDTO>> sortCriterias = new HashMap<>();
    private static final Comparator<UserResponseDTO> defaultCriteria = (p1, p2) -> 0;

    static {
        sortCriterias.put("name_asc", Comparator.comparing(UserResponseDTO::getUserName));
        sortCriterias.put("name_desc", Comparator.comparing(UserResponseDTO::getUserName).reversed());
    }

    public static Comparator<UserResponseDTO> getSortCriteria(String criteriaString) {
        return sortCriterias.getOrDefault(criteriaString, defaultCriteria);
    }

    public static boolean isValid(String sortCriteria) {
        return sortCriterias.containsKey(sortCriteria);
    }
}
