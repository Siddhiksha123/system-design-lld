import java.util.List;

import linkedin.service.NotificationContext;
import linkedin.repository.ConversationRepository;
import linkedin.repository.MessageRepository;
import linkedin.entity.Conversation;

public class ConversationService 
{
    //to be implemented

    private MessageRepository messageRepository;
    private ConversationRepository conversationrepository;
    private NotificationContext notificationContext;



    public ConversationService (
        MessageRepository messageRepository,
        ConversationRepository conversationrepository,
        NotificationContext notificationContext) 
        {
    this.messageRepository = messageRepository;
    this.conversationrepository= conversationrepository;
    this.notificationContext = notificationContext;
    }


    public void save(Conversation conversation)throws Exception
    { 
      if(conversation == null)
      {
        throw new Exception("conversation to be saved cant be null");
      }
      conversationRepository.save(conversation);
    } 


    public void delete(String conversationId)
    {
        
      if(conversationId == null || coversationId.isBlank())
      {
        throw new Exception("conversationId is null , cant be deleted");
      }
     conversationRepository.delete(conversationId);
     
    }


    public Conversation getConversationbyId(String id)
    {
       if(id == null || id.isBlank())
      {
        throw new Exception("id is null , cant be fetched");
      }
     conversationRepository.get(id);
      
    }


    public Conversation getConversationByUserId(String UserId)
    {
       if(UserId== null || UserId.isBlank())
      {
        throw new Exception("UserId is null , cant be fetched");
      }
       conversationRepository.getConversationsByUserId(UserId);
    }



}
