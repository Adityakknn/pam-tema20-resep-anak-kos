package com.example.pam_tema20_resep_anak_kos

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.pam_tema20_resep_anak_kos.UI.LayarUtama
import com.example.pam_tema20_resep_anak_kos.model.Resep
import com.example.pam_tema20_resep_anak_kos.model.dataContoh
import com.example.pam_tema20_resep_anak_kos.ui.FormResepScreen

@Composable
fun App() {
    var tampilForm by remember { mutableStateOf(false) }

    // Sementara kosong. Ganti dengan sumber data Anda (repository/ViewModel)
    val daftarResep: List<Resep> = dataContoh

    if (tampilForm) {
        FormResepScreen(onKembali = { tampilForm = false })
    } else {
        LayarUtama(
            semua = daftarResep,
            onTambahClick = { tampilForm = true }
        )
    }
}