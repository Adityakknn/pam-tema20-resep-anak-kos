package com.example.pam_tema20_resep_anak_kos.nav

import androidx.navigation.NavController

fun pindahTab(nav: NavController, rute: Any) {
    nav.navigate(rute) {
        popUpTo<RuteBeranda> {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}