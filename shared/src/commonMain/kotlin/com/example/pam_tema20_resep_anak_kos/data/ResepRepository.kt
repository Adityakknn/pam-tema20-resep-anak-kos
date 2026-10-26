package com.example.pam_tema20_resep_anak_kos.data

import com.example.pam_tema20_resep_anak_kos.model.Resep
import com.example.pam_tema20_resep_anak_kos.model.dataContoh
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

object ResepRepository {
    // dataContoh dipakai sebagai data awal
    private val _daftar = MutableStateFlow<List<Resep>>(dataContoh)
    val daftar: StateFlow<List<Resep>> = _daftar.asStateFlow()

    fun tambah(resep: Resep) {
        _daftar.update { it + resep }
    }

    fun idBerikutnya(): Int = (_daftar.value.maxOfOrNull { it.id } ?: 0) + 1
}