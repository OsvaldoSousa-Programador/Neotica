# Plano de Implementação: Engenharia de Lançamento (Play Store)

Este plano visa finalizar as configurações técnicas para a geração do arquivo **AAB (Android App Bundle)** assinado, garantindo que o aplicativo esteja pronto para ser enviado ao Google Play Console.

## User Review Required

> [!IMPORTANT]
> Para gerar o arquivo assinado, você precisará ter o seu arquivo **Keystore (.jks)** em mãos.
> Vou configurar o projeto para ler os dados de um arquivo local seguro, assim não expomos suas senhas no código principal.

## Propostas de Mudança

### [Core] Configuração de Produção

#### [MODIFY] [build.gradle.kts](file:///C:/Users/osval/AndroidStudioProjects/ExpressoesNumericas/app/build.gradle.kts)
- Habilitar otimizações de código (`isMinifyEnabled = true`).
- Adicionar configuração de **Shrinking** de recursos para diminuir o tamanho do app.
- Configurar o bloco `signingConfigs` para buscar dados de um arquivo externo.

### [Segurança] Preparação da Assinatura

#### [NEW] `keystore.properties` (Instrução)
- Vou orientar você a criar este arquivo na raiz do projeto com as informações da sua chave. Eu não criarei o arquivo com suas senhas por segurança, apenas prepararei o Gradle para lê-lo.

### [Lógica] Revisão Final
- Confirmado que o [Gerador.kt](file:///C:/Users/osval/AndroidStudioProjects/ExpressoesNumericas/app/src/main/java/com/jumirandapisousa/nohetica/app/logic/Gerador.kt) já utiliza números aleatórios reais, sem dados "fake" de teste.

---

## Plano de Verificação

### Geração do Arquivo
1.  Após as mudanças, você deverá clicar em **Build > Generate Signed Bundle / APK**.
2.  Selecionar **Android App Bundle**.
3.  Usar as credenciais que você já possui.

### Testes de Qualidade
- **Build de Release**: Verificar se o Gradle gera o arquivo final sem erros de compilação com as otimizações ligadas.
- **Tamanho do Arquivo**: Garantir que o AAB ficou o menor possível para facilitar o download pelos usuários.

**Osvaldo, posso preparar o Gradle para o seu lançamento agora?** Vou deixar tudo no "gatilho" para você gerar o arquivo final.
