package gsd.games.repository

import android.util.Log
import gsd.games.api.ApiService
import gsd.games.games.Games
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.*

@Singleton
class GameRepository @Inject constructor(
    private val api: ApiService
) {
    fun getGames(): Flow<List<Games>> = flow {
        emit(api.getGames())
    }.catch { e ->
        Log.e("GameRepository", "Ошибка загрузки!: ${e.message}")
    }.flowOn(Dispatchers.IO)
}
