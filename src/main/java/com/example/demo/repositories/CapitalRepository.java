package com.example.demo.repositories;

        import com.example.demo.models.Capital;
        import org.springframework.data.repository.CrudRepository;

        import java.util.List;

public interface CapitalRepository extends CrudRepository<Capital, Long> {

        Capital findByName(String s);
}
