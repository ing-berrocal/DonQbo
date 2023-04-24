/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.example.graphqle.endpoint;

import com.restaurante.example.graphqle.model.Ally;
import com.restaurante.example.graphqle.model.Film;
import com.restaurante.example.graphqle.model.Hero;
import com.restaurante.example.graphqle.model.SearchResult;
import com.restaurante.example.graphqle.service.GalaxyService;
import io.vertx.core.cli.annotations.Description;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

/**
 *
 * @author DELL
 */
@GraphQLApi 
public class FilmResource {

    @Inject
    public GalaxyService service;

    @Query("allFilms") 
    @Description("Get all Films from a galaxy far far away") 
    public List<Film> getAllFilms() {
        return service.getAllFilms();
    }
    
    @Query
    @Description("Get a Films from a galaxy far far away")
    public Film getFilm(@Name("filmId") int id) {
        return service.getFilm(id);
    }
    
    public List<Hero> heroes(@Source Film film) { 
        return service.getHeroesByFilm(film);
    }
    
    @Query
    public List<Ally> allies() {
        return service.getAllAllies();
    }
    
    @Query
    @Description("Get all characters from a galaxy far far away")
    public List<com.restaurante.example.graphqle.model.Character> characters() {
        return service.getAllCharacters();
    }
    
    @Query    
    public List<SearchResult> search(String query) {
        return service.search(query);
    }
    
    @Mutation
    public Hero createHero(Hero hero){
        service.addHero(hero);
        return hero;
    }
    
    @Mutation
    public Hero deleteHero(int id){
        return service.deleteHero(id);
    }
}
