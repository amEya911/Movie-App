package eu.tutorials.movieapp.viewModel

import eu.tutorials.movieapp.models.Details
import eu.tutorials.movieapp.models.MoviesList
import eu.tutorials.movieapp.utils.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getMovieList(page: Int): Response<MoviesList> {
        return RetrofitInstance.api.getMovies(page)
    }

    suspend fun getDetailsById(id: Int): Response<Details> {
        return RetrofitInstance.api.getDetailsById(id)
    }
}