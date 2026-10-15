package com.example.pam_tema20_resep_anak_kos.UI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pam_tema20_resep_anak_kos.model.StatusResep
import com.example.pam_tema20_resep_anak_kos.model.Resep
import com.example.pam_tema20_resep_anak_kos.model.Alat
import com.example.pam_tema20_resep_anak_kos.model.Bahan

@Composable
fun LayarUtama(semua: List<Resep>) {
    // Checkpoint 2: fungsi koleksi. List `semua` tidak berubah.
    val tercepat = semua.sortedBy { it.waktuMenit }
    val jumlahFavorit = semua.count { it.status is StatusResep.Favorit }

    Scaffold(
        floatingActionButton = {
            // Butir 3: satu aksi utama, belum berfungsi
            ExtendedFloatingActionButton(
                onClick = { /* Modul 5: buka form tambah resep */ },
                icon = { Icon(Icons.Default.Add, contentDescription = null) },
                text = { Text("Tambah Resep") }
            )
        }
    ) { padding ->
        Column(Modifier.padding(padding)) {
            Text(
                "Resep Anak Kos",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
            )
            Text(
                "${semua.size} resep • $jumlahFavorit favorit • tercepat di atas",
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            DaftarResep(
                semua = tercepat,
                onPilih = { println("Dipilih #${it.id} ${it.judul}") },
                modifier = Modifier.weight(1f)
            )
        }
    }
}