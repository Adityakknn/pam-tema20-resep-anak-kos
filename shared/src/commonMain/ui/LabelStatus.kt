package com.example.pam_tema20_resep_anak_kos.model
package com.example.pam_tema20_resep_anak_kos.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color   // awas: jangan java.awt.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import resepkos.model.StatusResep

@Composable
fun LabelStatus(status: StatusResep) {
    val (teks, warna) = when (status) {
        StatusResep.BelumDicoba -> "Belum dicoba" to Color(0xFFE6E2D6)
        is StatusResep.SudahDicoba -> "Sudah dicoba" to Color(0xFFDCEFD6)
        is StatusResep.Favorit -> "Favorit" to Color(0xFFF6EDCF)
    }
    Text(
        text = teks,
        fontSize = 12.sp,
        modifier = Modifier
            .background(warna, RoundedCornerShape(50))
            .padding(horizontal = 12.dp, vertical = 4.dp)
    )
}
