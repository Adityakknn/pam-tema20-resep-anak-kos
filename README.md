This is a Kotlin Multiplatform project targeting Android, iOS.

* [/iosApp](./iosApp/iosApp) contains an iOS application. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

* [/shared](./shared/src) is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - [commonMain](./shared/src/commonMain/kotlin) is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    the [iosMain](./shared/src/iosMain/kotlin) folder would be the right place for such calls.
    Similarly, if you want to edit the Desktop (JVM) specific part, the [jvmMain](./shared/src/jvmMain/kotlin)
    folder is the appropriate location.
### Contributor
Aditya Kristian Novalino_124140079 
Galih Sigit Satrio_124140001 
Jhon Kevin Tambun_124140073

### Progress Tugas

Minggu 1:
 *Membuat Repositories pam-tema20-resep-anak-kos
  <img width="1917" height="1007" alt="PAM1" src="https://github.com/user-attachments/assets/48f8f82b-8e04-421a-8901-07b64c47a75d" />

Minggu 2:
 *Membuat Data Class
  <img width="1917" height="870" alt="PAM2" src="https://github.com/user-attachments/assets/f1c09d52-4126-4ffc-8f06-b8ea241e4d79" />

Minggu 3:
 *Membuat Layar laporan dengan composable, modifier, dan LazyColumn
  

