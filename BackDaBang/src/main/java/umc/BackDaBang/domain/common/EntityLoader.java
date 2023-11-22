package umc.BackDaBang.domain.common;

public interface EntityLoader<T,ID> {
    T loadEntity(ID id);
}
