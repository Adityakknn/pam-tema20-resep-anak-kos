package com.example.pam_tema20_resep_anak_kos.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

data class TabUtama(
    val rute: Any,
    val label: String,
    val ikon: ImageVector
)

val DAFTAR_TAB = listOf(
    TabUtama(RuteBeranda, "Beranda", Icons.Default.Home),
    TabUtama(RuteAsisten, "Asisten", Icons.Default.Face),
    TabUtama(RuteProfil, "Profil", Icons.Default.Person)
)