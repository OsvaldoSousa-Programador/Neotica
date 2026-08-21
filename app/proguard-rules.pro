# Regras específicas do projeto ExpressoesNumericas

# Preservar classes do Firebase
-keep class com.google.firebase.** { *; }

# Regras básicas para Jetpack Compose
-keepclassmembers class * extends androidx.compose.runtime.Composable { *; }

# Adicione aqui regras adicionais se notar que o app quebra em modo Release
