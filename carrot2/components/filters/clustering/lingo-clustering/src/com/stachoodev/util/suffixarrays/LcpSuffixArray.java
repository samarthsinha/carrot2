

/*
 * Carrot2 Project
 * Copyright (C) 2002-2003, Dawid Weiss
 * Portions (C) Contributors listen in carrot2.CONTRIBUTORS file.
 * All rights reserved.
 * 
 * Refer to full text of the licence "carrot2.LICENCE" in the root folder
 * of CVS checkout or at: 
 * http://www.cs.put.poznan.pl/dweiss/carrot2.LICENCE
 */


package com.stachoodev.util.suffixarrays;



/**
 *
 */
public class LcpSuffixArray
    extends SuffixArray
{
    /** */
    protected int [] lcpArray;

    /**
     *
     */
    LcpSuffixArray(int [] suffixArray, int [] lcpArray)
    {
        super(suffixArray);

        this.lcpArray = lcpArray;
    }

    /**
     *
     */
    public int [] getLcpArray()
    {
        return lcpArray;
    }
}
