# Walkthrough - Identidade Visual: Gradiente na HomeScreen

Implementamos um novo fundo gradiente vertical exclusivo para a `HomeScreen`, elevando a estética visual do aplicativo com tons suaves de verde e lilás.

## Alterações Realizadas

### Cores de Marca
- **Color.kt**: Adicionadas as novas cores oficiais do gradiente:
    - `GradientTop`: #D5EEE0 (Verde menta suave)
    - `GradientBottom`: #E5E3EF (Lilás lavanda)

### Interface (HomeScreen)
- **HomeScreen.kt**: O contêiner principal (`Box`) agora utiliza um `Modifier.background` com um `Brush.verticalGradient`.
- O gradiente flui do topo para a base da tela, criando uma profundidade visual elegante por trás dos componentes.
- A imagem decorativa original foi mantida, aparecendo sobre o gradiente na tela inicial, o que cria um efeito de camadas interessante.

## O que observar

1.  **Suavidade**: Note como as cores escolhidas são relaxantes e não competem com a leitura das expressões matemáticas.
2.  **Foco na Home**: Ao navegar para as telas de "Termos de Uso" ou "Privacidade", você verá que elas mantêm o fundo padrão, destacando a `HomeScreen` como o coração interativo do app.

---

> [!TIP]
> Esse tipo de gradiente vertical ajuda a guiar o olhar do usuário do topo (onde está a logo) para a base (onde estão as ações), melhorando a hierarquia visual.
