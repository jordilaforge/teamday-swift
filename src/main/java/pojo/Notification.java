package pojo;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
@Data
public class Notification {
    final String title;
    final LocalDateTime created;
    final int painIndex;
    final String localisation;
}
