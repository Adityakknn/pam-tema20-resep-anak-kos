package com.example.pam_tema20_resep_anak_kos

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.pam_tema20_resep_anak_kos.data.ResepRepository
import com.example.pam_tema20_resep_anak_kos.nav.DAFTAR_TAB
import com.example.pam_tema20_resep_anak_kos.nav.RuteAsisten
import com.example.pam_tema20_resep_anak_kos.nav.RuteBeranda
import com.example.pam_tema20_resep_anak_kos.nav.RuteDetail
import com.example.pam_tema20_resep_anak_kos.nav.RuteForm
import com.example.pam_tema20_resep_anak_kos.nav.RuteProfil
import com.example.pam_tema20_resep_anak_kos.nav.pindahTab
import com.example.pam_tema20_resep_anak_kos.ui.DetailViewModel
import com.example.pam_tema20_resep_anak_kos.ui.FormResepScreen
import com.example.pam_tema20_resep_anak_kos.ui.LayarAsisten
import com.example.pam_tema20_resep_anak_kos.ui.LayarDetail
import com.example.pam_tema20_resep_anak_kos.ui.LayarProfil
import com.example.pam_tema20_resep_anak_kos.ui.LayarUtama

@Composable
fun App() {
    val nav = rememberNavController()
    val daftarResep by ResepRepository.daftar.collectAsState()

    val entry by nav.currentBackStackEntryAsState()
    val tujuan = entry?.destination
    // Menu bawah hanya tampil di 3 tab utama, tidak di Detail dan Form
    val tampilMenuBawah = DAFTAR_TAB.any { tujuan?.hasRoute(it.rute::class) == true }

    Scaffold(
        bottomBar = {
            if (tampilMenuBawah) {
                NavigationBar {
                    DAFTAR_TAB.forEach { tab ->
                        NavigationBarItem(
                            selected = tujuan?.hasRoute(tab.rute::class) == true,
                            onClick = { pindahTab(nav, tab.rute) },
                            icon = { Icon(tab.ikon, contentDescription = null) },
                            label = { Text(tab.label) }
                        )
                    }
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = nav,
            startDestination = RuteBeranda,
            modifier = Modifier.padding(padding)
        ) {
            composable<RuteBeranda> {
                LayarUtama(
                    semua = daftarResep,
                    bukaDetail = { id -> nav.navigate(RuteDetail(id)) },
                    onTambahClick = { nav.navigate(RuteForm) }
                )
            }
            composable<RuteDetail> { backStackEntry ->
                val id = backStackEntry.toRoute<RuteDetail>().id
                val vm = viewModel { DetailViewModel(id, ResepRepository) }
                val resep by vm.resep.collectAsState()
                LayarDetail(resep = resep, kembali = { nav.popBackStack() })
            }
            composable<RuteForm> {
                FormResepScreen(
                    onKembali = { nav.popBackStack() },
                    onSimpan = { idBaru -> nav.navigate(RuteDetail(idBaru)) {
                        popUpTo<RuteBeranda>()
                        launchSingleTop = true
                        }
                    }
                )
            }

            composable<RuteProfil> { LayarProfil() }
            composable<RuteAsisten> { LayarAsisten() }
        }
    }
}