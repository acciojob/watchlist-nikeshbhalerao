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
   ResponseEntity addmovie(@RequestBody Movie movie){
     String response = movieService.addMovie(movie);
     return new ResponseEntity<>(response, HttpStatus.CREATED);
}
    @PostMapping("/add-Director")
    ResponseEntity adddirector(@RequestBody Director director){
        String response = movieService.addDirector(director);
        return new ResponseEntity<>(response ,HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity  addMovieDirector(@RequestParam("nameM") String nameM , @RequestParam("nameD") String nameD){
        String response = movieService.addMovieDirectorPair(nameM, nameD);
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{nameM}")

    public ResponseEntity getMovieByName(@PathVariable("nameM") String nameM ){
        Movie response = movieService.getMovieByName(nameM);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
    @GetMapping("/get-director-by-name/{nameD}")

    public ResponseEntity getDirectorByName(@PathVariable("nameD") String nameD){
        Director response = movieService.getDirectorByName(nameD);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @GetMapping("/get-movies-by-director-name/{nameD}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("nameD") String nameD){
        List<String> response = new ArrayList<>();
        response = movieService.getMoviesByDirectorName(nameD);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies()
    {
        List<String> ml = new ArrayList<>();
        ml = movieService.findAllMovies();
        return new ResponseEntity<>(ml ,HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deletDirectorByName(@RequestParam("nameD")String nameD)
    {
        String response = movieService.deleteDirectorByName(nameD);
        return new ResponseEntity<>(response , HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors()
    {
      String response = movieService.deleteAllDirectors();
      return new ResponseEntity<>(response , HttpStatus.ACCEPTED);
    }

}
