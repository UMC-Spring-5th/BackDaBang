package umc.BackDaBang.converter;

import umc.BackDaBang.domain.FoodType;
import umc.BackDaBang.domain.mapping.MemberFoodType;

import java.util.List;

public class MemberFoodTypeConverter {

    public static List<MemberFoodType> toMemberFoodTypeList(List<FoodType> foodTypes) {
        return foodTypes.stream()
                .map(foodType ->
                        MemberFoodType.builder()
                                .foodType(foodType)
                                .build()
                ).toList();
    }
}
