package com.bootcamp.be_java_hisp_w20_g2_idalgo.utils.sort;

import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.UserDTO;

import java.util.Comparator;
import java.util.HashMap;

public class UserDTOStreamSorter {
    private static final HashMap<String, Comparator<UserDTO>> sortCriterias = new HashMap<>();
    private static final Comparator<UserDTO> defaultCriteria = (p1, p2) -> 0;

    static {
        sortCriterias.put("name_asc", Comparator.comparing(UserDTO::getUserName));
        sortCriterias.put("name_desc", Comparator.comparing(UserDTO::getUserName).reversed());
    }

    public static Comparator<UserDTO> getSortCriteria(String criteriaString) {
        return sortCriterias.getOrDefault(criteriaString, defaultCriteria);
    }

    public static boolean isValid(String sortCriteria) {
        return sortCriterias.containsKey(sortCriteria);
    }
}
