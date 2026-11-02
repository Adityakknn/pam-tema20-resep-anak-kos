package com.example.pam_tema20_resep_anak_kos.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pam_tema20_resep_anak_kos.data.ResepRepository
import com.example.pam_tema20_resep_anak_kos.model.Resep
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class DetailViewModel(
    id: Int,
    sumber: ResepRepository
) : ViewModel() {

    val resep: StateFlow<Resep?> = sumber.pantau(id).stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        null
    )
}