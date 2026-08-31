# Atualização do Nível da API para Android 16 (API 36)

Este plano visa cumprir a exigência do Google Play Console de 31 de agosto de 2026, atualizando o aplicativo para suportar o Android 16.

## User Review Required

> [!IMPORTANT]
> **PRAZO:** Hoje é o prazo final (31 de agosto). Esta atualização é necessária para que você consiga subir novas versões do app ou finalizar o processo de revisão.
>
> **VERSIONAMENTO:** Além de mudar a API, vamos aumentar o `versionCode` de **1** para **2**. O Google Play não aceita dois arquivos com o mesmo número de versão.

## Proposed Changes

### Build Configuration

#### [MODIFY] [build.gradle.kts](file:///C:/Users/osval/AndroidStudioProjects/ExpressoesNumericas/app/build.gradle.kts)
Atualizar as configurações de SDK e o código da versão.

- `compileSdk`: de **35** para **36**
- `targetSdk`: de **35** para **36**
- `versionCode`: de **1** para **2**

## Verification Plan

### Automated Tests
- Executar um `gradle sync` para garantir que as ferramentas do Android 16 (API 36) estão instaladas e o projeto compila sem erros.

### Manual Verification
1. Juliana deve gerar o novo arquivo **.aab** no Android Studio.
2. Subir o novo arquivo no Console e verificar se o aviso vermelho desaparece.
