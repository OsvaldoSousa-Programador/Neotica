# Plano de Implementação: Alinhamento Milimétrico do Sistema de Ajuda

Este plano visa ajustar o posicionamento do ícone informativo e do balão de dica (bubble) para que fiquem idênticos à imagem de referência, garantindo que a ponta do balão toque o ícone e que o conteúdo abaixo seja desfocado corretamente.

## User Review Required

> [!IMPORTANT]
> O balão de ajuda será posicionado de forma que sua ponta superior direita toque a diagonal inferior esquerda do ícone "i". O quadro branco (Dashboard) será totalmente desfocado para dar ênfase à mensagem.

## Propostas de Mudança

### [UI Components] Ajustes de Forma e Espaço

#### [MODIFY] [AppCard.kt](file:///C:/Users/osval/AndroidStudioProjects/ExpressoesNumericas/app/src/main/java/com/jumirandapisousa/nohetica/app/ui/components/AppCard.kt)
- Aumentar o `Spacer` no topo da expressão para **64.dp**. Isso garante que o texto da conta comece exatamente abaixo da área ocupada pelo ícone "i", evitando sobreposição.

#### [MODIFY] [AppInfoBubble.kt](file:///C:/Users/osval/AndroidStudioProjects/ExpressoesNumericas/app/src/main/java/com/jumirandapisousa/nohetica/app/ui/components/AppInfoBubble.kt)
- Garantir que a ponta aguda esteja no canto superior direito: `RoundedCornerShape(topStart = 24.dp, topEnd = 4.dp, bottomStart = 24.dp, bottomEnd = 24.dp)`.
- Remover o `fillMaxWidth()` interno para que o balão possa ser posicionado com precisão via `offset` sem "empurrar" as bordas da tela.

### [UI/UX] Posicionamento na HomeScreen

#### [MODIFY] [HomeScreen.kt](file:///C:/Users/osval/AndroidStudioProjects/ExpressoesNumericas/app/src/main/java/com/jumirandapisousa/nohetica/app/ui/screens/HomeScreen.kt)
- **Botão "i"**:
    - Fundo: `#B0DAEE`.
    - Texto "i": `#282525`, negrito.
    - Posição: `top = 28.dp, end = 20.dp`.
- **Balão (Bubble)**:
    - Aplicar um `offset` calculado: `x = (-52).dp, y = 60.dp`.
    - Isso fará com que a ponta do balão toque exatamente a diagonal do ícone, conforme a imagem.
- **Desfoque**: Manter o desfoque de 12.dp em todo o `AppDashboardCard`.

---

## Plano de Verificação

### Testes Manuais
1.  **Fidelidade Visual**: Comparar o resultado final com a imagem fornecida, focando no ponto de contato entre o balão e o ícone.
2.  **Legibilidade**: Confirmar que a conta matemática (mesmo desfocada) não está mais "por trás" do ícone "i".
3.  **Interação**: Clicar em "Entendi!" e verificar se o desfoque global é removido instantaneamente.

**Osvaldo, esse ajuste milimétrico está de acordo? Posso aplicar agora?**
