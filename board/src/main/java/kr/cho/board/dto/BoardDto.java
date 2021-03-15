package kr.cho.board.dto;

import kr.cho.board.domain.entity.Board;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString
public class BoardDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Board toEntity(){
        Board build = Board.builder()
                .id(id)
                .author(author)
                .title(title)
                .content(content)
                .build();

        return build;
    }
    @Builder
    public BoardDto(Long id, String author, String title, String content, LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
