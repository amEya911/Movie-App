package eu.tutorials.movieapp.domain

import eu.tutorials.movieapp.models.Details
import eu.tutorials.movieapp.models.MoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//Defines the endpoint to fetch movie data.

interface ApiInterface {
    @GET("movies?")
    suspend fun getMovies(
        @Query("page")page: Int
    ): Response<MoviesList>

    @GET("movies/{movie_id}")
    suspend fun getDetailsById(
        @Path("movie_id")id: Int
    ): Response<Details>


}