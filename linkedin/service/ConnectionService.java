package linkedin.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import linkedin.constants.NotificationType;
import linkedin.constants.Status;
import linkedin.entity.Connection;
import linkedin.entity.Notification;
import linkedin.entity.User;
import linkedin.repository.ConnectionRepository;
import linkedin.repository.UserRepository;

public class  ConnectionService {

    private final ConnectionRepository connectionRepository;
    private final UserRepository userRepository;
    private final NotificationContext notificationContext;

    public ConnectionService(ConnectionRepository connectionRepository, UserRepository userRepository,
            NotificationContext notificationContext) {
        this.connectionRepository = connectionRepository;
        this.userRepository = userRepository;
        this.notificationContext = notificationContext;
    }






    public void sendConnectionRequest(Connection connection) throws Exception {
        // Check if User exist.
        User userTo = userRepository.get(connection.getTo().getEmail());
        User userFrom = userRepository.get(connection.getFrom().getEmail());

        if (userTo == null &&  userFrom == null)
            throw new Exception("User From or To is null");

        // Check existing connection
        Connection existingConnection = connectionRepository.get(connection.getId());
        if (existingConnection != null)
            throw new Exception("Connection already exist");

        // create connection request
        connectionRepository.save(connection);

        Notification notification = new Notification("Connection Request sent successfully", "Hello There I am inviting you to connect with me",
                NotificationType.CONNECTION);
        notificationContext.sendNotification(notification);
        // Observer pattern
        // From->To
    }







    public void acceptConnection(String connectionId) {
           // Check for existing connection , pass the id to repo , of exists or not 

           Connection connection1 = connectionRepository.get(connectionId);
           if( connection1 == null)
           {
              throw new Exception( "Connection does not exist" );
           }
            // if ( status == pending ) , then update status = accepted, otherwise show no pending connections
           if( connection1.getConnectionStatus() == Status.ACCEPTED)
           {
            System.out.println( "Connection is already accepted" );
           }

            if( connection1.getConnectionStatus() == Status.PENDING ){
                 connection1.setConnectionStatus(Status.ACCEPTED);
            }
            connectionRepository.update( connection1);           

            // send notification to sender .
            Notification notification = new Notification("Connection Request Accepted", "Hello There your connection request is accepted ",
                NotificationType.CONNECTION);
            notificationContext.sendNotification(notification);

        // To->From
    }







    public void declineConnection(String Id) throws Exception {
        // check if connection exist in database pass the id to repo and check the connection's existence 
        Connection connection=connectionRepository.get(Id);
        if( connection == null)
        {
            throw new Exception("Connection does not exit , nothing to decline");
        }
        // if status == pending , then call delete method   
       if( connection.getConnectionStatus() == Status.PENDING)
       {
          connectionRepository.delete(Id);
       }  
       // sending declined notification
       Notification notification = new Notification("Connection Request declined", "Hello There your connection request is declined" , NotificationType.CONNECTION );
       notificationContext.sendNotification(notification);
             
    }








    // tomorrow's to do list. 

    public List<Connection> getAcceptedConnections(String userId) throws Exception {
         
       // call the method getConnectionsByUserId from repo and get all kind of possible the connectionlists (accepted , pending ) jo database me saved h
       // for that user having userId 

        List<Connection> finalconnectionlist = new ArrayList<>();

        List<Connection> connectionlist = connectionRepository.getConnectionsByUserId(userId);

       // filterout the connections based on the status -> accepted;

       for(Connection conn : connectionlist)
       {
           if(conn.getConnectionStatus()==Status.ACCEPTED)
           {
              finalconnectionlist.add(conn);
           }
       }
       return finalconnectionlist;
    }







    public List<String> getMutualConnectionUserIds(String firstUserId,
            String secondUserId) throws Exception {
        // if (firstUserId == null || firstUserId.isBlank()
        //         || secondUserId == null || secondUserId.isBlank()) {
        //     throw new Exception("User ids cannot be null or blank");
        // }

        // Set<String> firstUserConnectionIds = new HashSet<>();
        // for (Connection connection : getAcceptedConnections(firstUserId)) {
        //     firstUserConnectionIds.add(getOtherUserId(connection, firstUserId));
        // }

        // Set<String> mutualConnectionIds = new HashSet<>();
        // for (Connection connection : getAcceptedConnections(secondUserId)) {
        //     String otherUserId = getOtherUserId(connection, secondUserId);
        //     if (firstUserConnectionIds.contains(otherUserId)
        //             && !otherUserId.equals(firstUserId)
        //             && !otherUserId.equals(secondUserId)) {
        //         mutualConnectionIds.add(otherUserId);
        //     }
        // }

        return new ArrayList<>(mutualConnectionIds);
    }

    

    private String getOtherUserId(Connection connection, String userId) {
        if (connection.getFrom().getId().equals(userId)) {
            return connection.getTo().getId();
        }
        return connection.getFrom().getId();
    }



}
