package gsd.games.viewmodel

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import gsd.games.games.Games
import gsd.games.repository.GameRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    private val repository: GameRepository
) : ViewModel() {

    private val _games = MutableStateFlow<List<Games>>(emptyList())
    val games: StateFlow<List<Games>> = _games

    init {
        loadGames()
    }

    private fun loadGames() {
        viewModelScope.launch {
            repository.getGames().collect { gameList ->
                _games.value = gameList
            }
        }
    }
}
