package com.example.qualmeucep.ui.theme.screen
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.qualmeucep.data.model.AddressViewModel


@Composable
fun SearchScreen(vm: AddressViewModel = viewModel()){
    val State by vm.uiState.collectAsState()

}