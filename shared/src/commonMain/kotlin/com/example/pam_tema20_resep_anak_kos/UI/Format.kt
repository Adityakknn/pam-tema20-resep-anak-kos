package com.example.pam_tema20_resep_anak_kos.UI


fun formatRupiah(nilai: Int): String {
    val hasil = nilai.toString().reversed().chunked(3).joinToString(".").reversed()
    return "Rp $hasil"
}
