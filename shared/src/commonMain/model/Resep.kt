package com.example.pam_tema20_resep_anak_kos.model

data class Resep(
    val id: Int,
    val nama: String,
    val deskripsi: String,
    val durasiMenit: Int,
    val porsi: Int,
    val fotoUrl: String?,
    val status: StatusResep,
    val daftarBahan: List<Bahan>
)
