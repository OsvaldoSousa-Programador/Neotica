# Plano de Implementação: Modal Informativo de Boas-Vindas (Primeiro Acesso)

Este plano visa a criação do `AppInfoModal`, um diálogo centralizado que será exibido apenas na primeira vez que o usuário abrir o aplicativo, fornecendo uma orientação inicial importante.

## User Review Required

> [!IMPORTANT]
> O modal será persistente: após o usuário clicar em "Entendi!", ele não voltará a aparecer em aberturas futuras do app. Usaremos `SharedPreferences` para salvar esse estado.

## Propostas de Mudança

### [UI Components] Componente de Modal

#### [NEW] `AppInfoModal.kt`
- **Dimensões Físicas**: Largura 253dp, Altura 257dp.
- **Visual**: Fundo branco, cantos 8dp, sombra `#529ABC`.
- **Layout (Coluna)**:
    - Padding topo: 25dp.
    - Ícone Nohética (versão otimizada para o modal).
    - Espaçamento: 12dp.
    - Texto: "Você pode resolver com calma no seu caderno e só então tocar em Resolver Expressão".
        - Tamanho: 15sp, Peso: Médio, Cor: `#282525`.
    - Espaçamento: 12dp.
    - Botão "Entendi!": Fundo `#1CCEB4`, Texto `#282525`.
    - Padding base: 9dp.
    - Margens laterais internas: 13dp.

### [Logic] Controle de Primeiro Acesso

#### [MODIFY] [MainActivity.kt](file:///C:/Users/osval/AndroidStudioProjects/ExpressoesNumericas/app/src/main/java/com/jumirandapisousa/nohetica/app/MainActivity.kt) ou `HomeScreen.kt`
- Implementar a lógica de verificação:
    - Verificar se a chave `is_first_access` existe no armazenamento local.
    - Se for o primeiro acesso, disparar a exibição do modal.
    - Ao clicar em "Entendi!", salvar `is_first_access = false`.

### [UI/UX] Integração Visual

#### [MODIFY] [HomeScreen.kt](file:///C:/Users/osval/AndroidStudioProjects/ExpressoesNumericas/app/src/main/java/com/jumirandapisousa/nohetica/app/ui/screens/HomeScreen.kt)
- Exibir o modal como um overlay centralizado com efeito de desfoque (blur) no Dashboard de fundo.

---

## Plano de Verificação

### Testes Manuais
1.  **Primeiro Acesso**: Limpar os dados do app e abrir. O modal deve aparecer automaticamente.
2.  **Persistência**: Clicar em "Entendi!", fechar o app e abrir novamente. O modal **não** deve aparecer.
3.  **Design**: Validar se as dimensões (253x257) e cores (#282525 e #1CCEB4) estão idênticas ao pedido.

**Osvaldo, o plano está atualizado com a cor do texto e a lógica de primeiro acesso. Posso começar a implementação?**
