package com.example.pam_tema20_resep_anak_kos.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pam_tema20_resep_anak_kos.ui.FormResepScreen
import com.example.pam_tema20_resep_anak_kos.ui.FormResepViewModel
import com.example.pam_tema20_resep_anak_kos.ui.KolomTeks


@Composable
fun FormResepScreen(
    vm: FormResepViewModel = viewModel { FormResepViewModel() }
) {
    // Mengubah StateFlow dari ViewModel menjadi state Compose
    val state by vm.uiState.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Tambah Resep Anak Kos", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))

        // Menggunakan KolomTeks stateless
        KolomTeks(
            label = "Nama Resep",
            value = state.nama,
            onValueChange = vm::ubahNama, // Menggunakan referensi fungsi
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        KolomTeks(
            label = "Deskripsi",
            value = state.deskripsi,
            onValueChange = vm::ubahDeskripsi,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        KolomTeks(
            label = "Durasi (Menit)",
            value = state.durasiMenit,
            onValueChange = vm::ubahDurasi,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Tombol Kirim / Simpan
        Button(
            onClick = vm::simpanResep,
            enabled = state.bisaSimpan, // Tombol aktif otomatis jika data valid
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (state.sedangMengirim) "Menyimpan..." else "Simpan Resep")
        }

        // Menampilkan pesan sukses jika ada
        state.pesan?.let { pesan ->
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = pesan, color = MaterialTheme.colorScheme.primary)
        }
    }
}