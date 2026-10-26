package com.example.pam_tema20_resep_anak_kos.ui

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pam_tema20_resep_anak_kos.ui.FormResepScreen
import com.example.pam_tema20_resep_anak_kos.ui.KolomTeks


@Composable
fun KolomTeks(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier
    )
}