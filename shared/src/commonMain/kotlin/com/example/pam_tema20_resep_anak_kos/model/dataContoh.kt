package com.example.pam_tema20_resep_anak_kos.model

val dataContoh = listOf(
    Resep(
        id = 1, nama = "Indomie Telur", deskripsi = "Mi instan dengan telur dan cabai rawit.",
        durasiMenit = 8, porsi = 1, fotoUrl = null,
        status = StatusResep.Favorit("Andalan tanggal tua"),
        daftarBahan = listOf(
            Bahan(1, "Mi instan", 1.0, "bungkus", 3500),
            Bahan(2, "Telur", 1.0, "butir", 2500),
            Bahan(3, "Cabai rawit", 3.0, "buah", 500)
        ),
        daftarAlat = listOf(Alat(1, "Panci", true), Alat(2, "Kompor", true))
    ),
    Resep(
        id = 2, nama = "Nasi Goreng Kampung", deskripsi = "Nasi goreng sederhana dengan telur dan kecap.",
        durasiMenit = 15, porsi = 1, fotoUrl = null,
        status = StatusResep.SudahDicoba(4),
        daftarBahan = listOf(
            Bahan(1, "Nasi putih", 1.0, "porsi", 4000),
            Bahan(2, "Telur", 1.0, "butir", 2500),
            Bahan(3, "Bawang merah", 2.0, "siung", 1000),
            Bahan(4, "Kecap manis", 1.0, "sdm", 500)
        ),
        daftarAlat = listOf(Alat(1, "Wajan", true), Alat(2, "Spatula", false), Alat(3, "Kompor", true))
    ),
    Resep(
        id = 3, nama = "Telur Dadar Gulung", deskripsi = "Dadar tipis digulung dengan daun bawang.",
        durasiMenit = 10, porsi = 1, fotoUrl = null,
        status = StatusResep.BelumDicoba,
        daftarBahan = listOf(
            Bahan(1, "Telur", 2.0, "butir", 5000),
            Bahan(2, "Daun bawang", 1.0, "batang", 500),
            Bahan(3, "Garam", 1.0, "sejumput", 100)
        ),
        daftarAlat = listOf(Alat(1, "Wajan", true), Alat(2, "Garpu", false))
    ),
    Resep(
        id = 4, nama = "Tumis Kangkung", deskripsi = "Kangkung tumis bawang putih dan saus tiram.",
        durasiMenit = 12, porsi = 1, fotoUrl = null,
        status = StatusResep.SudahDicoba(5),
        daftarBahan = listOf(
            Bahan(1, "Kangkung", 1.0, "ikat", 3000),
            Bahan(2, "Bawang putih", 3.0, "siung", 1000),
            Bahan(3, "Saus tiram", 1.0, "sdm", 1000)
        ),
        daftarAlat = listOf(Alat(1, "Wajan", true), Alat(2, "Kompor", true))
    ),
    Resep(
        id = 5, nama = "Mie Goreng Rice Cooker", deskripsi = "Tanpa kompor, cocok untuk kos.",
        durasiMenit = 15, porsi = 1, fotoUrl = null,
        status = StatusResep.Favorit("Tanpa kompor, aman di kos"),
        daftarBahan = listOf(
            Bahan(1, "Mi instan", 1.0, "bungkus", 3500),
            Bahan(2, "Telur", 1.0, "butir", 2500),
            Bahan(3, "Sosis", 2.0, "buah", 3000)
        ),
        daftarAlat = listOf(Alat(1, "Rice cooker", true))
    ),
    Resep(
        id = 6, nama = "Roti Bakar Telur", deskripsi = "Roti tawar panggang dengan telur dan margarin.",
        durasiMenit = 7, porsi = 1, fotoUrl = null,
        status = StatusResep.BelumDicoba,
        daftarBahan = listOf(
            Bahan(1, "Roti tawar", 2.0, "lembar", 2000),
            Bahan(2, "Telur", 1.0, "butir", 2500),
            Bahan(3, "Margarin", 1.0, "sdt", 500)
        ),
        daftarAlat = listOf(Alat(1, "Teflon", true), Alat(2, "Spatula", false))
    )
)