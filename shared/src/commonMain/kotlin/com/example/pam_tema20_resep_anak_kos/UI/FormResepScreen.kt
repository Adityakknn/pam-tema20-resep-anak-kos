package com.example.pam_tema20_resep_anak_kos.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Tambah Resep Anak Kos", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))

        KolomTeks(
            label = "Nama Resep",
            value = state.nama,
            onValueChange = vm::ubahNama,
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

        Button(
            onClick = vm::simpanResep,
            enabled = state.bisaSimpan,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (state.sedangMengirim) "Menyimpan..." else "Simpan Resep")
        }

        state.pesan?.let { pesan ->
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = pesan, color = MaterialTheme.colorScheme.primary)
        }

        Spacer(modifier = Modifier.height(8.dp))
        OutlinedButton(
            onClick = onKembali,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Kembali")
        }
    }
}