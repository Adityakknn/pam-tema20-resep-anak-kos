package com.example.pam_tema20_resep_anak_kos.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pam_tema20_resep_anak_kos.model.StatusResep
import com.example.pam_tema20_resep_anak_kos.model.Resep
import com.example.pam_tema20_resep_anak_kos.model.Alat
import com.example.pam_tema20_resep_anak_kos.model.Bahan


// Butir 1: kartu entitas. Card > Row > (Column info, LabelStatus)
@Composable
fun KartuResep(
    resep: Resep,
    modifier: Modifier = Modifier,
    ringkas: Boolean = false,
    onKlik: () -> Unit = {}
) {
    val keterangan: String? = when (val s = resep.status) {
        StatusResep.BelumDicoba -> null
        is StatusResep.SudahDicoba -> "Rating kamu: ${s.rating}/5"
        is StatusResep.Favorit -> s.catatan
    }
    // Fungsi koleksi dipakai langsung di komponen
    val biaya = resep.bahan.sumOf { it.harga }

    Card(
        modifier = modifier.fillMaxWidth().clickable { onKlik() },
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.weight(1f)) {
                Text(
                    text = resep.judul,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                if (!ringkas) {
                    Text(
                        "${resep.waktuMenit} menit • ${resep.bahan.size} bahan • ${resep.alat.size} alat",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                    Text(
                        "Estimasi ${formatRupiah(biaya)}",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                    if (keterangan != null) {
                        Text(keterangan, color = Color.Gray, fontSize = 12.sp)
                    }
                }
            }
            Spacer(Modifier.width(12.dp))
            LabelStatus(resep.status)
        }
    }
}
