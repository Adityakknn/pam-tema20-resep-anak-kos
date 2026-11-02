package com.example.pam_tema20_resep_anak_kos.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pam_tema20_resep_anak_kos.model.Resep


@Composable
fun DaftarResep(
    semua: List<Resep>,
    onPilih: (Resep) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(semua, key = { it.id }) { resep ->
            KartuResep(resep, onKlik = { onPilih(resep) })
        }
    }
}
