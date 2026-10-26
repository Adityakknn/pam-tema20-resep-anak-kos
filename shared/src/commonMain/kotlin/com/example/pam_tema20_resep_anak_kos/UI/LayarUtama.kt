package com.example.pam_tema20_resep_anak_kos.UI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pam_tema20_resep_anak_kos.model.Resep
import com.example.pam_tema20_resep_anak_kos.model.StatusResep

@Composable
fun LayarUtama(
    semua: List<Resep> = emptyList(),
    onTambahClick: () -> Unit = {}
) {
    val tercepat = semua.sortedBy { it.durasiMenit }
    val jumlahFavorit = semua.count { it.status is StatusResep.Favorit }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onTambahClick) {
                Text("+")
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Text(
                text = "Resep Anak Kos",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
            )

            Text(
                text = "${semua.size} resep • $jumlahFavorit favorit • tercepat di atas",
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            DaftarResep(
                semua = tercepat,
                onPilih = { resep ->
                    println("Dipilih #${resep.id} ${resep.nama}")
                },
                modifier = Modifier.weight(1f)
            )
        }
    }
}