package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){
        return movieRepository.addMovie(movie);
    }
    public String addDirector(Director director){
        return movieRepository.addDirector(director);
    }

    public String addMovieDirectorPair(String nameM,String nameD){
        return movieRepository.addMovieDeirector(nameM , nameD);
    }

    public Movie getMovieByName(String nameM) {
        return movieRepository.getMovieByName(nameM);
    }

    public Director getDirectorByName (String nameD ){
        return movieRepository.getDirectorByName(nameD);
    }

    public List<String> getMoviesByDirectorName(String nameD)
    {
        return movieRepository.getMovieByDirectorName(nameD);
    }

    public List<String> findAllMovies()
    {
        return movieRepository.findAllMovies();
    }

    public String deletDirectorByName(String nameD){
        return movieRepository.deletDirectorByName(nameD);
    }

    public String deleteAllDirectors(){
        return movieRepository.deletAllDirectors();
    }
}
