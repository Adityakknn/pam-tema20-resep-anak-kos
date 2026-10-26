package com.example.pam_tema20_resep_anak_kos.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FormResepScreen(
    onKembali: () -> Unit = {},
    vm: FormResepViewModel = viewModel { FormResepViewModel() }
) {
    val state by vm.uiState.collectAsState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text("Tambah Resep Anak Kos", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(12.dp))

        KolomTeks(
            label = "Nama Resep",
            value = state.nama,
            onValueChange = vm::ubahNama,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))

        KolomTeks(
            label = "Deskripsi",
            value = state.deskripsi,
            onValueChange = vm::ubahDeskripsi,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))

        KolomTeks(
            label = "Durasi (Menit)",
            value = state.durasiMenit,
            onValueChange = vm::ubahDurasi,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))

        KolomTeks(
            label = "Porsi",
            value = state.porsi,
            onValueChange = vm::ubahPorsi,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))

        KolomTeks(
            label = "Bahan (Nama, jumlah, satuan, harga)",
            value = state.bahanTeks,
            onValueChange = vm::ubahBahan,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            "Contoh: Telur, 2, butir, 2500 (satu bahan per baris)",
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(Modifier.height(8.dp))

        KolomTeks(
            label = "Alat (satu per baris)",
            value = state.alatTeks,
            onValueChange = vm::ubahAlat,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            "Contoh: Wajan  atau  Spatula, belum",
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { vm.simpanResep(onSelesai = onKembali) },
            enabled = state.bisaSimpan,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (state.sedangMengirim) "Menyimpan..." else "Simpan Resep")
        }

        state.pesan?.let { pesan ->
            Spacer(Modifier.height(8.dp))
            Text(pesan, color = MaterialTheme.colorScheme.primary)
        }

        Spacer(Modifier.height(8.dp))
        OutlinedButton(onClick = onKembali, modifier = Modifier.fillMaxWidth()) {
            Text("Kembali")
        }
    }
}