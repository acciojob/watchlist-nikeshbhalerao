package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("movies")
@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
   ResponseEntity<String> addmovie(@RequestBody Movie movie){
     String response = movieService.addMovie(movie);
     return new ResponseEntity<String>(response, HttpStatus.CREATED);
}
    @PostMapping("/add-Director")
    ResponseEntity<String> adddirector(@RequestBody Director director){
        String response = movieService.addDirector(director);
        return new ResponseEntity<String>(response ,HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String>  addMovieDirector(@RequestParam("nameM") String nameM , @RequestParam("nameD") String nameD){
        String response = movieService.addMovieDirectorPair(nameM, nameD);
        return new ResponseEntity<String>(response , HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{nameM}")

    public ResponseEntity<String> getMovieByName(@PathVariable("nameM") String nameM ){
        Movie movie = movieService.getMovieByName(nameM);
        return new ResponseEntity<String>((MultiValueMap<String, String>) movie, HttpStatus.FOUND);
    }
    @GetMapping("/get-director-by-name/{nameD}")

    public ResponseEntity<String> getDirectorByName(@PathVariable("nameD") String nameD){
        Director director = movieService.getDirectorByName(nameD);
        return new ResponseEntity<String>((MultiValueMap<String, String>) director, HttpStatus.FOUND);
    }

    @GetMapping("/get-movies-by-director-name/{nameD}")
    public ResponseEntity<String> getMoviesByDirectorName(@PathVariable("nameD") String nameD){
        List<String> ml = new ArrayList<>();
        ml = movieService.getMoviesByDirectorName(nameD);
        return new ResponseEntity<String>((MultiValueMap<String, String>) ml,HttpStatus.FOUND);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies()
    {
        List<String> ml = new ArrayList<>();
        ml = movieService.findAllMovies();
        return new ResponseEntity(ml ,HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deletDirectorByName(@RequestParam("nameD")String nameD)
    {
        String response = movieService.deletDirectorByName(nameD);
        return new ResponseEntity<>(response , HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
      String response = movieService.deleteAllDirectors();
      return new ResponseEntity<>(response , HttpStatus.ACCEPTED);
    }

}
