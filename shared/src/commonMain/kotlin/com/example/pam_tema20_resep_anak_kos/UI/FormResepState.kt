package com.example.pam_tema20_resep_anak_kos.ui

data class FormResepUiState(
    val nama: String = "",
    val deskripsi: String = "",
    val durasiMenit: String = "",
    val porsi: String = "",
    val bahanTeks: String = "",   // satu bahan per baris
    val alatTeks: String = "",    // satu alat per baris
    val sedangMengirim: Boolean = false,
    val pesan: String? = null
) {
    val bisaSimpan: Boolean
        get() = nama.isNotBlank() &&
                deskripsi.isNotBlank() &&
                (durasiMenit.toIntOrNull() ?: 0) > 0 &&
                (porsi.toIntOrNull() ?: 0) > 0 &&
                !sedangMengirim
}