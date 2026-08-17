package linkedin.repository;

import java.util.HashMap;
import java.util.Map;

import linkedin.entity.Connection;

public class ConnectionRepository {

    private Map<String, Connection>connections=new HashMap<>();


    // Connection
    public void save(Connection connection) throws Exception{
        if(connections.containsKey(connection.getId())){
            throw new Exception("Connections Already exist so  nothing new to save");
        }
        connections.put(connection.getId(), connection);
    }

    public Connection get(String id) throws Exception{
        if(!connections.containsKey(id))
            throw new Exception("Connection Doesn't exist and nothing to get");
        return connections.get(id);
    }



    public void update(Connection connection, String id ) throws Exception{
      if( !connections.containsKey(id))
      {
        throw new Exception("Connection does not exist and nothing to update");
      }

        connections.put(connection.getId() , connection);             
    }



    public void delete( String id  )throws Exception{
      if( !connections.containsKey(id))
      {
        throw new Exception("Connection does not exist and nothing to delete ");
      }

       connections.remove(id);
    }
}
