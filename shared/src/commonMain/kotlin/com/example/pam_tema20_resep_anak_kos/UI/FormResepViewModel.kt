package com.example.pam_tema20_resep_anak_kos.ui

import androidx.lifecycle.ViewModel
import com.example.pam_tema20_resep_anak_kos.data.ResepRepository
import com.example.pam_tema20_resep_anak_kos.model.Alat
import com.example.pam_tema20_resep_anak_kos.model.Bahan
import com.example.pam_tema20_resep_anak_kos.model.Resep
import com.example.pam_tema20_resep_anak_kos.model.StatusResep
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FormResepViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(FormResepUiState())
    val uiState: StateFlow<FormResepUiState> = _uiState.asStateFlow()

    fun ubahNama(v: String) = _uiState.update { it.copy(nama = v, pesan = null) }
    fun ubahDeskripsi(v: String) = _uiState.update { it.copy(deskripsi = v, pesan = null) }
    fun ubahDurasi(v: String) = _uiState.update { it.copy(durasiMenit = v.filter(Char::isDigit)) }
    fun ubahPorsi(v: String) = _uiState.update { it.copy(porsi = v.filter(Char::isDigit)) }
    fun ubahBahan(v: String) = _uiState.update { it.copy(bahanTeks = v) }
    fun ubahAlat(v: String) = _uiState.update { it.copy(alatTeks = v) }

    fun simpanResep(onSelesai: () -> Unit = {}) {
        val s = _uiState.value
        if (!s.bisaSimpan) return

        val resepBaru = Resep(
            id = ResepRepository.idBerikutnya(),
            nama = s.nama.trim(),
            deskripsi = s.deskripsi.trim(),
            durasiMenit = s.durasiMenit.toInt(),
            porsi = s.porsi.toInt(),
            fotoUrl = null,
            status = StatusResep.BelumDicoba,
            daftarBahan = parseBahan(s.bahanTeks),
            daftarAlat = parseAlat(s.alatTeks)
        )

        ResepRepository.tambah(resepBaru)
        _uiState.value = FormResepUiState()   // reset form
        onSelesai()
    }

    private fun parseBahan(teks: String): List<Bahan> =
        teks.lines()
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .mapIndexed { index, baris ->
                val p = baris.split(",").map { it.trim() }
                Bahan(
                    index + 1,
                    p[0],
                    p.getOrNull(1)?.toDoubleOrNull() ?: 1.0,
                    p.getOrNull(2)?.takeIf { it.isNotEmpty() } ?: "buah",
                    p.getOrNull(3)?.toIntOrNull() ?: 0
                )
            }

    private fun parseAlat(teks: String): List<Alat> =
        teks.lines()
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .mapIndexed { index, baris ->
                val p = baris.split(",").map { it.trim() }
                val sudahPunya = !p.getOrNull(1).equals("belum", ignoreCase = true)
                Alat(index + 1, p[0], sudahPunya)
            }
}