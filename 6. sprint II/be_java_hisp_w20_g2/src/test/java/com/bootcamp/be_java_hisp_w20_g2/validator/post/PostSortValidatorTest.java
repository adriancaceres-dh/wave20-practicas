package com.bootcamp.be_java_hisp_w20_g2.validator.post;

import com.bootcamp.be_java_hisp_w20_g2.utils.validator.post.PostSortValidator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PostSortValidatorTest {

    private final PostSortValidator postSortValidator = new PostSortValidator();

    /**
     * Test only validates if postSortValidator works correctly since the
     * exception would be thrown at the controller, which should be tested
     * in an integration test :D
     */
    @Test
    void isValidReturnsTrueWhenValidDateOrdering() {
        assertTrue(postSortValidator.isValid(Optional.of("date_asc"), null));
        assertTrue(postSortValidator.isValid(Optional.of("date_desc"), null));
    }

    @Test
    void isValidReturnsTrueWhenValidPriceOrdering() {
        assertTrue(postSortValidator.isValid(Optional.of("price_asc"), null));
        assertTrue(postSortValidator.isValid(Optional.of("price_desc"), null));
    }

    @Test
    void isValidReturnsFalseWhenInvalidOrderCriteria() {
        assertFalse(postSortValidator.isValid(Optional.of("clearly_not_valid_criteria"), null));
    }

}