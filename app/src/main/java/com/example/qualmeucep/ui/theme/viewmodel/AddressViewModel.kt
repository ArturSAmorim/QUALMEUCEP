package com.example.qualmeucep.ui.theme.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qualmeucep.data.model.Address
import com.example.qualmeucep.data.repository.ApiFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AddressViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(AddressUIState())
    val uiState: StateFlow<AddressUIState> = _uiState.asStateFlow()


    fun fetchAddress(cep: String) {

        _uiState.value =_uiState.value.copy(
            loading = true,
            error = null
        )
        viewModelScope.launch {
            try {
                val result = ApiFactory.apiCep.getAddress(cep)
               _uiState.value = _uiState.value.copy(
                   loading = false,
                   address = result
               )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    loading = false,
                    error = e.message
                )
            }
        }
    }
}

data class AddressUIState(
    val loading: Boolean = false,
    val address: Address? = null,
    val error: String? = null
)
