package com.example.qualmeucep.ui.theme.screen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.qualmeucep.ui.theme.viewmodel.AddressViewModel


@Composable
fun SearchScreen(
    vm: AddressViewModel = viewModel(),
){
    val uiState by vm.uiState.collectAsState()
    var cep by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Qual meu CEP?",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value= cep,
            onValueChange = { cep = it },
            label = { Text("Digite seu CEP") }
        )
        Button(
            onClick = { vm.fetchAddress(cep) }
        ) {
            Text(text = "Buscar")
        }

        Spacer(modifier = Modifier.height(20.dp))

        uiState.address?.let { address ->
            Text(
                text = "Endereço: ${address?.logradouro}",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = "Endereço: ${uiState?.address?.bairro}",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = "Endereço: ${uiState?.address?.localidade}",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = "Endereço: ${uiState?.address?.uf}",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }


    }
    if(uiState.loading){
        CircularProgressIndicator()
    }
    uiState.error?.let { error ->

        Text(
            text = error
        )
    }
}

