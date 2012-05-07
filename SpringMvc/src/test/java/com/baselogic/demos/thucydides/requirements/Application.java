package com.baselogic.demos.thucydides.requirements;

import net.thucydides.core.annotations.Feature;

/**
 * Groups together the features desired for the application.
 *
 * @author warlock
 */
@SuppressWarnings("PMD.AtLeastOneConstructor")
public class Application {

    /**
     * Movie Search is the main feature of our application.
     */
    @Feature
    public class MovieSearch {

        /**
         * Title search.
         */
        public class SearchForTitles {

        }
    }
}
