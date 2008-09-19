package org.carrot2.util.attribute.constraint;

import java.lang.annotation.*;


/**
 * Requires that the integer attribute value is between {@link #min()} (inclusively) and
 * {@link #max()} (inclusively).
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@IsConstraint(implementation = IntRangeConstraint.class)
public @interface IntRange
{
    /**
     * Minimum value for the attribute, inclusive.
     */
    int min() default Integer.MIN_VALUE;

    /**
     * Maximum value for the attribute, inclusive.
     */
    int max() default Integer.MAX_VALUE;
}
