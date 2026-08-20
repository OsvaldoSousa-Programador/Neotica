# Plano de Implementação: Gradientes nos Botões de Ação (Azul e Laranja)

Este plano visa adicionar gradientes horizontais personalizados para todos os botões principais do aplicativo, melhorando a estética visual e o destaque das ações.

## User Review Required

> [!IMPORTANT]
> Todos os botões principais (Gerar e Resolver) agora usarão gradientes horizontais. O efeito de "shrink" (encolhimento) ao toque será mantido para garantir a interatividade.

## Propostas de Mudança

### [Core] Identidade Visual

#### [MODIFY] [Color.kt](file:///C:/Users/osval/AndroidStudioProjects/ExpressoesNumericas/app/src/main/java/com/jumirandapisousa/nohetica/app/ui/theme/Color.kt)
- **Botão Gerar (Azul)**:
    - Adicionar `ButtonBlueStart = Color(0xFF49ACDA)`
    - Adicionar `ButtonBlueEnd = Color(0xFF028EE6)`
- **Botão Resolver (Laranja)**:
    - Adicionar `ButtonOrangeStart = Color(0xFFE96F22)`
    - Adicionar `ButtonOrangeEnd = Color(0xFFE45900)`

### [UI Components] Refatoração de Botão

#### [MODIFY] [AppButton.kt](file:///C:/Users/osval/AndroidStudioProjects/ExpressoesNumericas/app/src/main/java/com/jumirandapisousa/nohetica/app/ui/components/AppButton.kt)
- Adicionar parâmetro `backgroundBrush: Brush? = null`.
- Se o `brush` for fornecido, o botão usará o gradiente. Caso contrário, usará a cor sólida (mantendo compatibilidade).

### [UI/UX] Aplicação na HomeScreen

#### [MODIFY] [HomeScreen.kt](file:///C:/Users/osval/AndroidStudioProjects/ExpressoesNumericas/app/src/main/java/com/jumirandapisousa/nohetica/app/ui/screens/HomeScreen.kt)
- Criar os dois objetos `Brush` (Azul e Laranja).
- Aplicar o **Gradiente Azul** nos botões "Gerar Expressão" e "Gerar Nova Expressão".
- Aplicar o **Gradiente Laranja** no botão "Resolver Expressão".

---

## Plano de Verificação

### Testes Manuais
1.  **Visual:** Verificar se os botões azuis e laranjas agora possuem transições de cor suaves da esquerda para a direita.
2.  **Acessibilidade:** Confirmar que os botões continuam crescendo proporcionalmente quando o tamanho da fonte é aumentado.
3.  **Feedback:** Garantir que a animação de pulso continue clara sobre os novos fundos gradientes.
