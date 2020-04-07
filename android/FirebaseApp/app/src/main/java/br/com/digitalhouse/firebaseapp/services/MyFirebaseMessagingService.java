package br.com.digitalhouse.firebaseapp.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import br.com.digitalhouse.firebaseapp.R;
import br.com.digitalhouse.firebaseapp.login.view.MainActivity;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);

        // Mandar o token para o servidor e salvar
        Log.i("TAG", "onNewToken: " + token);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        // Fazer a notificação
        if (remoteMessage.getNotification() != null && remoteMessage.getNotification().getBody() != null) {

            // Cria uma intenção explicita para direcionar o usuário quando houver o clique da notificação
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

            // Pega o titulo da notificação
            String title = remoteMessage.getNotification().getTitle();
            // Pega a mensagem da notificação
            String message = remoteMessage.getNotification().getBody();

            //Cria o canal da notificação para o usuário poder gerenciar os alertas posteriormente
            createNotificationChannel();

            // Pega o nome do canal
            CharSequence name = getString(R.string.default_notification_channel_id);

            // Pega a som default para colocar na notificação
            Uri audio = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

            // Cria a notificação com os parametros
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, name.toString())
                    .setSmallIcon(R.drawable.ic_stat_name) // Icone pequeno
                    .setContentTitle(title) // Título
                    .setContentText(message) // Mensagem
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT) // prioridade para a notificação
                    .setContentIntent(pendingIntent) // Intenção para quando for clicado
                    .setSound(audio) // Som da notificação
                    .setColor(Color.RED) // Cor do icone da notificação
                    .setAutoCancel(true); // auto-cancelar quando clicar na notificação

            // Gerenciador de notificações
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

            // Mostra a notificação com usando um ID único, caso chegue uma outra notificação
            // com o mesmo ID ela será substituida
            notificationManager.notify(1, builder.build());
        }
    }

    // Cria o canal para notificação apenas para ANDROID OREO acima
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.default_notification_channel_id);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(name.toString(), name, importance);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
