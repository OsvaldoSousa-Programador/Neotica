# Plano de Implementação: Alinhamento e Compactação do Trio de Botões

Este plano visa ajustar o trio de botões de ação (Copiar, Desafiar, Compartilhar) para que sua largura total coincida exatamente com a do botão principal ("Gerar/Resolver expressão") e que o conteúdo interno dos botões seja mais compacto, seguindo fielmente a imagem de referência.

## User Review Required

> [!IMPORTANT]
> A largura total da linha de botões será agora vinculada a `Dimens.Size.ButtonWidth`. Reduziremos os espaçamentos internos para garantir que os textos caibam sem apertar o design.

## Propostas de Mudança

### [UI Components] Refinamento de Compactação

#### [MODIFY] [AppActionButton.kt](file:///C:/Users/osval/AndroidStudioProjects/ExpressoesNumericas/app/src/main/java/com/jumirandapisousa/nohetica/app/ui/components/AppActionButton.kt)
- Reduzir `contentPadding` horizontal de 12.dp para **8.dp** para botões com texto.
- Reduzir o `Spacer` entre ícone e texto de 8.dp para **4.dp**.
- Garantir que a altura permaneça em **48.dp** para manter o alinhamento vertical com o botão quadrado.

### [UI/UX] Alinhamento na HomeScreen

#### [MODIFY] [HomeScreen.kt](file:///C:/Users/osval/AndroidStudioProjects/ExpressoesNumericas/app/src/main/java/com/jumirandapisousa/nohetica/app/ui/screens/HomeScreen.kt)
- Alterar o modificador da `Row` do trio de botões (em ambos os estados) de `width(screenWidth)` para **`width(Dimens.Size.ButtonWidth)`**.
- Remover o `padding` horizontal de margem, já que a largura agora é fixa e centralizada pela `Column`.
- Reduzir o `Arrangement.spacedBy` de 10.dp para **8.dp** para ganhar espaço interno.

---

## Plano de Verificação

### Testes Manuais
1.  **Alinhamento Visual**: Verificar se as bordas esquerda e direita do trio de botões estão perfeitamente alinhadas com as bordas do botão grande azul/laranja abaixo.
2.  **Compactação**: Confirmar se o texto "Copiar" e "Desafiar" está mais próximo do ícone e das bordas do botão.
3.  **Acessibilidade**: Garantir que, mesmo compactos, os botões ainda cresçam corretamente quando o `fontScale` for aumentado.
