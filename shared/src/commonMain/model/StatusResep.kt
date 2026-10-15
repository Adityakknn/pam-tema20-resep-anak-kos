package com.example.pam_tema20_resep_anak_kos.model

sealed class StatusResep {
    data object Diajukan : StatusResep()

    data object Disetujui : StatusResep()

    data class Ditolak(
        val alasan: String
    ) : StatusResep()
}