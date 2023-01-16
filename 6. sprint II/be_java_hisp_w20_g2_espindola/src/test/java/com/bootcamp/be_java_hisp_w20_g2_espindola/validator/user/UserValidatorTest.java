package com.bootcamp.be_java_hisp_w20_g2_espindola.validator.user;

import com.bootcamp.be_java_hisp_w20_g2_espindola.utils.validator.userResponse.UserResponseSortValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserValidatorTest {

    UserResponseSortValidator userValidator = new UserResponseSortValidator();
    @Test
    @DisplayName("T-0003 Validates as true when the sorting is working.")
    void isValidReturnsTrueWhenValidAlphabeticOrdering() {
        assertTrue(userValidator.isValid(Optional.of("name_asc"), null));
        assertTrue(userValidator.isValid(Optional.of("name_desc"), null));
    }

    @Test
    @DisplayName("T-0003 Validates as false when the sorting is not working.")
    void isValidReturnsFalseWhenInvalidOrderCriteria() {
        assertFalse(userValidator.isValid(Optional.of("clearly_not_valid_criteria"), null));
    }
}
