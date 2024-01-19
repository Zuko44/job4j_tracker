package ru.job4j.lombok;

import lombok.*;

@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {
    @NonNull
    @EqualsAndHashCode.Include
    @Getter
    private int id;
    @Getter
    @Setter
    private String name;
}
