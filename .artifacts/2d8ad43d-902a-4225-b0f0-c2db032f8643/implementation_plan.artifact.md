# Criação de Nova Keystore e Ajuste de Versão

Este plano visa resolver o bloqueio de senha criando uma nova chave de assinatura e sincronizando a versão do aplicativo com a sua documentação (`0.9.0`).

## User Review Required

> [!IMPORTANT]
> **SEGURANÇA:** Ao criar a nova senha agora, por favor, anote-a imediatamente em um papel físico ou em um gerenciador de senhas seguro. Evite caracteres especiais muito complexos se o teclado costuma dar problema, mas mantenha a segurança.
>
> **PRIMEIRO ENVIO:** Estamos procedendo assumindo que este é o **primeiro** envio do app para a Google Play Console.

## Proposed Changes

### Build Configuration

#### [MODIFY] [build.gradle.kts](file:///C:/Users/osval/AndroidStudioProjects/ExpressoesNumericas/app/build.gradle.kts)
Alterar a versão do aplicativo para refletir o estágio de pré-lançamento.

- `versionName`: de `"1.0"` para `"0.9.0"`

### Procedimento Manual (Guia para Juliana)

Como eu não posso digitar as senhas por você na interface do Windows, siga estes passos exatos:

1. **Abrir o Assistente:** `Build` > `Generate Signed Bundle / APK...` > `Android App Bundle` > `Next`.
2. **Nova Chave:** Clique em **"Create new..."**.
3. **Key Store Path:** Clique na pastinha e escolha um local (ex: sua pasta `keys` mencionada). Nomeie como `nohetica-final.jks`.
4. **Password (Store):** Digite a nova senha (ex: uma frase simples sem espaços).
5. **Alias:** Use `nohetica_app`.
6. **Password (Key):** Use a **mesma senha** da Store para evitar confusão.
7. **Certificate:** Preencha apenas seu nome. Clique em **OK**.
8. **Finalizar:** Avance e escolha a variante `release`.

## Verification Plan

### Manual Verification
1. O Android Studio deve gerar o arquivo `.aab` sem erros de senha.
2. Verificar se o arquivo `app-release.aab` foi criado na pasta `release`.
