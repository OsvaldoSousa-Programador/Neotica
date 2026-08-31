# Walkthrough - Atualização de API (Android 16)

O projeto **ExpressoesNumericas** foi atualizado para cumprir as novas exigências do Google Play Store vigentes a partir de 31 de agosto de 2026.

## Alterações Realizadas

### Configuração de Build

#### [build.gradle.kts](file:///C:/Users/osval/AndroidStudioProjects/ExpressoesNumericas/app/build.gradle.kts)

- **API Level**: O nível de SDK foi elevado para **36** (Android 16), garantindo compatibilidade com as políticas de segurança mais recentes do Google.
- **Versionamento**: O `versionCode` foi incrementado para **2**. Isso é obrigatório para que o Google Play aceite o novo arquivo como uma atualização do anterior.

```diff
 android {
     namespace = "com.jumirandapisousa.nohetica.app"
-    compileSdk = 35
+    compileSdk = 36

     defaultConfig {
         applicationId = "com.jumirandapisousa.nohetica.app"
         minSdk = 24
-        targetSdk = 35
-        versionCode = 1
+        targetSdk = 36
+        versionCode = 2
         versionName = "0.9.0"
```

## Próximos Passos Obrigatórios

> [!IMPORTANT]
> Para que o aviso suma do Console, você deve seguir estes passos:
> 1. No Android Studio, vá em **Build > Generate Signed Bundle / APK...**.
> 2. Gere o novo arquivo **.aab** (lembre-se de usar a mesma Keystore e senha da semana passada).
> 3. Suba este novo arquivo no Google Play Console na mesma trilha de teste que estamos usando.

## Verificação Concluída
- [x] Arquivo de build atualizado e sincronizado.
- [x] O `versionCode` foi alterado para permitir o novo upload.
