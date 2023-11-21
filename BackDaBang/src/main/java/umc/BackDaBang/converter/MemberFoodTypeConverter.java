package umc.BackDaBang.converter;

import umc.BackDaBang.domain.FoodType;
import umc.BackDaBang.domain.mapping.MemberFoodType;

import java.util.List;
import java.util.stream.Collectors;

public class MemberFoodTypeConverter {
    public static List<MemberFoodType> toMemberFoodTypeList(List<FoodType> foodTypeList) {

        return foodTypeList.stream()
                .map(foodType ->
                        MemberFoodType.builder()
                                .foodType(foodType)
                                .build())
                .collect(Collectors.toList());
    }
}
