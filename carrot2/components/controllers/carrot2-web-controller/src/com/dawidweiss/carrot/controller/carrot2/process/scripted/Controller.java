

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


package com.dawidweiss.carrot.controller.carrot2.process.scripted;


import java.io.IOException;
import java.io.InputStream;
import java.util.Map;


/**
 * A Controller object gives scripts access to components. And applies components to an InputStream
 * flow of data.
 */
public interface Controller
{
    /**
     * If set to true, allow the Controller to use cached input component's response for the
     * combination of (query, optionalParams). If this combination matches any previously cached
     * data, this data will be returned immediately (and the input component will not be
     * re-queried).
     *
     * @param newValue True if the controller should use cache, false otherwise.
     */
    public void setUseCachedInput(boolean newValue);


    /**
     * @return true if the controller uses cache for input components.
     */
    public boolean getUseCachedInput();


    /**
     * If true, allows the controller to cache response to the input query for future use.
     */
    public void setDoCacheInput(boolean newValue);


    /**
     * Returns the current state doCacheInput property.
     */
    public boolean getDoCacheInput();


    /**
     * Invokes a named input component for a given query and no optional parameters. Returns an
     * InputStream with the result.
     */
    public InputStream invokeInputComponent(String componentId, Query query)
        throws IOException, ComponentFailureException;


    /**
     * Invokes a named input component for a given query and a map of optional parameters. Returns
     * an InputStream with the result. Input parameters is a map of name-value pairs. Each value
     * in the Map is converted to string using toString method.
     */
    public InputStream invokeInputComponent(String componentId, Query query, Map optionalParams)
        throws IOException, ComponentFailureException;


    public InputStream invokeFilterComponent(String componentId, InputStream data)
        throws IOException, ComponentFailureException;


    public InputStream invokeFilterComponent(
        String componentId, InputStream data, Map optionalParams
    )
        throws IOException, ComponentFailureException;


    public InputStream invokeOutputComponent(String componentId, InputStream data)
        throws IOException, ComponentFailureException;


    public InputStream invokeOutputComponent(
        String componentId, InputStream data, Map optionalParams
    )
        throws IOException, ComponentFailureException;


    /**
     * Finishes processing for this controller (sends whatever data remains in InputStream to the
     * user).
     */
    public void sendResponse(InputStream data)
        throws IOException;
}
