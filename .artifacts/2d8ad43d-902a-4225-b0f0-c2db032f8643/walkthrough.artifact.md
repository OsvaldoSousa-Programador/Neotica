# Walkthrough - Ajuste do Modal de Primeiro Acesso

O modal informativo que orienta o usuário a "resolver com calma no caderno" foi reconfigurado para aparecer no momento mais oportuno: quando uma expressão está visível na tela.

## Alterações Realizadas

### Interface do Usuário (UI)

#### [HomeScreen.kt](file:///C:/Users/osval/AndroidStudioProjects/ExpressoesNumericas/app/src/main/java/com/jumirandapisousa/nohetica/app/ui/screens/HomeScreen.kt)

- **Lógica de Gatilho**: A condição para exibir o `AppInfoModal` foi alterada. Agora, além de verificar se é o primeiro acesso (`showWelcomeModal`), ele também verifica se uma expressão foi gerada (`expressaoGerada.isNotEmpty()`) e se a resolução ainda não foi mostrada (`resolucaoTexto.isEmpty()`).

```diff
-        if (showWelcomeModal) {
+        // Aparece apenas no primeiro acesso ao app, quando a primeira expressão é gerada (Estado 2)
+        if (showWelcomeModal && expressaoGerada.isNotEmpty() && resolucaoTexto.isEmpty()) {
```

## Verificação Concluída

- [x] O código foi modificado mantendo a persistência em `SharedPreferences`.
- [x] A lógica garante que o modal não interrompa o usuário logo na abertura do app.
- [x] O comportamento do botão "i" (balão informativo manual) permanece inalterado.
