package com.bootcamp.hql_movies;

import com.bootcamp.hql_movies.model.Actor;
import com.bootcamp.hql_movies.model.Movie;
import com.bootcamp.hql_movies.repository.IActorRepository;
import com.bootcamp.hql_movies.repository.IMovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class HqlMoviesApplicationTests {
	private IActorRepository actorRepository;
	private IMovieRepository movieRepository;
	private Movie movie;
	private Actor actor;
	private Actor actor2;

	@Autowired
	public HqlMoviesApplicationTests(IActorRepository actorRepository, IMovieRepository movieRepository) {
		this.actorRepository = actorRepository;
		this.movieRepository = movieRepository;
		movie = new Movie();
		movie.setTitle("Una re peli");
		movie.setRating(new BigDecimal("8.5"));
		movie.setAwards(5);
		movie.setReleaseDate(LocalDate.now());
		movie.setLength(150);
		movieRepository.save(movie);
		actor = new Actor();
		actor.setRating(new BigDecimal("7.8"));
		actor.setFirstName("John");
		actor.setLastName("Doe");
		actor.setMovies(Set.of(movie));
		actorRepository.save(actor);

		actor2 = new Actor();
		actor2.setRating(new BigDecimal("0"));
		actor2.setFirstName("Juan");
		actor2.setLastName("Du");
		actorRepository.save(actor2);
	}

	@Test
	void testQuery() {
		List<Actor> result = actorRepository.findActorByMovieQuery(movie);
		assertEquals(1, result.size());
		assertEquals(actor, result.get(0));
	}

}
