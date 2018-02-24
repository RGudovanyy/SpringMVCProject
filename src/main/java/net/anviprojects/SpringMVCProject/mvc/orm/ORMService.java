package net.anviprojects.SpringMVCProject.mvc.orm;

import net.anviprojects.SpringMVCProject.mvc.bean.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ORMService {

    @PersistenceContext
    private EntityManager entityManager;


    public List<User> queryFindAllUsersJPA(){
        System.out.println("ORMService: queryFindAllUsersJPA is called");
        String query = "from User order by iduser";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        return typedQuery.getResultList();
    }

    public User queryFindUserById(int id){
        System.out.println("ORMService: queryFindUserById is called");
        return entityManager.find(User.class, id);
    }

    public boolean updateUser(int id, boolean enabled){
        System.out.println("ORMService: updateUser is called");
        String query = "update user set enabled=? where iduser=?";
        Query nativeQuery = entityManager.createNativeQuery(query);
        nativeQuery.setParameter(1, enabled);
        nativeQuery.setParameter(2, id);
        int result = nativeQuery.executeUpdate();
        return result > 0;
    }

    public boolean insertUser(String username, String password, boolean enabled){
        System.out.println("ORMService: insertUser is called");
        String sql = "insert into user(username,password,enabled) values(?,?,?)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1, username);
        query.setParameter(2, password);
        query.setParameter(3, enabled);
        int result = query.executeUpdate();
        return result > 0;
    }

    public boolean deleteUser(int id){
        System.out.println();
        String sql = "delete from user where iduser=?";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1, id);
        int result = query.executeUpdate();
        return result > 0;
    }


}
