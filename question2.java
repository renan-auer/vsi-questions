/*
Explain how you would use a design pattern to decouple your code from a third-party
library that might be replaced in the future. Describe the advantages and limitations of
your chosen approach, and provide a small code snippet illustrating its application.*/

public class NotificationService {
    private ThirdPartyNotifier notifier;

    public NotificationService(ThirdPartyNotifier notifier) {
        this.notifier = notifier;
    }

    public void sendNotification(String message) {
        notifier.send(message); // Direct dependency on ThirdPartyNotifier
    }
}
