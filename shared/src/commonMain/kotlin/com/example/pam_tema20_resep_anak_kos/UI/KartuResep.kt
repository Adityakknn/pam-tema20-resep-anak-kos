
package com.example.pam_tema20_resep_anak_kos.UI

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pam_tema20_resep_anak_kos.model.Resep
import com.example.pam_tema20_resep_anak_kos.model.StatusResep

@Composable
fun KartuResep(
    resep: Resep,
    modifier: Modifier = Modifier,
    ringkas: Boolean = false,
    onKlik: () -> Unit = {}
) {
    val keterangan: String? = when (val status = resep.status) {
        StatusResep.BelumDicoba -> null
        is StatusResep.SudahDicoba -> "Rating kamu: ${status.rating}/5"
        is StatusResep.Favorit -> status.catatan
    }

    val biaya: Int = resep.daftarBahan.sumOf { bahan ->
        bahan.hargaEstimasi
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onKlik() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = resep.nama,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                if (!ringkas) {
                    Text(
                        text = "${resep.durasiMenit} menit - " +
                                "${resep.daftarBahan.size} bahan - " +
                                "${resep.daftarAlat.size} alat",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )

                    Text(
                        text = "Estimasi ${formatRupiah(biaya)}",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )

                    if (!keterangan.isNullOrBlank()) {
                        Text(
                            text = keterangan,
                            color = Color.Gray,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            LabelStatus(status = resep.status)
        }
    }
}
