package com.example.location.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.location.models.items.LocationItemUi
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationScreen(viewModel: LocationViewModel = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Locations") })
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when (state) {
                is LocationUiState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                is LocationUiState.Error -> {
                    Text(
                        (state as LocationUiState.Error).message,
                        color = Color.Red,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
                is LocationUiState.Success -> {
                    val locations = (state as LocationUiState.Success).locations
                    LazyColumn {
                        items(items = locations) { item ->
                            LocationItem(item) {

                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LocationItem(
    location: LocationItemUi,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(8.dp)
    ) {
//        AsyncImage(
//            model = location.url,
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .size(64.dp)
//                .clip(RoundedCornerShape(8.dp))
//        )

        Spacer(Modifier.width(8.dp))

        Column {
            Text(location.name, style = MaterialTheme.typography.titleMedium)
            Text(location.type, style = MaterialTheme.typography.bodySmall)
            Text(location.dimension, style = MaterialTheme.typography.bodySmall)
        }
    }
}