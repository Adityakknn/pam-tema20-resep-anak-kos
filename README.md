
# 🍽️ Resep Anak Kos — PAM Tema 20

Aplikasi resep makanan sederhana untuk anak kos yang dikembangkan menggunakan **Kotlin Multiplatform** dan **Compose Multiplatform** sebagai bagian dari tugas Pengembangan Aplikasi Mobile (PAM).

Proyek ini menargetkan platform Android dan iOS dengan menerapkan konsep pemrograman Kotlin dan arsitektur MVVM.

## 🛠️ Teknologi yang Digunakan

- **Bahasa Pemrograman:** Kotlin
- **UI Framework:** Compose Multiplatform
- **Arsitektur:** Model-View-ViewModel (MVVM)
- **Platform:** Android dan iOS
- **Version Control:** Git dan GitHub

## 📁 Struktur Proyek

```text
pam-tema20-resep-anak-kos/
├── iosApp/
│   └── iosApp/
└── shared/
    └── src/
        ├── commonMain/
        ├── androidMain/
        ├── iosMain/
        └── jvmMain/
```

- `iosApp/` berisi entry point aplikasi iOS dan kode SwiftUI.
- `commonMain/` berisi kode Kotlin yang digunakan bersama oleh berbagai platform.
- `androidMain/`, `iosMain/`, dan `jvmMain/` berisi kode khusus untuk platform masing-masing.

## 👥 Kontributor

| Nama | NIM |
|---|---|
| Aditya Kristian Novalino | 124140079 |
| Galih Sigit Satrio | 124140001 |
| Jhon Kevin Tambun | 124140073 |

---

## 📚 Progres Tugas

### Minggu 1 — Membuat Repository

Membuat repository GitHub sebagai tempat penyimpanan kode sumber dan dokumentasi proyek.

![Progres Minggu 1](https://github.com/user-attachments/assets/48f8f82b-8e04-421a-8901-07b64c47a75d)

### Minggu 2 — Membuat Data Class

Membuat data class untuk merepresentasikan struktur data resep yang digunakan dalam aplikasi.

![Progres Minggu 2](https://github.com/user-attachments/assets/f1c09d52-4126-4ffc-8f06-b8ea241e4d79)

### Minggu 3 — Membuat Layar Laporan

Membuat antarmuka menggunakan Composable, `Modifier`, dan `LazyColumn` untuk menampilkan daftar data pada aplikasi.

![Progres Minggu 3](https://github.com/user-attachments/assets/8290beab-2c51-4da3-b3f6-937f3d4d4b64)

### Minggu 4 — Implementasi MVVM

Mengimplementasikan arsitektur Model-View-ViewModel (MVVM) untuk memisahkan pengelolaan data, logika aplikasi, dan antarmuka pengguna.

#### 1. Kondisi Awal

Tampilan awal formulir sebelum pengguna memasukkan data resep.

![Kondisi Awal](https://github.com/user-attachments/assets/576031c6-0e27-4aa8-8727-2488b267b5bb)

#### 2. Kondisi Pengisian

Tampilan formulir ketika pengguna memasukkan data resep.

![Kondisi Pengisian](https://github.com/user-attachments/assets/53706aa5-6864-436c-bfd5-9623e82a4fa6)

#### 3. Kondisi Akhir

Tampilan setelah pengguna menyelesaikan proses pengisian data resep.

![Kondisi Akhir](https://github.com/user-attachments/assets/8b3e6f02-d7e4-4e7c-8a34-6cb05c9f9f14)

---

## 🎯 Tujuan Proyek

Mengembangkan aplikasi resep makanan yang terstruktur dan mudah digunakan dengan menerapkan konsep pemrograman Kotlin, pengembangan aplikasi multiplatform, pengelolaan data, serta arsitektur MVVM.

## 🎓 Informasi Akademik

- **Mata Kuliah:** Pengembangan Aplikasi Mobile (PAM)
- **Program Studi:** Teknik Informatika
- **Institusi:** Institut Teknologi Sumatera (ITERA)
