
package com.example.pam_tema20_resep_anak_kos.model

sealed interface StatusResep {
    data object BelumDicoba : StatusResep

    data class SudahDicoba(
        val rating: Int
    ) : StatusResep

    data class Favorit(
        val catatan: String = ""
    ) : StatusResep
}
