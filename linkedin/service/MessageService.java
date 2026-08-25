import linkedin.constants.NotificationType;
import linkedin.service.NotificationContext;

public class MessageService {

    private MessageRepository messageRepository;
    private NotificationContext notificationContext;


    public MessageService(
        MessageRepository messageRepository,
        NotificationContext notificationContext) {
    this.messageRepository = messageRepository;
    this.notificationContext = notificationContext;
}

    public void sendMessage(Message message) throws Exception
    {
       if (message == null) {
          throw new Exception("Message cannot be null");
        }

      if (message.getId() == null || message.getId().isBlank()) {
        throw new Exception("Message id cannot be null or blank");
       }

       if (message.getContent() == null || message.getContent().isBlank()) {
      throw new Exception("Message content cannot be null or blank");
    }
       messageRepository.save(message);
       Notification notification = new Notification( "Message", "Message Details",  NotificationType.MESSAGE);
       notificationContext.sendNotification(notification);
    }


    public Message getMessage(String id)  throws Exception
    {
        if(id == null || id.isBlank())
        {
             throw new Exception("Id of message to be fetched cant be null");
        }

       return messageRepository.get(id);

    }


    public void update(Message message , String id)throws Exception
    {
      if(id == null || id.isBlank())
        {
             throw new Exception("Id of message to be updated cant be null");
        }

      if( message == null)
        {
             throw new Exception("message to be updated cant be null");
        }

        if( !message.getId().equals(id))
        {
             throw new Exception("message key and id do not match");
        }

        messageRepository.update(message , id); 
    }


    public void delete(String id)throws Exception
    {
        if(id == null || id.isBlank())
        {
             throw new Exception("Id of message to be updated cant be null");
        }

        messageRepository.delete(id);
    }
    
}
