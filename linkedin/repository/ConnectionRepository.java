package linkedin.repository;

import linkedin.entity.Conversation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import linkedin.entity.Connection;

public class ConnectionRepository {

    private Map<String, Connection> connections=new HashMap<>();


    // Connection
    public void save(Connection connection) throws Exception{
        if (connections.containsKey(connection.getId())) {
            throw new Exception("Connection already exists so nothing new to save");
        }

        if (connection.getFrom() == null || connection.getTo() == null) {
            throw new Exception("Connection must have both sender and receiver users");
        }

        connections.put(connection.getId(), connection);

        //update status to PENDING
    }


    public Connection get(String id) throws Exception{
        if(!connections.containsKey(id))
            throw new Exception("Connection Doesn't exist and nothing to get");
        return connections.get(id);
    }



    // public void update(Connection connection, String id ) throws Exception{
    //   if( !connections.containsKey(id))
    //   {
    //     throw new Exception("Connection does not exist and nothing to update");
    //   }

    //     connections.put(id , connection);             
    // }




    public void update(Connection connection, String id) throws Exception {
    if (connection == null) {
        throw new Exception("Connection cannot be null");
    }
    if (!connections.containsKey(id)) {
        throw new Exception("Connection does not exist and nothing to update");
    }
    if (!connection.getId().equals(id)) {
        throw new Exception("Connection id and update key do not match");
    }
    connections.put(id, connection);
}



    public void delete(String id) throws Exception {
    if (!conversations.containsKey(id)) {
        throw new Exception("No such conversation exists, so nothing to delete");
    }
    conversations.remove(id);
   }


    
    public List<Connection> getConnectionsByUserId(String userId) throws Exception {
        if (userId == null || userId.isBlank()) {
            throw new Exception("User id cannot be null or blank");
        }

        List<Connection> connectionlist = new ArrayList<>();

        for (Connection connection : connections.values()) {
            boolean userIsFrom = connection.getFrom().getId().equals(userId);
            boolean userIsTo = connection.getTo().getId().equals(userId);

            if (userIsFrom || userIsTo) {
                connectionlist.add(connection);
            }
        }

        return connectionlist;
         
    }




}
