package org.carrot2.util.attribute.constraint;

import org.junit.Test;

/**
 * Test cases for {@link IntModulo} constraint.
 */
public class IntModuloConstraintTest extends ConstraintTestBase<IntModulo>
{
    static class AnnotationContainer
    {
        @IntModulo(modulo = 4, offset = 2)
        double field;
    }

    @Override
    Class<?> getAnnotationContainerClass()
    {
        return AnnotationContainer.class;
    }

    @Override
    Class<IntModulo> getAnnotationType()
    {
        return IntModulo.class;
    }

    @Test
    public void testNull() throws Exception
    {
        assertNotMet(null);
    }
    
    @Test
    public void testMet() throws Exception
    {
        assertMet(-6);
        assertMet(-2);
        assertMet(2);
        assertMet(6);
        assertMet(10);
    }
    
    @Test
    public void testNotMet() throws Exception
    {
        assertNotMet(-7);
        assertNotMet(-1);
        assertNotMet(3);
        assertNotMet(5);
        assertNotMet(12);
    }
}
