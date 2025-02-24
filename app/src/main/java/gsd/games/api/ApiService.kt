package gsd.games.api

import gsd.games.games.Games
import retrofit2.http.GET

interface ApiService {
    @GET("games/")
    suspend fun getGames(): List<Games>
}
