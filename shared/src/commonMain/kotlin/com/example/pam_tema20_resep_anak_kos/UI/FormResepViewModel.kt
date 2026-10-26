package com.example.pam_tema20_resep_anak_kos.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import com.example.pam_tema20_resep_anak_kos.ui.FormResepScreen
import com.example.pam_tema20_resep_anak_kos.ui.FormResepUiState
import com.example.pam_tema20_resep_anak_kos.ui.FormResepViewModel

class FormResepViewModel : ViewModel() {
    
    private val _uiState = MutableStateFlow(FormResepUiState())
    val uiState = _uiState.asStateFlow()

    fun ubahNama(teks: String) {
        _uiState.update { it.copy(nama = teks) }
    }

    fun ubahDeskripsi(teks: String) {
        _uiState.update { it.copy(deskripsi = teks) }
    }

    fun ubahDurasi(teks: String) {
        _uiState.update { it.copy(durasiMenit = teks) }
    }

    fun ubahPorsi(teks: String) {
        _uiState.update { it.copy(porsi = teks) }
    }

    fun simpanResep() {
        if (!_uiState.value.bisaSimpan) return

        viewModelScope.launch {
            _uiState.update { it.copy(sedangMengirim = true) }

            delay(800)
            
            _uiState.update { 
                FormResepUiState(pesan = "Resep berhasil disimpan!") 
            }
        }
    }
}