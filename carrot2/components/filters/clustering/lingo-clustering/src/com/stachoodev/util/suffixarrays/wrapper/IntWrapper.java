

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


package com.stachoodev.util.suffixarrays.wrapper;



/**
 *
 */
public interface IntWrapper
{
    /**
     *
     */
    public int [] asIntArray();


    /**
     *
     */
    public int length();


    /**
     *
     */
    public void reverse();


    /**
     * Method getStringRepresentation.
     *
     * @param substring
     *
     * @return String
     */
    public String getStringRepresentation(Substring substring);
}
