
package com.bootcamp.JPAHibernate.repository;

        import com.bootcamp.JPAHibernate.model.Actor;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {
}
