
/*
 * Carrot2 project.
 *
 * Copyright (C) 2002-2013, Dawid Weiss, Stanisław Osiński.
 * All rights reserved.
 *
 * Refer to the full license file "carrot2.LICENSE"
 * in the root folder of the repository checkout or at:
 * http://www.carrot2.org/carrot2.LICENSE
 */

package org.carrot2.examples.source;

import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.util.Version;
import org.carrot2.core.Controller;
import org.carrot2.core.ControllerFactory;
import org.carrot2.core.IClusteringAlgorithm;
import org.carrot2.core.IDocumentSource;
import org.carrot2.core.ProcessingResult;
import org.carrot2.examples.ConsoleFormatter;
import org.carrot2.examples.SampleDocumentData;

/**
 * This example shows how to write and use custom components: {@link IDocumentSource} and
 * {@link IClusteringAlgorithm}.
 */
public class ExampleCustomComponents
{
    @SuppressWarnings("deprecation")
    public static void main(String [] args)
    {
        /*
         * Create a pooling controller (reuses components).
         */
        final Controller controller = ControllerFactory.createPooling();
        try {
            final Map<String, Object> params = new HashMap<String, Object>();
    
            /*
             * Add attributes relevant to the source and algorithm we will be
             * using. Note the builder classes are generated by annotation
             * processor (which must be in the compiler's classpath!).
             */
            /*
             * An alternative strategy is to put relevant attribute keys in the 
             * map directly but it can be tedious.
             */
            ModuloDocumentSourceDescriptor.attributeBuilder(params)
                .query("dummy")
                .results(10)
                .documents(SampleDocumentData.DOCUMENTS_DATA_MINING)
                .modulo(2)
                .analyzer(new WhitespaceAnalyzer(Version.LUCENE_CURRENT));

            ByFirstTitleLetterClusteringAlgorithmDescriptor.attributeBuilder(params)
                .caseSensitive(false);

            /*
             * Invoke processing on the controller and display the result. 
             */
            final ProcessingResult result = controller.process(params,
                ModuloDocumentSource.class, 
                ByFirstTitleLetterClusteringAlgorithm.class);

            ConsoleFormatter.displayResults(result);
        } finally {
            controller.dispose();
        }
    }
}
