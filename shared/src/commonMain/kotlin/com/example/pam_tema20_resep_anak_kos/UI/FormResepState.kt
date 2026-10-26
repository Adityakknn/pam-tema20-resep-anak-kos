package com.example.pam_tema20_resep_anak_kos.ui

data class FormResepUiState(
    val nama: String = "",
    val deskripsi: String = "",
    val durasiMenit: String = "",
    val porsi: String = "",
    val sedangMengirim: Boolean = false,
    val pesan: String? = null
) {
    // Validasi otomatis: tombol hanya bisa diklik jika nama & deskripsi terisi
    val bisaSimpan: Boolean
        get() = nama.isNotBlank() && deskripsi.isNotBlank() && !sedangMengirim
}