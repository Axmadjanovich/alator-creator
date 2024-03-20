package uz.gc.alator.creator.mapper;

public interface BaseMapper<D, E> {
    D toDto(E e);
    E toEntity(D d);
}
