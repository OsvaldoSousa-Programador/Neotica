# Walkthrough - Implementação de Dicas Educativas (Info Bubble)

Implementamos um sistema de ajuda contextual que fornece dicas ao aluno durante a prática de expressões numéricas, utilizando um design moderno com efeito de desfoque.

## Alterações Realizadas

### Sistema de Informação
- **AppInfoBubble**: Criado um componente de balão de fala elegante com fundo azul suave e botão "Entendi!" em **NoeTeal**.
- **AppCard Inteligente**: O card da expressão agora abriga um botão "i" (Informação) no canto superior direito.
- **Efeito Visual**: Ao ativar a ajuda, o conteúdo da conta matemática abaixo do balão recebe um efeito de **Blur** (desfoque), destacando a mensagem de dica para o usuário.

### Mensagens Contextuais
As dicas mudam conforme o estado do aplicativo:
- **Ao gerar a conta**: Lembra o aluno de que ele pode resolver primeiro no papel.
- **Ao ver a resolução**: Explica a regra fundamental dos agrupadores (parênteses, colchetes e chaves).

## O que testar

1.  **Acessar a Ajuda**: No estado de "Expressão Atual", toque no ícone "i". O texto da conta deve ficar embaçado e o balão com a dica deve aparecer.
2.  **Fechar a Ajuda**: Toque no botão "Entendi!". O balão deve sumir e a conta deve voltar a ficar nítida.
3.  **Verificar Regras**: Vá para a tela de resolução e clique no "i". Verifique se a mensagem sobre a ordem de resolução ( (), [], {} ) aparece corretamente.

---

> [!TIP]
> O uso do efeito Blur não apenas melhora a estética, mas também ajuda o cérebro do usuário a focar na informação nova (a dica), reduzindo a distração com a conta que está por baixo.
