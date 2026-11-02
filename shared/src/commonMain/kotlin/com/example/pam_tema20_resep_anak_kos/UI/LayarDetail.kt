package com.example.pam_tema20_resep_anak_kos.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pam_tema20_resep_anak_kos.model.Resep

@Composable
fun LayarDetail(
    resep: Resep?,
    kembali: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        OutlinedButton(onClick = kembali) { Text("← Kembali") }
        Spacer(Modifier.height(12.dp))

        if (resep == null) {
            Text("Memuat...")
            return@Column
        }

        Text(resep.nama, style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(4.dp))
        Text(resep.deskripsi)
        Spacer(Modifier.height(8.dp))
        Text("${resep.durasiMenit} menit • ${resep.porsi} porsi")
        Spacer(Modifier.height(8.dp))
        LabelStatus(status = resep.status)

        Spacer(Modifier.height(16.dp))
        Text("Bahan", style = MaterialTheme.typography.titleMedium)
        resep.daftarBahan.forEach { b ->
            val jumlah = if (b.jumlah % 1.0 == 0.0) b.jumlah.toInt().toString() else b.jumlah.toString()
            Text("• ${b.nama}: $jumlah ${b.satuan} (${formatRupiah(b.hargaEstimasi)})")
        }
        Spacer(Modifier.height(4.dp))
        Text(
            "Estimasi total: ${formatRupiah(resep.daftarBahan.sumOf { it.hargaEstimasi })}",
            style = MaterialTheme.typography.titleSmall
        )

        Spacer(Modifier.height(16.dp))
        Text("Alat", style = MaterialTheme.typography.titleMedium)
        resep.daftarAlat.forEach { a ->
            Text("• ${a.namaAlat} ${if (a.wajibAda) "(wajib)" else "(opsional)"}")
        }

        Spacer(Modifier.height(16.dp))
        Modifier.fillMaxWidth()
    }
}