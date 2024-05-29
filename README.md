# MQTT_ANDROID

## Descrição

Aplicação Android que envia e recebe mensagem atravé o protocolo MQTT.

## Funcionalidades

- [ ] Estabelecer uma conexão com um broker MQTT.
- [ ] Publicar mensagens em um tópico específico.
- [ ] Subscrever a um tópico e receber mensagens publicadas neste tópico.
- [ ] Ser capaz de lidar com as operações básicas de conexão, publicação e subscrição de forma eficiente e sem erros.

## Tecnologias Utilizadas

- **HiveMQ Cloud**: é uma plataforma de mensagens IoT totalmente gerenciada e nativa da nuvem que simplifica a conectividade confiável e escalável de dispositivos IoT, utilizada para criar um servidor na nuvem.
- **Android Studio**: O Android Studio é o ambiente de desenvolvimento integrado (IDE) oficial para o desenvolvimento de apps Android, utilizada para criar a arquitetura do aplicativo.
- **Android SDK**: Para o desenvolvimento da interface do usuário e lógica do aplicativo.

## Requisitos

- Android Studio 2023 (ou versão mais recente)
- JDK (Java Development Kit) 11 ou superior
- Dispositivo Android ou emulador com Android 8.0 (Oreo) ou superior
- Conhecimento básico de programação em Java ou Kotlin
- Sistema operacional compatível (ex: Windows, macOS, Linux)
- Versão do Java (ex: Java 8 ou superior)
- Memória RAM mínima de 4GB
- Espaço em disco disponível de pelo menos 1GB
- Conexão com a internet

## Instalação

Passos para instalar e configurar o sistema.

1. Faça o download do código-fonte do projeto.

2. Importe o projeto para o Android Studio.

3. Crie uma conta no [HiveMQ](https://www.hivemq.com/).
<img src="/app/src/main/res/prints_hivemqtt/1.png">

4. Configure um Servidor
<img src="/app/src/main/res/prints_hivemqtt/2.png">
 
5. Acesse as Credenciais 
<img src="/app/src/main/res/prints_hivemqtt/3.png">

6. Conecte o Web Client  
<img src="/app/src/main/res/prints_hivemqtt/4.png">

7. Crie um Topico        
<img src="/app/src/main/res/prints_hivemqtt/5.png">   

## Uso
Possibilidade de enviar e receber mensagens através do aplicativo ou do tópico no servidor.

## Desenvolvimento

| Passos                          | Descrição
|---------------------------------|------------------------------------------------------------------|
| Criação do Servidor no HiveMQTT | Fiz o passo a passo de criação de conta, configuração e acesso do servidor. |
| Conexão do Web Client           | Fiz a conexão do web client e criei um topico para envio e recebimento de mensagens. |
| Vinculação do Projeto           | Configuração do projeto Android com o Servidor. |  
| Lógica da Tela Inicial          | Desenvolvimento da lógica para o envio e recebimento das mensagens. |

## Material de Apoio

Documentação do HiveMQTT
- [HiveMQTT](https://docs.hivemq.com/hivemq-cloud/index.html)

Projeto no GitHub do colega Wesley - MQTT: Conectando Dispositivos para a Era da Internet das Coisas
- [MQTT](https://github.com/seu-usuario/MQTT.git)

## Simulação
- [MQTT_ANDROID](https://github.com/SilvanaMenezes/MQTT_ANDROID/assets/56271202/91ec4cb9-4fae-4686-8324-011ece3c4bd3)

- Tela Servidor
<p>Mensagens do lado web client.</p>
<img src="" width="300">





