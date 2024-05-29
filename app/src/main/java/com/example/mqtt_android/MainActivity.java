package com.example.mqtt_android;

import static com.hivemq.client.mqtt.MqttGlobalPublishFilter.ALL;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;
import com.hivemq.client.mqtt.mqtt5.Mqtt5Client;

import java.nio.charset.StandardCharsets;
import java.net.IDN;

public class MainActivity extends AppCompatActivity {
    private Mqtt5BlockingClient client;
    private TextView textViewMessages;
    private EditText editTextMessage;
    private Button buttonSend;
    private static final String TOPIC = "topico01";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewMessages = findViewById(R.id.textViewMessages);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);

        setupMqttClient();

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        client.toAsync().publishes(ALL, publish -> {
            String receivedMessage = new String(publish.getPayloadAsBytes(), StandardCharsets.UTF_8);
            runOnUiThread(() -> {
                textViewMessages.append("\n" + receivedMessage);
            });
        });
    }

    private void setupMqttClient() {
        String host = "c9aa94f9aaed4b7fa6f7289774b259b6.s1.eu.hivemq.cloud";
        int port = 8883;
        String username = "silvanadev.one@gmail.com";
        String password = "Sil@hivemq24";

        try {
            String asciiHost = IDN.toASCII(host);

            client = Mqtt5Client.builder()
                    .serverHost(asciiHost)
                    .serverPort(port)
                    .sslWithDefaultConfig()
                    .buildBlocking();

            Log.d(TAG, "Conectando ao servidor MQTT...");

            client.connectWith()
                    .simpleAuth()
                    .username(username)
                    .password(StandardCharsets.UTF_8.encode(password))
                    .applySimpleAuth()
                    .send();

            Log.d(TAG, "Conexão estabelecida com sucesso.");

            client.subscribeWith()
                    .topicFilter(TOPIC)
                    .send();

            Log.d(TAG, "Inscrito no tópico: " + TOPIC);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "Hostname inválido: " + host, e);
        } catch (Exception e) {
            Log.e(TAG, "Erro ao conectar ou se inscrever no servidor MQTT", e);
        }
    }

    private void sendMessage() {
        String message = editTextMessage.getText().toString();
        if (!message.isEmpty()) {
            client.publishWith()
                    .topic(TOPIC)
                    .payload(StandardCharsets.UTF_8.encode(message))
                    .send();
            editTextMessage.setText("");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (client != null) {
            client.disconnect();
        }
    }
}
