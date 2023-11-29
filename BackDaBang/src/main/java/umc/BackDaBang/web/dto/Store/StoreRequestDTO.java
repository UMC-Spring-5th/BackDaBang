package umc.BackDaBang.web.dto.Store;


import lombok.Getter;

@Getter
public class StoreRequestDTO {

    @Getter
    public static class EnrollDTO {
        String name;
        String type;
        String address;
    }

}
