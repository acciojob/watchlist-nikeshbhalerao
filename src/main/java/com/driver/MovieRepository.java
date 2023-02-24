package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {


    HashMap<String , Movie> Mdb = new HashMap<>();
    HashMap<String , Director> Ddb = new HashMap<>();

    HashMap<String  , List<String>>Pdb = new HashMap<>();



    public String addMovie(Movie movie){
        String name = movie.getName();
        Mdb.put(name , movie);
        return "Movie Added Successfully";
    }

    public String addDirector(Director director){
        String name = director.getName();
        Ddb.put(name , director);
        return "Director added successfully";
    }

    public String addMovieDeirector(String nameM , String nameD ){
        if(!Mdb.containsKey(nameM) || !Ddb.containsKey(nameD)){
            return "Movie or Director not found in database";
        }
        List<String> ml = Pdb.getOrDefault(nameD , new ArrayList<>());
        if(ml.contains(nameM)) return "pair already exits";
        ml.add(nameM);
        Pdb.put(nameD,ml);
        return "Pair added successfully";
    }
    public Movie getMovieByName(String nameM)
    {
        if(Mdb.containsKey(nameM))
        {
            return Mdb.get(nameM);
        }
        return null ;
    }

    public Director getDirectorByName(String nameD){
        if(Ddb.containsKey(nameD)){
            return Ddb.get(nameD);
        }
        return null;
    }

    public List<String> getMovieByDirectorName( String nameD){
        if(Pdb.containsKey(nameD))
        {
            return Pdb.get(nameD);
        }
        return null;
    }

    public List<String> findAllMovies(){
        List<String> allmovie = new ArrayList<>();
        for(String m : Mdb.keySet()){
            allmovie.add(m);
        }
        return allmovie;

    }

    public String deletDirectorByName(String nameD){
        List<String>ml = new ArrayList<>();
        if(Pdb.containsKey(nameD)){
            ml = Pdb.get(nameD);
        }
        for(String Movie : ml){

            if(Mdb.containsKey(Movie))
            {
                Mdb.remove(Movie);
            }
        }
        Pdb.remove(nameD);
        if(Ddb.containsKey(nameD)){
            Ddb.remove(nameD);
        }
        return "Director and its movies removed successfully";
    }

    public String deletAllDirectors()
    {
        for(String D : Pdb.keySet())
        {
            List<String> dml = new ArrayList<>();
            dml = Pdb.get(D);
            for(String movie :dml)
            {
               if(Mdb.containsKey(movie))
               {
                   Mdb.remove(movie);
               }
            }
            Pdb.remove(D);
        }
        for(String D : Ddb.keySet())
        {
            Ddb.remove(D);
        }
        return "All directors and all of their movies removed successfully";
    }
}
