/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.restaurante.example.graphqle.service;

import com.restaurante.example.graphqle.model.Ally;
import com.restaurante.example.graphqle.model.Film;
import com.restaurante.example.graphqle.model.Hero;
import com.restaurante.example.graphqle.model.LightSaber;
import com.restaurante.example.graphqle.model.SearchResult;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

/**
 *
 * @author DELL
 */
@ApplicationScoped
@Default
public class GalaxyService implements Serializable{
    
    private List<Hero> heroes = new ArrayList<>();

    private List<Film> films = new ArrayList<>();
    
    private List<Ally> allies = new ArrayList<>();

    public GalaxyService() {

        Film aNewHope = new Film();
        aNewHope.title = "A New Hope";
        aNewHope.releaseDate = LocalDate.of(1977, Month.MAY, 25);
        aNewHope.episodeID = 4;
        aNewHope.director = "George Lucas";

        Film theEmpireStrikesBack = new Film();
        theEmpireStrikesBack.title = "The Empire Strikes Back";
        theEmpireStrikesBack.releaseDate = LocalDate.of(1980, Month.MAY, 21);
        theEmpireStrikesBack.episodeID = 5;
        theEmpireStrikesBack.director = "George Lucas";

        Film returnOfTheJedi = new Film();
        returnOfTheJedi.title = "Return Of The Jedi";
        returnOfTheJedi.releaseDate = LocalDate.of(1983, Month.MAY, 25);
        returnOfTheJedi.episodeID = 6;
        returnOfTheJedi.director = "George Lucas";

        films.add(aNewHope);
        films.add(theEmpireStrikesBack);
        films.add(returnOfTheJedi);

        Hero luke = new Hero();
        luke.name = "Luke";
        luke.surname = "Skywalker";
        luke.height = 1.7;
        luke.mass = 73;
        luke.lightSaber = LightSaber.GREEN;
        luke.darkSide = false;
        luke.episodeIds.addAll(Arrays.asList(4, 5, 6));

        Hero leia = new Hero();
        leia.name = "Leia";
        leia.surname = "Organa";
        leia.height = 1.5;
        leia.mass = 51;
        leia.darkSide = false;
        leia.episodeIds.addAll(Arrays.asList(4, 5, 6));


        Hero vader = new Hero();
        vader.name = "Darth";
        vader.surname = "Vader";
        vader.height = 1.9;
        vader.mass = 89;
        vader.darkSide = true;
        vader.lightSaber = LightSaber.RED;
        vader.episodeIds.addAll(Arrays.asList(4, 5, 6));

        heroes.add(luke);
        heroes.add(leia);
        heroes.add(vader);
        
        Ally jarjar = new Ally();
        jarjar.name = "Jar Jar";
        jarjar.surname = "Binks";
        allies.add(jarjar);

    }

    public List<Film> getAllFilms() {
        return films;
    }

    public Film getFilm(int id) {
        return films.get(id);
    }

    public List<Hero> getHeroesByFilm(Film film) {
        return heroes.stream()
                .filter(hero -> hero.episodeIds.contains(film.episodeID))
                .collect(Collectors.toList());
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public Hero deleteHero(int id) {
        return heroes.remove(id);
    }

    public List<Hero> getHeroesBySurname(String surname) {
        return heroes.stream()
                .filter(hero -> hero.surname.equals(surname))
                .collect(Collectors.toList());
    }
    
    public List<Ally> getAllAllies() {
        return allies;
    }
    
    public List<com.restaurante.example.graphqle.model.Character> getAllCharacters() {
        List<com.restaurante.example.graphqle.model.Character> characters = new ArrayList<>();
        characters.addAll(heroes);
        characters.addAll(allies);
        return characters;
    }
    
    public List<SearchResult> search(String query){
        List<SearchResult> searchResult = new ArrayList<>();
        searchResult.addAll(films.stream().filter(film->film.title.contains(query)).collect(Collectors.toList()));
        searchResult.addAll(heroes.stream().filter(film->film.getName().contains(query)).collect(Collectors.toList()));        
        return searchResult;
    }
}
