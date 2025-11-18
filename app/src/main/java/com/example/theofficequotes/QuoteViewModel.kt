package com.example.theofficequotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class QuoteViewModel(): ViewModel() {

    // single mutable state holder for the entire screen
    private val _state = MutableStateFlow(QuoteState())
    val state: StateFlow<QuoteState> = _state.asStateFlow() // read-only StateFlow that the Composable observes

    private val apiService = RetrofitInstance.quoteApi

    // call fetch on initialization to load the first quote
    init {
        fetchRandomQuote()
    }

    // fetchRandomQuote() method
    fun fetchRandomQuote() {
        viewModelScope.launch {
            // 1. set the loading state
            _state.update {
                it.copy(isLoading = true, isError = false)
            }

            try {
                // execute the suspend network call
                val response = apiService.getRandomQuote()

                if(response.isSuccessful) {
                    val quoteModel = response.body()

                    if(quoteModel != null) {
                        // success: update the state with new data
                        _state.update {
                            it.copy(
                                quoteText = quoteModel.quote,
                                characterName = quoteModel.character,
                                imageUrl = quoteModel.character_avatar_url,
                                isLoading = false
                            )
                        }
                    } else {
                        // error: response is 2xx nut body is empty
                        _state.update { handleApiError("Received empty quote.") }
                    }
                } else {
                    // error: response is non-2xx (e.g. 404, 500)
                    _state.update { handleApiError("API Error: ${response.code()}") }
                }
            } catch (e: Exception) {
                // error: network request failed or timeout
                _state.update { handleApiError("Network Connection Failed") }
            }
        }
    }

    // helper function for consistent error state updates
    private fun handleApiError(errorMessage: String) = QuoteState(
        quoteText = errorMessage,
        characterName = "Dunder Mifflin",
        imageUrl = "", // Clear image on error
        isLoading = false,
        isError = true
    )
}