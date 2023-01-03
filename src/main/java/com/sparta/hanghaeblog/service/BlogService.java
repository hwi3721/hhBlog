package com.sparta.hanghaeblog.service;


        import com.sparta.hanghaeblog.dto.BlogRequestDto;
        import com.sparta.hanghaeblog.dto.NewDto;
        import com.sparta.hanghaeblog.entity.Blog;
        import com.sparta.hanghaeblog.repository.BlogRepository;
        import lombok.RequiredArgsConstructor;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.ArrayList;
        import java.util.List;


@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    @Transactional
    public NewDto createMemo(BlogRequestDto requestDto) {
        Blog blog = new Blog(requestDto);
        blogRepository.save(blog);
        NewDto newDto = new NewDto(blog);

        return newDto;
    }

//    @Transactional(readOnly = true)
//    public List<Memo> getMemos() {
//        return memoRepository.findAllByOrderByCreatedAtDesc();
//    }

//    @Transactional(readOnly = true)
//    public List<NewDto> getMemos() {
//        List<Memo> memos = memoRepository.findAllByOrderByCreatedAtDesc();
//        List<NewDto> newDtos = new ArrayList<>();
//        for (Memo memo : memos){
//            NewDto newDto = new NewDto(memo);
//            newDtos.add(newDto);
//        }
//        return newDtos;
//    }

    @Transactional(readOnly = true)
    public List<NewDto> getMemos() {
        List<NewDto> newDtos = new ArrayList<>();
        try {
            List<Blog> blogs = blogRepository.findAllByOrderByCreatedAtDesc();
            for (int i = 0; i < blogs.size(); i++) {
                newDtos.add(new NewDto(blogs.get(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();   //예외가 어디서 어떻게 생겼는 지 알려줌
        }
        return newDtos;
    }
    @Transactional
    public NewDto getMemo(Long id) {
        Blog target = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        NewDto newDto = new NewDto(target);

        return newDto;
    }

    @Transactional
    public NewDto update(Long id, BlogRequestDto requestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (blog.getPassword().equals(requestDto.getPassword())) {
            blog.update(requestDto);
        }
        NewDto newDto = new NewDto(blog);
        return newDto;
    }

    @Transactional
    public String deleteMemo(Long id, BlogRequestDto requestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (blog.getPassword().equals(requestDto.getPassword())) {
            blogRepository.deleteById(id);
            return "삭제되었습니다.";
        }else{
            return "비밀번호가 일치하지 않습니다.";
        }

    }
}
