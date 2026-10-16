
package com.example.pam_tema20_resep_anak_kos

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.pam_tema20_resep_anak_kos.UI.LayarUtama
import com.example.pam_tema20_resep_anak_kos.model.dataContoh

@Composable
@Preview
fun App() = MaterialTheme {
    LayarUtama(dataContoh)
}