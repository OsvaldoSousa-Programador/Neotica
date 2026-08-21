# Walkthrough - Modal Informativo de Primeiro Acesso

Implementamos o `AppInfoModal`, um diálogo elegante e institucional que fornece orientações iniciais aos novos usuários do Nohética, aparecendo exclusivamente no primeiro acesso ao aplicativo.

## Alterações Realizadas

### Novo Componente: `AppInfoModal`
- **Design de Precisão**: Criado com dimensões fixas de **253dp x 257dp**, seguindo rigorosamente os espaçamentos solicitados (25dp topo, 9dp base, 12dp entre elementos).
- **Identidade Visual**: Inclui a logo do aplicativo centralizada, reforçando a marca desde o primeiro contato.
- **Tipografia e Cores**:
    - Texto informativo na cor grafite (**#282525**), tamanho 15sp e peso Médio.
    - Botão "Entendi!" com fundo verde água (**#1CCEB4**) e texto grafite em negrito.
- **Acabamento**: Fundo branco puro, cantos de 8dp e sombra azulada (**#529ABC**) para harmonia com o Dashboard.

### Lógica de Persistência
- **Inteligência de Acesso**: O aplicativo agora utiliza `SharedPreferences` para detectar se é a primeira vez que o usuário o abre.
- **Ciclo de Vida**: Assim que o usuário clica em "Entendi!", o estado é salvo permanentemente no dispositivo, e o modal nunca mais será exibido em sessões futuras.

### Experiência do Usuário (UX)
- **Efeito de Foco**: Ao exibir o modal, todo o fundo (incluindo a barra superior e os cards) recebe um efeito de desfoque (**blur**), garantindo que o usuário leia a instrução antes de prosseguir.

## O que testar

1.  **Primeiro Acesso**: Ao abrir o app pela primeira vez (ou limpar o cache), o modal deve aparecer centralizado com a logo e a dica sobre o caderno.
2.  **Ação de Fechamento**: Clique em "Entendi!". O modal deve sumir e o desfoque deve desaparecer instantaneamente.
3.  **Memória do App**: Feche o app completamente e abra-o de novo. O modal **não** deve mais aparecer.

---

> [!TIP]
> Essa abordagem de "Onboarding" (ambientação do usuário) é uma das melhores práticas para reduzir a taxa de abandono do app, pois explica claramente o propósito da ferramenta logo de cara.
