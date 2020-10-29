package com.amannirala13.moviebooking.helpers;

import com.amannirala13.moviebooking.models.Movie;
import com.amannirala13.moviebooking.models.Slot;
import com.amannirala13.moviebooking.models.User;
import java.util.ArrayList;

/**
 *
 * @author amann
 */
public class Cache {
    
    public static User currentUser = null;
    public static ArrayList<Movie> movieList = new ArrayList<Movie>();
    public static ArrayList<Slot>  slotList = new ArrayList<Slot>();
}
