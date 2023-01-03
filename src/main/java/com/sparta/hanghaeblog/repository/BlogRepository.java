package com.sparta.hanghaeblog.repository;


//import com.sparta.hanghaememo.dto.newDto;
        import com.sparta.hanghaeblog.entity.Blog;
        import org.springframework.data.jpa.repository.JpaRepository;

        import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByOrderByCreatedAtDesc();

}