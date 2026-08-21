# Ajuste do Momento de Exibição do Modal Informativo

Este plano visa alterar o comportamento do modal informativo (Welcome Modal) para que ele não apareça imediatamente ao abrir o app, mas sim quando a primeira expressão for gerada (o que chamamos de "Estado 2" na `HomeScreen`).

## User Review Required

> [!IMPORTANT]
> O modal continuará aparecendo apenas uma vez (no primeiro acesso), conforme solicitado. A única mudança é **quando** ele dispara pela primeira vez.

## Proposed Changes

### UI Components

#### [MODIFY] [HomeScreen.kt](file:///C:/Users/osval/AndroidStudioProjects/ExpressoesNumericas/app/src/main/java/com/jumirandapisousa/nohetica/app/ui/screens/HomeScreen.kt)

Alterar a condição lógica que exibe o `AppInfoModal`.

**Antes:**
```kotlin
if (showWelcomeModal) { ... }
```

**Depois:**
```kotlin
if (showWelcomeModal && expressaoGerada.isNotEmpty() && resolucaoTexto.isEmpty()) { ... }
```

Isso garante que:
1. O usuário veja a tela inicial limpa primeiro.
2. O modal apareça com a dica de "resolver no caderno" exatamente quando ele tem uma expressão na tela para resolver.

## Verification Plan

### Manual Verification
1. Limpar os dados do aplicativo ou mudar o nome da SharedPreferences para simular primeiro acesso.
2. Abrir o app: o modal **não** deve aparecer.
3. Clicar em "Gerar Expressão": o modal **deve** aparecer.
4. Clicar em "Entendi!": o modal deve sumir e não aparecer mais, mesmo gerando novas expressões ou reiniciando o app.
